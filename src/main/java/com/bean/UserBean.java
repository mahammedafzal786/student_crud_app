package com.bean;

public class UserBean {

		private int id  ;
		private String  username ;
		private String  emailid  ;
		private String  password ;
		
		public UserBean() {

			
		}

		public UserBean(int id, String username, String emailid, String password) {
			super();
			this.id = id;
			this.username = username;
			this.emailid = emailid;
			this.password = password;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getEmailid() {
			return emailid;
		}

		public void setEmailid(String emailid) {
			this.emailid = emailid;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		
	
}
