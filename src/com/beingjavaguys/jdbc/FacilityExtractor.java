package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.beingjavaguys.domain.EquipmentMaster;
import com.beingjavaguys.domain.EquipmentType;

public class FacilityExtractor implements ResultSetExtractor<EquipmentType> {

	public EquipmentType extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		List userList = new ArrayList();
		EquipmentType Type = new EquipmentType();
		System.out.println("result: "+resultSet.toString());
		System.out.println("result: "+resultSet.getString(2));
		Type.setEquipment_Type_Id(resultSet.getInt(1));
		Type.setNAME(resultSet.getString(2));
		Type.setDate(resultSet.getDate(3));
		Type.setMobility_Status(resultSet.getString(4));
		System.out.println("Type:" +Type);
		
		return Type;
	}

}


