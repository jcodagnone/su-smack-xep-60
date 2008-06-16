/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

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
    @Override
    public String getName() {
        return "subscriptions";
    }

    /** @see XMPPElementSupport#toXML() */
    @Override
    public String toXML() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<").append(getName());
        
        if(getChildren() != null && !getChildren().isEmpty()) {
            sb.append(">\n");
            final List<SubscriptionElement> subscriptions = getChildren();
            for (final SubscriptionElement subscription : subscriptions) {
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