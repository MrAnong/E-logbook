package project1.utilities.constants;

public enum Priviledges {
	RESET_PASSWORD(1, "RESET_PASSWORD"),
	ACCESS_CLASSPREFECT_PANEL(2, "ACCESS_CLASSPREFECT_PANEL"),
	ACCESS_ADMINISTRATOR_PANEL(3, "ACCESS_ADMIN_PANEL"),
	ACCESS_ADMIN_PANEL(4, "ACCESS_ADMIN_PANEL");
	
	private int id;
	private String priviledge;
	
	private Priviledges(int id, String priviledge) {
		this.id = id;
		this.priviledge = priviledge;
	}
	
	public int getPriviledgeId() {
		return id;
	}
	
	public String getAuthorityString() {
		return priviledge;
	}

}
