/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

/**
 * <title>
 * 
 * 
 * @author Juan F. Codagnone
 * @since Jun 19, 2008
 */
public class TitleElement extends PubSubElement {

    /** @see PubSubElement#getName() */
    public String getName() {
        return "title";
    }

    /** @see XMPPElementSupport#toXML() */
    public final String toXML() {
        return "<title/>";
    }

}
