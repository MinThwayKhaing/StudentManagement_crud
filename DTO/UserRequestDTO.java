package DTO;

public class UserRequestDTO {
	private String username;
		private String userid;
		private String email;
		private String password;
		private String userrole;
		
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
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
		public String getUserrole() {
			return userrole;
		}
		public void setUserrole(String userrole) {
			this.userrole = userrole;
		}
		public String getUserid() {
			return userid;
		}
		public void setUserid(String userid) {
			this.userid = userid;
		}
}

