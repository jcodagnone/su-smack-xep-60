/*
 * Copyright (c) 2008 Zauber S.A.  -- All rights reserved
 */
package se.su.it.smack.pubsub.elements;

/**
 * Example 199. Entity subscribes to a collection node (with configuration)
 * <verbatim>
 * <iq type='set'
 *     from='francisco@denmark.lit/barracks'
 *     to='pubsub.shakespeare.lit'
 *     id='collsub2'>
 *   <pubsub xmlns='http://jabber.org/protocol/pubsub'>
 *     <subscribe jid='francisco@denmark.lit'
 *                node='blogs'/>
 *     <options>
 *       <x xmlns='jabber:x:data' type='submit'>
 *         <field var='FORM_TYPE' type='hidden'>
 *           <value>http://jabber.org/protocol/pubsub#subscribe_options</value>
 *         </field>
 *         <field var='pubsub#subscription_type'>
 *           <value>items</value>
 *         </field>
 *         <field var='pubsub#subscription_depth'>
 *           <value>all</value>
 *         </field>
 *       </x>
 *    </options>
 *  </pubsub>
 * </iq>
 * </verbatim>
 */ 
public class OptionsElement extends ConfigureElement {

    /** @see ConfigureElement#getName() */
    public String getName() {
        return "options";
    }
}
