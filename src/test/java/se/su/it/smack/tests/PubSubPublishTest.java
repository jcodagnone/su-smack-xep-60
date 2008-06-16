/*
 * Created on Aug 15, 2005
 *
 */
package se.su.it.smack.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.jivesoftware.smack.PacketListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.filter.PacketFilter;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.util.StringUtils;
import se.su.it.smack.pubsub.PubSub;
import se.su.it.smack.pubsub.PubSubEvent;
import se.su.it.smack.pubsub.elements.ItemElement;
import se.su.it.smack.pubsub.elements.PublishElement;
import se.su.it.smack.utils.XMPPUtils;
import junit.framework.TestCase;

public class PubSubPublishTest extends TestCase {

	public boolean done = false;
	
	private class TracePacketListener implements PacketListener {
		private String tag;
		public TracePacketListener(String tag) {this.tag = tag;};
		public void processPacket(Packet arg0) {
			System.err.println("RECV: ["+tag+"] "+arg0.toXML());
		}
		
	}
	
	private class TraceWritePacketListener implements PacketListener {
		private String tag;
		public TraceWritePacketListener(String tag) {this.tag = tag;};
		public void processPacket(Packet arg0) {
			System.err.println("SEND: ["+tag+"] "+arg0.toXML());
		}
		
	}
	
	public void testPublish()
		throws Exception
	{
		Properties p = new Properties();
		p.load(new FileInputStream("build.properties"));
		String sjid = p.getProperty("smack.test.sender.jid");
		assertNotNull(sjid);
		String rjid = p.getProperty("smack.test.receiver.jid");
		assertNotNull(rjid);
		String pubsubService = p.getProperty("smack.test.pubsub");
		assertNotNull(pubsubService);
		String node = p.getProperty("smack.test.node");
		
		
		boolean debug = Boolean.parseBoolean(p.getProperty("smack.test.debug"));
		boolean trace = Boolean.parseBoolean(p.getProperty("smack.test.trace"));
		
		if (debug)
			XMPPConnection.DEBUG_ENABLED = true;
		
		XMPPConnection sender = new XMPPConnection(StringUtils.parseServer(sjid));
		XMPPConnection receiver = new XMPPConnection(StringUtils.parseServer(rjid));
		
		if (trace && debug)
		{
			sender.addPacketListener(new TracePacketListener("sender"),new PacketFilter() {
				public boolean accept(Packet arg0) {
					return true;
				}
			});
			sender.addPacketWriterListener(new TraceWritePacketListener("sender"),new PacketFilter() {
				public boolean accept(Packet arg0) {
					return true;
				}
			});
			
			receiver.addPacketListener(new TracePacketListener("receiver"),new PacketFilter() {
				public boolean accept(Packet arg0) {
					return true;
				}
			});
			receiver.addPacketWriterListener(new TraceWritePacketListener("receiver"),new PacketFilter() {
				public boolean accept(Packet arg0) {
					return true;
				}
			});
		}
		
		receiver.addPacketListener(new PacketListener() {
			public void processPacket(Packet packet) {
				PubSubEvent event = XMPPUtils.getPubSubEvent(packet);
				System.err.println("EVENT: "+event.toXML());
				done = true;
			}
		},new PacketFilter() { 
			public boolean accept(Packet packet) { 
				return XMPPUtils.getPubSubEvent(packet) != null;
			}
		});
		
		assertNotNull(sender);
		assertNotNull(receiver);
		sender.login(StringUtils.parseName(sjid),p.getProperty("smack.test.sender.password"),StringUtils.parseResource(sjid));
		receiver.login(StringUtils.parseName(rjid),p.getProperty("smack.test.receiver.password"),StringUtils.parseResource(rjid));
		
		PubSub pubSub = new PubSub();
		pubSub.setTo(pubsubService);
		pubSub.setType(IQ.Type.SET);
		PublishElement publish = new PublishElement(node);
		pubSub.addChild(publish);
		publish.addChild(new ItemElement(null,"<a><kaka foo=\"plupp\"/></a>"));

		Packet response = XMPPUtils.sendAndWait(sender,pubSub,100000);
		assertNotNull(response);
		assertEquals(response.getFrom(),pubsubService);
		assertNull(response.getError());
		
		while (!done)
		{
			System.err.println("Waiting for notification...");
			Thread.sleep(1000); /* allow notifications */
		}
		
		if (trace)
			Thread.sleep(100000000);
	}
	
}
