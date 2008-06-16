/*
 * Created on Nov 8, 2005
 *
 */
package se.su.it.smack.pubsub;

import java.util.Collection;

import org.jivesoftware.smack.packet.PacketExtension;
import org.xmlpull.v1.XmlPullParser;

import se.su.it.smack.packet.XMPPElement;
import se.su.it.smack.provider.PubSubEventProvider;
import se.su.it.smack.pubsub.elements.ItemsElement;

public class PubSubEvent implements PacketExtension,XMPPElement {

	private XMPPElement child;
	
	public XMPPElement getChild() 
	{
		return child;
	}
	
	public void setChild(XMPPElement child) 
	{
		this.child = child;
	}
	
	public PubSubEvent() 
	{
		super();
	}

	public String getElementName() 
	{
		return "event";
	}

	public String getNamespace() 
	{
		return PubSubEventProvider.NS;
	}

	public String toXML() 
	{
		return "<event xmlns=\""+PubSubEventProvider.NS+"\">"+getChild().toXML()+"</event>";
	}
	
	public void addChild(Object o)
	{
		if (child != null)
			throw new IllegalStateException("Child element already set");
		
		if (o instanceof XMPPElement) {
			XMPPElement c = (XMPPElement) o;
		    setChild(c);
		}
	}

	public void parse(XmlPullParser pp) throws Exception {
		throw new IllegalStateException("Should not be called - incorrectly positioned parser");
		
	}
	
	public Collection getItems()
	{	
		XMPPElement child = getChild();
		if (child == null)
			throw new IllegalArgumentException("Uninitialized pubsub event");
		
		if (child instanceof ItemsElement) {
			ItemsElement items = (ItemsElement) child;
			return items.getChildren();
		}
		
		throw new IllegalArgumentException("Not an item notification event");
	}
	
}
