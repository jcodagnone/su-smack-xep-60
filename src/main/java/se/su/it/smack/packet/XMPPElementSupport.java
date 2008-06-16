/*
 * Created on Aug 15, 2005
 *
 */
package se.su.it.smack.packet;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.xmlpull.v1.XmlPullParser;

public abstract class XMPPElementSupport implements XMPPElement {

	private List children;
	
	public XMPPElementSupport() {
		super();
		this.children = new ArrayList();
	}

	public List getChildren() {
		return children;
	}
	
	public boolean isSingleChild()
	{
		return false;
	}

	public void addChild(Object elt) {
		synchronized(children) {
			if (isSingleChild())
				setChild(elt);
			else
				synchronized(children) { children.add(elt); }
		}
	}
	
	protected void setChild(Object elt) {
		if (children.size() == 0)
			children.add(elt);
		else
			children.set(0,elt);
	}
	
	public XMPPElement getChild()
	{
		return (XMPPElement)children.get(0);
	}
	
	public abstract String toXML();

	public void parse(XmlPullParser pp) throws Exception
	{
		pp.require(XmlPullParser.START_TAG,null,null);
		for (int i = 0; i < pp.getAttributeCount(); i++)
		{
			BeanUtils.setProperty(this,pp.getAttributeName(i),pp.getAttributeValue(i));
		}
	}
	
}
