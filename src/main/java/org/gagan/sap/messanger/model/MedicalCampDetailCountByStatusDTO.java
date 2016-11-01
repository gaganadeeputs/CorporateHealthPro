package org.gagan.sap.messanger.model;

public class MedicalCampDetailCountByStatusDTO {
	
	private Long count;
	private String name;
	
	public MedicalCampDetailCountByStatusDTO()
	{
		
	}
	
	public MedicalCampDetailCountByStatusDTO(Long count,String name)
	{
		this.count=count;
		this.name=name;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
