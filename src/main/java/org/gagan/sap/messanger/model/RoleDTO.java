package org.gagan.sap.messanger.model;

public class RoleDTO {
	
	private int id;
	private int Name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return Name;
	}
	public void setName(int name) {
		Name = name;
	}
	public RoleDTO(){
		
	}
	public RoleDTO(int id, int name) {
		super();
		this.id = id;
		Name = name;
	}
	

}
