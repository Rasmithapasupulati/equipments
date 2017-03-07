package com.beingjavaguys.domain;

import java.util.Date;

public class EquipmentType {

	private int Equipment_Type_Id;
	private String NAME;
	private Date Date;
	private String Mobility_Status;
	
	
	public int getEquipment_Type_Id() {
		return Equipment_Type_Id;
	}

	public void setEquipment_Type_Id(int equipment_Type_Id) {
		this.Equipment_Type_Id = equipment_Type_Id;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public Date getDate() {
		return Date;
	}

	public void setDate(Date date) {
		Date = date;
	}

	public String getMobility_Status() {
		return Mobility_Status;
	}

	public void setMobility_Status(String mobility_Status) {
		Mobility_Status = mobility_Status;
	}

	
}
