package com.smartship.mds.rules;
public class Tag {

	private String makersTagName;
	private String smartShipTagName;
	
	
	public Tag(String makersTagName, String smartShipTagName) {
		super();
		this.makersTagName = makersTagName;
		this.smartShipTagName = smartShipTagName;
	}
	public String getMakersTagName() {
		return makersTagName;
	}
	public void setMakersTagName(String makersTagName) {
		this.makersTagName = makersTagName;
	}
	public String getSmartShipTagName() {
		return smartShipTagName;
	}
	public void setSmartShipTagName(String smartShipTagName) {
		this.smartShipTagName = smartShipTagName;
	}
	@Override
	public String toString() {
		return "Tag [makersTagName=" + makersTagName + ", smartShipTagName=" + smartShipTagName + "]";
	}
	
	
	
}