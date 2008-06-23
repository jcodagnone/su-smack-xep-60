package se.su.it.smack.pubsub.elements;

import java.util.Iterator;

import se.su.it.smack.packet.XMPPElement;

/**
 * TODO Descripcion de la clase. Los comenterios van en castellano.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Jun 23, 2008
 */
public class AffiliationsElement extends PubSubElement {

    /** @see PubSubElement#getName() */
    public String getName() {
        return "affiliations";
    }

    /** @see XMPPElementSupport#toXML() */
    public String toXML() {
        final StringBuffer sb = new StringBuffer();
        sb.append("<");
        sb.append(getName());
        
        if(getNode() != null) {
            sb.append(" node='");
            sb.append(getNode());
            sb.append("'");
        }
        if(getChildren().isEmpty()) {
            sb.append("/");    
        }
        sb.append(">");
        
        for (final Iterator i = getChildren().iterator(); i.hasNext();) {
            final XMPPElement e = (XMPPElement) i.next();
            sb.append(e.toXML());
        }

        if(!getChildren().isEmpty()) {
            sb.append("</");
            sb.append(getName());
            sb.append(">");
        }
        return sb.toString();
    }

}
