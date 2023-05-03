package dto;

public class Entrydetails {
	
	 private String api;

	    private String link;

	    private String description;

	    private String auth;

	    private boolean https;

	    private String cors;

	    private String category;

		public String getApi() {
			return api;
		}

		
		// all getter setter //
		public void setApi(String api) {
			this.api = api;
		}

		public String getLink() {
			return link;
		}

		public void setLink(String link) {
			this.link = link;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getAuth() {
			return auth;
		}

		public void setAuth(String auth) {
			this.auth = auth;
		}

		public boolean isHttps() {
			return https;
		}

		public void setHttps(boolean https) {
			this.https = https;
		}

		public String getCors() {
			return cors;
		}

		public void setCors(String cors) {
			this.cors = cors;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}


		public Entrydetails() {
			super();
			// TODO Auto-generated constructor stub
		}


		@Override
		public String toString() {
			return "Entrydetails [api=" + api + ", link=" + link + ", description=" + description + ", auth=" + auth
					+ ", https=" + https + ", cors=" + cors + ", category=" + category + "]";
		}


		public Entrydetails(String api, String link, String description, String auth, boolean https, String cors,
				String category) {
			super();
			this.api = api;
			this.link = link;
			this.description = description;
			this.auth = auth;
			this.https = https;
			this.cors = cors;
			this.category = category;
		}

	   
}
