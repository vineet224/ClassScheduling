package api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


public class Slotinfo {
	
	private String slotid;
	private String profid;
	private String subjectid;
	private String status;
	public String getSlotid() {
		return slotid;
	}
	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}
	public String getProfid() {
		return profid;
	}
	public void setProfid(String profid) {
		this.profid = profid;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
