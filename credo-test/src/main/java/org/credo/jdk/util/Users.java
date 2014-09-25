package org.credo.jdk.util;

import java.util.Date;

public class Users {

	private String name;
	private Date time;
	
	public Users(String name,Date time) {
		this.name=name;
		this.time=time;
	}
	
	public String getName() {

		return name;
	}
	public void setName(String name) {

		this.name = name;
	}
	public Date getTime() {

		return time;
	}
	public void setTime(Date time) {

		this.time = time;
	}
	
	public static void main(String[] args) {

		String partNo = "CA661-1233".replace("CE", "CH");
		System.out.println(partNo);
	}
}
