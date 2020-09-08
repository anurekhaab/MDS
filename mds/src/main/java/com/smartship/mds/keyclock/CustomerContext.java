package com.smartship.mds.keyclock;



import java.util.List;

public class CustomerContext {
	
	private String realm;
	
	private String resourceClient;
	
	private List<String> allowedClients;

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getResourceClient() {
		return resourceClient;
	}

	public void setResourceClient(String resourceClient) {
		this.resourceClient = resourceClient;
	}

	public List<String> getAllowedClients() {
		return allowedClients;
	}

	public void setAllowedClients(List<String> allowedClients) {
		this.allowedClients = allowedClients;
	}

	public CustomerContext(String realm, String resourceClient, List<String> allowedClients) {
		super();
		this.realm = realm;
		this.resourceClient = resourceClient;
		this.allowedClients = allowedClients;
	}
	
	

}
