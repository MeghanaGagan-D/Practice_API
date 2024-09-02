package com.pojoclass;

public class ShopperLoginPOJO {
	 public String email;
	    public String password;
	    public String role;
	    
		public ShopperLoginPOJO(String email, String password, String role) {
			super();
			this.email = email;
			this.password = password;
			this.role = role;
		}
		
		public ShopperLoginPOJO() {}
		
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
	    
	    
	    
	    
}
