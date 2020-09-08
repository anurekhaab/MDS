package com.smartship.mds.rules;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD)
public class ComplexRule extends Rule{
	@XmlAttribute  
	private String conditions;
	
	@XmlAttribute  
	private String pattern;
	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}
	
	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		return "ComplexRule [conditions=" + conditions + ", pattern=" + pattern + "]";
	}

}
