package org.gagan.sap.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserDTO {

	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	private String apiKey;
	private Date dateOfBirth;
	private String gender;
	private Date createdDate;
	private String userType;
	private String roleName;
	private String logoPath;
	private String signaturePath;
	private UserAdditionalInfoDTO userAdditionalInfo;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public UserDTO() {

	}

	public UserDTO(int userId, String firstName, String lastName, String password, String apiKey, Date dateOfBirth,
			String roleName, String gender, Date createdDate,String logoPath,String signaturePath) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.apiKey = apiKey;
		this.dateOfBirth = dateOfBirth;
		this.createdDate = createdDate;
		this.roleName = roleName;
		this.gender = gender;
		this.logoPath=logoPath;
		this.signaturePath=signaturePath;

	}

	public UserDTO(int userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public UserAdditionalInfoDTO getUserAdditionalInfo() {
		return userAdditionalInfo;
	}

	public void setUserAdditionalInfo(UserAdditionalInfoDTO userAdditionalInfoDTO) {
		this.userAdditionalInfo = userAdditionalInfoDTO;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getSignaturePath() {
		return signaturePath;
	}

	public void setSignaturePath(String signaturePath) {
		this.signaturePath = signaturePath;
	}

}