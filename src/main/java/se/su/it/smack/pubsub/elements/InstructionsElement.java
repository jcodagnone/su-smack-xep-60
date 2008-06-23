/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

/**
 * @author Juan F. Codagnone
 * @since Jun 19, 2008
 */
public class InstructionsElement extends PubSubElement {

    /** @see PubSubElement#getName() */
    public String getName() {
        return "instructions";
    }

    /** @see XMPPElementSupport#toXML() */
    public String toXML() {
        return "";
    }

}
