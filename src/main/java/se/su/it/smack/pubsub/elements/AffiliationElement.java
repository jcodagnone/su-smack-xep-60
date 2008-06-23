/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

/**
 * TODO Descripcion de la clase. Los comenterios van en castellano.
 * 
 * 
 * @author Juan F. Codagnone
 * @since Jun 23, 2008
 */
public class AffiliationElement extends PubSubElement {
    private String affiliation;
    private String jid;
    
    /** @see PubSubElement#getName() */
    public final String getName() {
        return "affiliation";
    }

    /** @see XMPPElementSupport#toXML() */
    public final String toXML() {
        final StringBuffer sb = new StringBuffer();
        
        sb.append("<");
        sb.append(getName());
        if(affiliation != null) {
            sb.append(" affiliation='");
            sb.append(affiliation);
            sb.append("'");
        }
        
        if(jid != null) {
            sb.append(" jid='");
            sb.append(jid);
            sb.append("'");
        }
        
        sb.append("/>");
        
        return sb.toString();
    }

    public final String getAffiliation() {
        return affiliation;
    }

    public final void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public final String getJid() {
        return jid;
    }

    public final void setJid(String jid) {
        this.jid = jid;
    }
}
