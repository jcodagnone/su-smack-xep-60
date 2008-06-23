package se.su.it.smack.pubsub.elements;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.dom2_builder.DOM2XmlPullBuilder2;

/**
 * Example:24/src/main/java/se/su/it/smack/pubsub/elements/FieldElement.java
 *  <field label="Allow subscriptions to node" var="pubsub#subscribe" >
 *    <value>1</value>
 *  </field>
 * 
 * @author Juan F. Codagnone
 * @since Jun 13, 2008
 */
public class ValueElement extends PubSubElement implements ContentableElement {
    private String content;
    
    /** @see PubSubElement#getName() */
    public final String getName() {
        return "value";
    }

    /** @see XMPPElementSupport#toXML() */
    public final String toXML() {
        String ret;
        if(content == null) {
            ret = "<" + getContent() + "/>"; 
        } else {
            ret = "<" + getName() + ">"
                + content
                + "</" +  getName() + ">";
        }
        return ret;
    }
    
    public String getContent() {
        return content;
    }

    /** @see ContentableElement#setContent(java.lang.String) */
    public void setContent(String content) {
        this.content = content;
    }
}
