package com.smartship.mds.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class Rule {
	@XmlAttribute  
	private String rChar;

	@XmlAttribute  
	private String order;

	public String getrChar() {
		return rChar;
	}

	public void setrChar(String rChar) {
		this.rChar = rChar;
	}

	public String getOrder() {
		if(order==null)
			order="0";
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Rule [rChar=" + rChar + ", order=" + order + "]";
	}
	public String getEffectiveRChar() {
		return " "+rChar;
	}

}
