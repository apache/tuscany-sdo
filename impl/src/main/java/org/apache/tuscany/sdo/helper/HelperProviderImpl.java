/**
 *
 *  Copyright 2005 The Apache Software Foundation or its licensors, as applicable.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tuscany.sdo.helper;


import org.apache.tuscany.sdo.helper.CopyHelperImpl;
import org.apache.tuscany.sdo.helper.DataHelperImpl;
import org.apache.tuscany.sdo.helper.EqualityHelperImpl;
import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.helper.CopyHelper;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.DataHelper;
import commonj.sdo.helper.EqualityHelper;
import commonj.sdo.helper.TypeHelper;
import commonj.sdo.helper.XMLHelper;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.impl.ExternalizableDelegator.Resolvable;
import commonj.sdo.impl.HelperProvider;


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
    typeHelper = SDOUtil.createTypeHelper();
    dataFactory = SDOUtil.createDataFactory(typeHelper);
    xmlHelper = SDOUtil.createXMLHelper(typeHelper);
    xsdHelper = SDOUtil.createXSDHelper(typeHelper);
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
    throw new UnsupportedOperationException(); //TODO
  }

  public Resolvable resolvable(Object target)
  {
    throw new UnsupportedOperationException(); //TODO
  }
}
