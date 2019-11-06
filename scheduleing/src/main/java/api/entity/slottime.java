package api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class slottime {

	@Id
	private String slotid;
	private int day;
	private String time;
	public String getSlotid() {
		return slotid;
	}
	public void setSlotid(String slotid) {
		this.slotid = slotid;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
