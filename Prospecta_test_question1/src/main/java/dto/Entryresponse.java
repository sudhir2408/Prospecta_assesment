package dto;

public class Entryresponse {

	
	private String api;

    private String description;

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Entryresponse(String api, String description) {
		super();
		this.api = api;
		this.description = description;
	}

	public Entryresponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
