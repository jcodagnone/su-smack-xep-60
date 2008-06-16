/*
 * Created on Aug 15, 2005
 *
 */
package se.su.it.smack.pubsub.elements;

public class PublishElement extends PubSubElement {
	
	public boolean isSingleChild() { return true; }
	
	public String getName() {
		return "publish";
	}

	public PublishElement() { super(); }
	
	public PublishElement(String node) { super(node); }

    public String toXML() {
        return "  <publish node='"+this.getNode()+"'/>\n";
    }
}
