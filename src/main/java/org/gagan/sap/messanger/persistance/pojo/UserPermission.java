package org.gagan.sap.messanger.persistance.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "PERMISSION")
public class UserPermission implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2596474273903682029L;
	private int id;
	private String name;
	private String description;
	private int versionId;
	private boolean deleteFl;
	private List<UserRolePermission> userRolePermissions=new ArrayList<>();

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
  

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    @OneToMany(mappedBy="permission")
	public List<UserRolePermission> getUserRolePermissions() {
		return userRolePermissions;
	}

	public void setUserRolePermissions(List<UserRolePermission> userRolePermissions) {
		this.userRolePermissions = userRolePermissions;
	}
	

	@Column(name = "VERSION_ID")
	public int getVersionId() {
		return versionId;
	}

	public void setVersionId(int versionId) {
		this.versionId = versionId;
	}

	@Column(name = "DELETE_FL")
	public boolean getDeleteFl() {
		return deleteFl;
	}

	public void setDeleteFl(boolean isDelete) {
		this.deleteFl = isDelete;
	}
	
  

}
