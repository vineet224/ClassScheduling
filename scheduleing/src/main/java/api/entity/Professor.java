package api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Professor {

	@Id
	private String prfoid;
	private String subjectid;
	private String password;
	public String getPrfoid() {
		return prfoid;
	}
	public void setPrfoid(String prfoid) {
		this.prfoid = prfoid;
	}
	public String getSubjectid() {
		return subjectid;
	}
	public void setSubjectid(String subjectid) {
		this.subjectid = subjectid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
