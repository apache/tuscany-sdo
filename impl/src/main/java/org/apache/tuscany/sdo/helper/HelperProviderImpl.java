/**
 *
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.tuscany.sdo.helper;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.ObjectStreamException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.tuscany.sdo.util.DataObjectUtil;
import org.apache.tuscany.sdo.util.resource.SDOObjectInputStream;

import commonj.sdo.DataGraph;
import commonj.sdo.DataObject;
import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLDocument;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.HelperProvider;
import commonj.sdo.impl.ExternalizableDelegator.Resolvable;


/**
 * Create and manage all the default helper INSTANCEs
 */
public class HelperProviderImpl extends HelperProvider
{
  protected CopyHelper copyHelper;

  protected DataFactory dataFactory;

  protected DataHelper dataHelper;

  protected EqualityHelper equalityHelper;

  protected TypeHelper typeHelper;

  protected XMLHelper xmlHelper;

  protected XSDHelper xsdHelper;

  public HelperProviderImpl()
  {
    //FB HelperContext hc = SDOUtil.createHelperContext();
    //FB The defulat HelperContext must use EMF's ClassLoader-delegating EPackage.Registry.INSTANCE, until we provide
    //FB another way to get (ClassLoader scope) support for HelperContext.
    HelperContext hc = new HelperContextImpl(new SDOExtendedMetaDataImpl(), false);
    typeHelper = hc.getTypeHelper();
    dataFactory = hc.getDataFactory();
    xmlHelper = hc.getXMLHelper();
    xsdHelper = hc.getXSDHelper();
    copyHelper = new CopyHelperImpl();
    equalityHelper = new EqualityHelperImpl();
    dataHelper = new DataHelperImpl();
  }

  public CopyHelper copyHelper()
  {
    return copyHelper;
  }

  public DataFactory dataFactory()
  {
    return dataFactory;
  }

  public DataHelper dataHelper()
  {
    return dataHelper;
  }

  public EqualityHelper equalityHelper()
  {
    return equalityHelper;
  }

  public TypeHelper typeHelper()
  {
    return typeHelper;
  }

  public XMLHelper xmlHelper()
  {
    return xmlHelper;
  }

  public XSDHelper xsdHelper()
  {
    return xsdHelper;
  }

  public Resolvable resolvable()
  {
    return new ResolvableImpl();
  }

  public Resolvable resolvable(Object target)
  {
    return new ResolvableImpl(target);
  }

  protected class ResolvableImpl implements Resolvable
  {
    protected Object target;
    
    public ResolvableImpl(Object target) { this.target = target; }
    
    public ResolvableImpl() { this.target = null; }

    public void writeExternal(ObjectOutput out) throws IOException
    {
      if (target instanceof DataObject)
      {
        writeDataObject((DataObject)target, out);
      }
      else
      {
        throw new NotSerializableException(); // should never happen
      }
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
      target = readDataObject(in);
    }

    public Object readResolve() throws ObjectStreamException
    {
      return target;
    }
    
    protected void writeDataObject(DataObject dataObject, ObjectOutput objectOutput) throws IOException
    {
      DataGraph dataGraph = dataObject.getDataGraph();
      if (dataGraph != null)
      {
        objectOutput.writeByte(0);
        objectOutput.writeUTF(DataObjectUtil.getXPath(dataObject));
        objectOutput.writeObject(dataGraph);
      }
      else if (dataObject.getContainer() != null)
      {
        objectOutput.writeByte(0);
        objectOutput.writeUTF(DataObjectUtil.getXPath(dataObject));
        objectOutput.writeObject(dataObject.getRootObject());
      }
      else
      {
        // Root object
        objectOutput.writeByte(1);

        ByteArrayOutputStream compressedByteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(compressedByteArrayOutputStream);
        XMLHelper xmlHelperLocal = xmlHelper;
        if(objectOutput instanceof SDOObjectInputStream)
        {
            xmlHelperLocal = ((SDOObjectInputStream)objectOutput).getHelperContext().getXMLHelper();
        }
        xmlHelperLocal.save(dataObject, "commonj.sdo", "dataObject", gzipOutputStream);
        gzipOutputStream.close(); // Flush the contents

        byte[] byteArray = compressedByteArrayOutputStream.toByteArray();
        objectOutput.writeInt(byteArray.length);
        objectOutput.write(byteArray);
      }
    }

    protected DataObject readDataObject(ObjectInput objectInput) throws IOException, ClassNotFoundException
    {
      boolean isRoot = objectInput.readByte() == 1;
      if (isRoot)
      {
        // Root object: [rootXML] = length + XML contents
        int length = objectInput.readInt();
        byte[] compressedBytes = new byte [length];
        objectInput.read(compressedBytes, 0, length);
        
        GZIPInputStream gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressedBytes));
        XMLHelper xmlHelperLocal = xmlHelper;
        if(objectInput instanceof SDOObjectInputStream)
        {
            xmlHelperLocal = ((SDOObjectInputStream)objectInput).getHelperContext().getXMLHelper();
        }
        XMLDocument doc = xmlHelperLocal.load(gzipInputStream);
        gzipInputStream.close();

        return doc.getRootObject();
      }
      else
      {
        // Non root object: [path] [root]
        String xpath = objectInput.readUTF();
        Object object = objectInput.readObject();
        
        DataObject root = object instanceof DataGraph ? ((DataGraph)object).getRootObject() : (DataObject)object;
        return xpath.equals("") ? root : root.getDataObject(xpath);
      }
    }
  }
}
