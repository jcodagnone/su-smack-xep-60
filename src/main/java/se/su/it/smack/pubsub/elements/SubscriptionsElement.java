/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

import java.util.Iterator;
import java.util.List;

import se.su.it.smack.packet.XMPPElementSupport;

/**
 * 5.6 Retrieve Subscriptions<br/>
 * An entity may want to query the service to retrieve its subscriptions for 
 * all nodes at the service. Support for this feature ("retrieve-subscriptions")
 *  is RECOMMENDED.
 * <br/>
 * In order to make the request, the requesting entity MUST send an IQ-get 
 * whose <pubsub/> child contains an empty <subscriptions/> element with 
 * no attributes.
 * 
 * @author Juan F. Codagnone
 * @since Jun 15, 2008
 */
public class SubscriptionsElement extends PubSubElement {
   
    /** @see PubSubElement#getName() */
    public String getName() {
        return "subscriptions";
    }

    /** @see XMPPElementSupport#toXML() */
    public String toXML() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<").append(getName());
        
        if(getNode() != null) {
            /*
             * Example 24. Entity requests current subscriptions from a specific node
             * 
             * <iq type='get' from='francisco@denmark.lit/barracks'
             *                to='pubsub.shakespeare.lit'
             *                id='subscriptions2'>
             *   <pubsub xmlns='http://jabber.org/protocol/pubsub'>
             *      <subscriptions node='princely_musings'/>
             *   </pubsub>
             * </iq>
             */
           sb.append(" node=\"");
           sb.append(getNode());
           sb.append("\"");
        }
        if(getChildren() != null && !getChildren().isEmpty()) {
            sb.append(">\n");
            final List subscriptions = getChildren();
            for (final Iterator i = subscriptions.iterator(); i.hasNext();) {
                SubscriptionElement subscription = (SubscriptionElement) i.next();
                sb.append("\t");
                sb.append(subscription.toXML());
                sb.append("\n");
            }
            sb.append("</" + getName() + ">");
        } else {
            sb.append("/>");
        }

        return sb.toString();
    }

}
