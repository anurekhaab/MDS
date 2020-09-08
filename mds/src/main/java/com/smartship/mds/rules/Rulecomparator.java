package com.smartship.mds.rules;

import java.util.Comparator;

class Rulecomparator implements Comparator<Rule> 
{ 
    public int compare(Rule a, Rule b) 
    { 
    	return a.getOrder().compareTo(b.getOrder()); 
    	
    } 
}