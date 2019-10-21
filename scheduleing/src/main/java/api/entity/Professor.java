package api.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Professor {

	@Id
	private String profid;
	private String password;
	public String getProfid() {
		return profid;
	}
	public void setProid(String profid) {
		this.profid = profid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
