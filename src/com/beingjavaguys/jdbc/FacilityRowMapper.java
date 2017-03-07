package com.beingjavaguys.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.beingjavaguys.domain.EquipmentMaster;
import com.beingjavaguys.domain.EquipmentType;

public class FacilityRowMapper implements RowMapper<EquipmentType> {

	
	public EquipmentType mapRow(ResultSet resultSet, int line) throws SQLException {
		FacilityExtractor facilityExtractor = new FacilityExtractor();
		return facilityExtractor.extractData(resultSet);
	}
	
}




























