package org.gagan.sap.messanger.model;

public class UserAdditionalInfoDTO {

	
	    private String emailId;
	    private String mobileNo;
	    private String designation;
	    private String bloodGroup;
	    private CompanyDTO company;
		private AddressDTO address;
		
	    public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public String getBloodGroup() {
			return bloodGroup;
		}
		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}
		public AddressDTO getAddress() {
			return address;
		}
		public void setAddress(AddressDTO address) {
			this.address = address;
		}
		
		public UserAdditionalInfoDTO()
		{
			
		}
		public UserAdditionalInfoDTO(String emailId, String mobileNo, String designation, String bloodGroup,
				int companyId,String companyName,String branchName, AddressDTO address,CompanyDTO company) {
			super();
			this.emailId = emailId;
			this.mobileNo = mobileNo;
			this.designation = designation;
			this.bloodGroup = bloodGroup;
			this.address = address;
			this.company=company;
			
		}
	
		public CompanyDTO getCompany() {
			return company;
		}
		public void setCompany(CompanyDTO company) {
			this.company = company;
		}
		
		
		
}
