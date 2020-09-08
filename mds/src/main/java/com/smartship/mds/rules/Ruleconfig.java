package com.smartship.mds.rules;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement  
@XmlAccessorType(XmlAccessType.FIELD)
public class Ruleconfig {
	
	@XmlElement
	private List<SimpleRule> simplerule;

	@XmlElement
	private List<ComplexRule> complexrule;

	public List<SimpleRule> getSimplerule() {
		return simplerule;
	}

	public void setSimplerule(List<SimpleRule> simplerule) {
		this.simplerule = simplerule;
	}

	public List<ComplexRule> getComplexrule() {
		return complexrule;
	}

	public void setComplexrule(List<ComplexRule> complexrule) {
		this.complexrule = complexrule;
	}

	@Override
	public String toString() {
		return "Ruleconfig [simplerule=" + simplerule + ", complexrule=" + complexrule + "]";
	}


}
