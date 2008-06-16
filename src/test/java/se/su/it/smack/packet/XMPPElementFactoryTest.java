package se.su.it.smack.packet;

import junit.framework.TestCase;

public class XMPPElementFactoryTest extends TestCase {

	public void testXMPPElementFactoryCreate() throws Exception {

		String name = "subscribe-options";

		XMPPElement element = XMPPElementFactory.create(name);

		assertNotNull(element);
		assertEquals(element.getClass().getName(), "se.su.it.smack.pubsub.elements.SubscribeOptionsElement");
	}

}
package se.su.it.smack.packet;

import junit.framework.TestCase;

public class XMPPElementFactoryTest extends TestCase {

	public void testXMPPElementFactoryCreate() throws Exception {

		String name = "subscribe-options";

		XMPPElement element = XMPPElementFactory.create(name);

		assertNotNull(element);
		assertEquals(element.getClass().getName(), "se.su.it.smack.pubsub.elements.SubscribeOptionsElement");
	}

}
