package com.smartship.mds.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class SimpleRule extends Rule{

	
	@XmlAttribute  
	private String rWChar;
	@XmlAttribute  
	private String applyFirst;
	@XmlAttribute  
	private String applyLast;
	
	@XmlAttribute  
	private String rWord;

	public String getrWChar() {
		return rWChar;
	}

	public void setrWChar(String rWChar) {
		this.rWChar = rWChar;
	}

	public String getApplyFirst() {
		return applyFirst;
	}

	public void setApplyFirst(String applyFirst) {
		this.applyFirst = applyFirst;
	}

	public String getApplyLast() {
		return applyLast;
	}

	public void setApplyLast(String applyLast) {
		this.applyLast = applyLast;
	}

	@Override
	public String toString() {
		return "SimpleRule [rWChar=" + rWChar + ", applyFirst=" + applyFirst + ", applyLast=" + applyLast + "]";
	}

	public String getEffectiveRWChar() {
		return " "+rWChar+" ";
	}

	

}
