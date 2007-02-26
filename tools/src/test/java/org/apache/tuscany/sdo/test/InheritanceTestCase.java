package org.apache.tuscany.sdo.test;

import java.io.IOException;

import junit.framework.TestCase;

import org.apache.tuscany.sdo.util.SDOUtil;

import com.example.subgroup.A;
import com.example.subgroup.B;
import com.example.subgroup.Bprime;
import com.example.subgroup.SubgroupFactory;
import com.example.subgroup.impl.AImpl;
import commonj.sdo.DataObject;
import commonj.sdo.helper.HelperContext;
import commonj.sdo.helper.XMLDocument;

public class InheritanceTestCase extends TestCase {

	private HelperContext scope;

	public void testSubGroupLoad() throws IOException {
		XMLDocument doc = scope.getXMLHelper().load(
		    getClass().getResourceAsStream("/subgroup1.xml"));
		assertEquals("a", doc.getRootElementName());
		String strdoc = scope.getXMLHelper().save(
				doc.getRootObject(), doc.getRootElementURI(), doc.getRootElementName());
		assertTrue(strdoc.indexOf("<sg:imInTypeB>thisIsElB</sg:imInTypeB>") != -1);
	}

	public void testSubGroup_AcontainsB() {
		A a = (A) scope.getDataFactory().create(A.class);
		B b = (B) scope.getDataFactory().create(B.class);
		b.setImInTypeB("thisIsElB");
		a.setGe1(b);

		assertSame(b, a.getGe1());
		assertSame(b, ((AImpl) a).get(AImpl.GE1));

		String doc = scope.getXMLHelper().save((DataObject) a,
		    "http://example.com/subgroup", "a");
		assertTrue(doc.indexOf("<sg:imInTypeB>thisIsElB</sg:imInTypeB>") != -1);

	}

	public void testSubGroup_AcontainsBprime() {
		A a = (A) scope.getDataFactory().create(A.class);
		Bprime bp = (Bprime) scope.getDataFactory().create(Bprime.class);
		bp.setImInTypeBprime("thisIsElBprime");
		a.setGe1(bp);

		assertSame(bp, a.getGe1());
		assertSame(bp, ((AImpl) a).get(AImpl.GE1));

		String doc = scope.getXMLHelper().save((DataObject) a,
		    "http://example.com/subgroup", "a");
		
		assertTrue(doc.indexOf("<sg:imInTypeBprime>thisIsElBprime</sg:imInTypeBprime>") != -1);

	}

	public void testSubGroup_Bprime() {
		Bprime bp = (Bprime) scope.getDataFactory().create(Bprime.class);
		bp.setImInTypeB("bValue");
		bp.setImInTypeBprime("bpvalue");
		String doc = scope.getXMLHelper().save((DataObject) bp,
		    "http://example.com/subgroup", "bp");
		assertTrue(doc.indexOf("<sg:imInTypeB>bValue</sg:imInTypeB>") != -1);
		assertTrue(doc.indexOf("<sg:imInTypeBprime>bpvalue</sg:imInTypeBprime>") != -1);
	}

	protected void setUp() throws Exception {
		super.setUp();
		scope = SDOUtil.createHelperContext();

		SubgroupFactory.INSTANCE.register(scope);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
