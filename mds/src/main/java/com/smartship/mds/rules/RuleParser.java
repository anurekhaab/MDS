package com.smartship.mds.rules;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;

public class RuleParser {
	static  int count =0;
	public static void main(String[] args) {
		try {
			File file = new File("src/main/resources/Rule.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Ruleconfig.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Ruleconfig r = (Ruleconfig) jaxbUnmarshaller.unmarshal(file);
			
			
			List<Tag> list = ReadExcelFileToList.readExcelData("src/main/resources/mds_test.xlsx");
			
			//List<String> inputsList= Arrays.asList(" #1 CARGO TK EXTREMELY-H ( S ) L C S W" );
			//inputsList.forEach(a -> System.out.println(a + "---------" + replaceString(a, r)));
			list.stream().forEach(a -> System.out.println(a + "---------" + replaceString(a, r)));
			System.out.println("SUCCCESS count  "+count +"  Total Count "+list.size());
		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

public static String replaceString(Tag tag,Ruleconfig r) {
	
	String tagName=tag.getMakersTagName();
	List<SimpleRule> simplerules=r.getSimplerule();
	List<ComplexRule> complexrules=r.getComplexrule();
	
	Collections.sort(simplerules, new Rulecomparator());
	Collections.sort(complexrules, new Rulecomparator());
	
	
	List<SimpleRule> applyFirst=simplerules.stream().filter(n->("Y").equals(n.getApplyFirst())).collect(Collectors.toList());
	List<SimpleRule> applyRest=simplerules.stream().filter(n->!("Y").equals(n.getApplyFirst()) && !("Y").equals(n.getApplyLast())).collect(Collectors.toList());
	List<SimpleRule> applylast=simplerules.stream().filter(n->("Y").equals(n.getApplyLast())).collect(Collectors.toList());
	
	
	for (SimpleRule rule: applyFirst) {
		tagName=tagName.replace(rule.getrChar(), rule.getrWChar());
	}
	
	List<String> tokenList=Arrays.asList(StringUtils.split(tagName));
	
	  for (SimpleRule rule : applyRest) { 
		  if(tokenList.contains(rule.getrChar())) {
			  tagName=tagName.replace(rule.getEffectiveRChar(), rule.getEffectiveRWChar());
		  }
	  } 
	  //tagName =StringUtils.normalizeSpace(tagName);

	 
	 
	  for (ComplexRule rule: complexrules) {
		  int a=0;
		  int i=0; 
		  if(tagName.contains(rule.getrChar()))
			  if("$N".equals(rule.getPattern()))
			  {
				  a=tagName.indexOf(rule.getrChar());
				  a=a+rule.getrChar().length();
				  String intnum="";
				  while(Character.isDigit(tagName.charAt(a)) || tagName.charAt(a)==' ') {
					
					  intnum=intnum+tagName.charAt(a);
					  a++;
				  }
				  System.out.println(rule.getrChar()+"____"+a+"DDDDDDDDDDDDDDDDDD"+intnum+"tag-----"+tag.getMakersTagName());
				 i=Integer.parseInt(intnum.trim());
			  }
		  
		 List<String> intnum= Arrays.asList(rule.getConditions().split(";"));
		 List<String []> listarray=intnum.stream().map(str -> str.split(":"))
		  .collect(Collectors.toList());
		 String intval="";
		 for (String[] array : listarray) {
			if(tagName.contains(array[0])) {
				 if(array[2].equals("2")) {
					intval=intval+"0";
				}
				intval=Integer.toString(i);
				tagName=tagName.replace(array[0], array[0]+array[1].replace(rule.getPattern(), intval));
				tagName=tagName.replace(rule.getrChar(), "").replaceFirst(intval, "");
				tagName =StringUtils.normalizeSpace(tagName);
			}
		}
		
			
		}
	  
		
		  for (SimpleRule rule: applylast)
		  { 
			  tagName=tagName.replace(rule.getrChar(),rule.getrWChar()).replace("__", "_"); 
		  }
		 
	  if(tagName.equals(tag.getSmartShipTagName())) {
		  System.out.println("SUCCCESS");
		  count++;
	  }
	  
	  
	  
	return tagName;
}

}