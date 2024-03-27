package project1.utilities.constants;

public enum Roles {
	STUDENT("ROLE_STUDENT"),
	CLASSPREFECT("ROLE_CLASS_PREFECT"),
	TEACHER("ROLE_TEACHER"),
	ADMINISTRATION("ROLE_ADMINISTRATION"),
	ADMIN("ROLE_ADMIN");
	
	private String role;
	
	Roles(String role) {
		this.role = role;
	}
	
	public String getRole() {
		return role;
	}

}
