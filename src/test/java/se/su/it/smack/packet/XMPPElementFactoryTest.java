package se.su.it.smack.packet;

import java.io.InputStreamReader;
import java.util.List;

import junit.framework.TestCase;

import org.xmlpull.mxp1.MXParser;
import org.xmlpull.v1.XmlPullParser;

import se.su.it.smack.provider.PubSubProvider;
import se.su.it.smack.pubsub.PubSub;
import se.su.it.smack.pubsub.elements.SubscriptionElement;
import se.su.it.smack.pubsub.elements.SubscriptionsElement;

public class XMPPElementFactoryTest extends TestCase {

	public void testXMPPElementFactoryCreate() throws Exception {

		String name = "subscribe-options";

		XMPPElement element = XMPPElementFactory.create(name);

		assertNotNull(element);
		assertEquals(element.getClass().getName(), "se.su.it.smack.pubsub.elements.SubscribeOptionsElement");
	}

	public void testSubscriptions() throws Exception {
	    final XmlPullParser pp = new MXParser();
	    pp.setInput(new InputStreamReader(getClass().getResourceAsStream(
	            "subscriptions.xml")));
	    final PubSubProvider psp = new PubSubProvider();
	    final PubSub pubsub = (PubSub) psp.parseIQ(pp);
	    final SubscriptionsElement subscriptions = (SubscriptionsElement) pubsub.getChildren().get(0);
	    final List<SubscriptionElement> lists = subscriptions.getChildren();
	    assertEquals(7, lists.size());
        pubsub.getChildren();
	    
    }
}
