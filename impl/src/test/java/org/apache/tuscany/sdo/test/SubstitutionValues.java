package org.apache.tuscany.sdo.test;

import java.net.URL;

import commonj.sdo.DataObject;
import commonj.sdo.Type;
import commonj.sdo.helper.XSDHelper;
import commonj.sdo.helper.DataFactory;
import org.apache.tuscany.sdo.util.SDOUtil;

public final class SubstitutionValues extends junit.framework.TestCase
{
  public void test() throws java.io.IOException
  {
    URL url = getClass().getResource("/SubstitutionValues.xsd");
    XSDHelper.INSTANCE.define(url.openStream(), url.toString());

    final DataObject  object = DataFactory.INSTANCE.create("http://www.apache.org/tuscany/SubstitutionValues", "TestObject");
    final Type  type = object.getType();
    
    assertNotNull( SDOUtil.getSubstitutionValues(object, type.getProperty("groupHead")));
    assertNull( SDOUtil.getSubstitutionValues(object, type.getProperty("nonGroupHead")));
  }
}