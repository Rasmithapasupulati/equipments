package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.beingjavaguys.domain.EquipmentMaster;

public class MasterExtractor implements ResultSetExtractor<EquipmentMaster> {

	public EquipmentMaster extractData(ResultSet resultSet) throws SQLException,
			DataAccessException {
		List userList = new ArrayList();
		EquipmentMaster Type = new EquipmentMaster();
		System.out.println("result: "+resultSet.toString());
		//System.out.println("result: "+resultSet.getString(2));
		Type.setSNO(resultSet.getInt(4));
		Type.setEquipment_Name(resultSet.getString(3));
		Type.setDescription(resultSet.getString(5));
		Type.setRegNO(resultSet.getInt(6));
		System.out.println("Type:" +Type);
		
		return Type;
	}

}
