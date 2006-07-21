package org.apache.tuscany.sdo.test;

import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.DataFactory;
import commonj.sdo.helper.XSDHelper;

public final class SubstitutionValuesTestCase extends TestCase
{
  public void test() throws IOException
  {
    URL url = getClass().getResource("/SubstitutionValues.xsd");
    XSDHelper.INSTANCE.define(url.openStream(), url.toString());

    final DataObject  object = DataFactory.INSTANCE.create("http://www.apache.org/tuscany/SubstitutionValues", "TestObject");
    final Type  type = object.getType();
    
    assertNotNull( SDOUtil.getSubstitutionValues(object, type.getProperty("groupHead")));
    assertNull( SDOUtil.getSubstitutionValues(object, type.getProperty("nonGroupHead")));
  }
}