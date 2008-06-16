package se.su.it.smack.pubsub.elements;

/**
 * 6.2 Unsubscribe from a Node
 * 6.2.1 Request
 *
 * To unsubscribe from a node, the subscriber sends an IQ-set whose 
 * &lt;pubsub/&gt; child contains an &lt;unsubscribe/&gt; element that specifies 
 * the node and the subscribed JID.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Jun 14, 2008
 */
public class UnsubscribeElement extends PubSubElement {
    private String jid;

    public UnsubscribeElement(String node, String jid) {
        super(node);
        setJid(jid);
    }
    
    public UnsubscribeElement(String node) {
        super(node);
    }

    public UnsubscribeElement() {
        super();
    }
    
    /** @see PubSubElement#getName() */
    @Override
    public final String getName() {
        return "unsubscribe";
    }

    public String getJid() {
        return this.jid;
    }

    public void setJid(String jid) {
        this.jid = jid;
    }

    /** @see XMPPElementSupport#toXML() */
    @Override
    public final String toXML() {
        StringBuffer buf = new StringBuffer();
        buf.append("<").append(getName());
        
        if (getNode() != null)
            buf.append(" node=\"").append(getNode()).append("\"");
        
        if (getJid() != null)
            buf.append(" jid=\"").append(getJid()).append("\"");
            
        buf.append("/>");

        return buf.toString();
    }
}
