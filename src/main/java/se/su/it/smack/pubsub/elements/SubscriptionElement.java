package se.su.it.smack.pubsub.elements;

import se.su.it.smack.pubsub.elements.PubSubElement;

/**
 * This Element represents a entity subscribing to a node
 * @author goern
 *
 */
public class SubscriptionElement extends PubSubElement {
	private String jid;
	private String subscription;
	private String affiliation;
	private String subid;

	public final String getSubid() {
        return subid;
    }

    public final void setSubid(String subid) {
        this.subid = subid;
    }

    public final String getAffiliation() {
        return affiliation;
    }

    public final void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getName() {
		return "subscription";
	}

	public String getJid() {
		return this.jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	public String getSubscription() {
		return this.subscription;
	}

	public void setSubscription(String subscription) {
		this.subscription = subscription;
	}

	public SubscriptionElement(String node, String jid) {
		super(node);
		setJid(jid);
	}
	public SubscriptionElement(String node, String jid, String subscription) {
		super(node);
		setJid(jid);
		setSubscription(subscription);
	}

	public SubscriptionElement(String node) {
		super(node);
	}

	public SubscriptionElement() {
		super();
	}

	/**
	 * @see http://www.jabber.org/jeps/jep-0060.html#entity-configure
	 */
	public String toXML() {
		StringBuffer buf = new StringBuffer();
		buf.append("<").append(getName());

		if (getNode() != null)
			buf.append(" node=\"").append(getNode()).append("\"");

		if (getJid() != null)
			buf.append(" jid=\"").append(getJid()).append("\"");
		
		if (getSubid() != null)
            buf.append(" subid=\"").append(getSubid()).append("\"");
		
		if (getAffiliation() != null)
            buf.append(" affiliation=\"").append(affiliation).append("\"");

		if (getSubscription() != null)
			buf.append(" subscription=\"").append(getSubscription()).append("\"");

		buf.append("/>");

		return buf.toString();
	}

}
