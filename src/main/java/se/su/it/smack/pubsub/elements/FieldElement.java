package se.su.it.smack.pubsub.elements;

import java.util.Iterator;

import se.su.it.smack.packet.XMPPElement;

/**
 * Example:
 * <field label="Short name for the node" var="pubsub#title" >
 *   <value/>
 * </field>
 * 
 * @author Juan F. Codagnone
 * @since Jun 13, 2008
 */
public class FieldElement extends PubSubElement {
    private String label;
    private String var;
    
    /** @see PubSubElement#getName() */
    public String getName() {
        return "field";
    }

    /** @see XMPPElementSupport#toXML() */
    public final String toXML() {
        final StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(getName());
        if(var != null) {
            sb.append(" var='");
            sb.append(var);
            sb.append("'");
        }
        
        if(label != null) {
            sb.append(" label='");
            sb.append(label);
            sb.append("'");
        }
        sb.append(">");
        
        for (Iterator i = getChildren().iterator(); i.hasNext();) {
            final XMPPElement e = (XMPPElement) i.next();
            sb.append(e.toXML());
        }
        sb.append("</");
        sb.append(getName());
        sb.append(">");
        
        return sb.toString();
    }

    public final String getLabel() {
        return label;
    }

    public final void setLabel(final String label) {
        this.label = label;
    }

    public final String getVar() {
        return var;
    }

    public final void setVar(final String var) {
        this.var = var;
    }
}
