/*
 * Created on Aug 15, 2005
 *
 */
package se.su.it.smack.pubsub;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jivesoftware.smack.packet.IQ;
import org.xmlpull.v1.XmlPullParser;

import se.su.it.smack.packet.XMPPElement;
import se.su.it.smack.pubsub.elements.CreateElement;
import se.su.it.smack.pubsub.elements.PubSubElement;

public class PubSub extends IQ implements XMPPElement {

	private static final String NS = "http://jabber.org/protocol/pubsub";
	private String uriFragment;
	
	private XMPPElement child;
	
	private List children = new ArrayList(1);
	
	/**
	 * @deprecated
	 * @return
	 */
	public XMPPElement getChild() {
		return (XMPPElement)children.get(0);
	}
	
	/**
	 * @deprecated
	 */
	public void addChild(Object o) throws IllegalArgumentException {
		    appendChild(o);
	}
	
	/**
	 * Adds a child element for pubsub element
	 * @param o child element
	 */
	public void appendChild(Object o)
	{
        if (o instanceof XMPPElement) {
            children.add(o);
        } else {
            throw new IllegalArgumentException("<pubsub/> child must be XMPPElement");
        }
	}
	
	public PubSub() {
		super();
	}

	/**
	 * 
	 * @return
	 */
	public String getChildElementXML() {
	    String markup = "";
	    PubSubElement elem;
	    Iterator iter = children.iterator();
	    while (iter.hasNext()) {
	        elem = (PubSubElement)iter.next();
	        markup += elem.toXML();
	    }
	    return "\n<pubsub xmlns=\""+ getNamespace() +"\">\n"+ markup +"</pubsub>";
	}

	public List getChildren() {
	    return children;
	}

	/**
	 * @deprecated
	 * @param elt
	 */
	public void setChild(Object elt) {
		addChild(elt);
	}

	public String getNamespace() {
		return uriFragment == null ? NS :  (NS + uriFragment);
	}
	
	
	public static void main(String[] args) throws Exception {
		PubSub pubSub = new PubSub();
		pubSub.setFrom("leifj@su.se/test");
		pubSub.setTo("pubsub.cdr.su.se");
		pubSub.setType(IQ.Type.SET);
		pubSub.addChild(new CreateElement("test/a/node"));
		System.err.println(pubSub.toXML());
	}

	public void parse(XmlPullParser pp) throws Exception {
		throw new IllegalArgumentException("should not be called");
	}

    public final String getUriFragment() {
        return uriFragment;
    }

    public final void setUriFragment(String uriFragment) {
        this.uriFragment = uriFragment;
    }
}
