package com.beingjavaguys.domain;



public class EquipmentMaster {
	
	private int SNO;
	private String equipment_Name;
	private String description;
	private int regNO;
	
	public int getRegNO() {
		return regNO;
	}
	public void setRegNO(int regNO) {
		this.regNO = regNO;
	}
	public String getEquipment_Name() {
		return equipment_Name;
	}
	public void setEquipment_Name(String equipment_Name) {
		this.equipment_Name = equipment_Name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getSNO() {
		return SNO;
	}
	public void setSNO(int sNO) {
		SNO = sNO;
	}
	
}
