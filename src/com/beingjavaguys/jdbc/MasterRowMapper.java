package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beingjavaguys.domain.EquipmentMaster;

public class MasterRowMapper implements RowMapper<EquipmentMaster> {

		public EquipmentMaster mapRow(ResultSet resultSet, int line) throws SQLException {
		MasterExtractor	masterExtractor  = new MasterExtractor();
		System.out.println("Master RowMaper");
		System.out.println("rs : "+resultSet.getInt(6));
		return 	masterExtractor .extractData(resultSet);
	}

	
}
