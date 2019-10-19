package api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Slotdt {

	@Id
	private String slotid;
	private String day;
	private String time;
	public String getSlotid() {
		return slotid;
	}
	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
