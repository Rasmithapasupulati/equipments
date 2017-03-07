package com.beingjavaguys.dao;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.beingjavaguys.domain.EquipmentMaster;
import com.beingjavaguys.domain.EquipmentType;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.jdbc.FacilityRowMapper;
import com.beingjavaguys.jdbc.MasterRowMapper;
import com.beingjavaguys.jdbc.UserRowMapper;

public class UserDaoImpl implements UserDao {

	@Autowired
	DataSource dataSource;

	public void insertData(User user) {

		String sql = "INSERT INTO user "
				+ "(first_name,last_name, gender, city) VALUES (?, ?, ?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity() });

	}

	public List<User> getUserList() {
		List userList = new ArrayList();

		String sql = "select * from user";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	@Override
	public void deleteData(String id) {
		String sql = "delete from user where user_id=" + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sql);

	}

	@Override
	public void updateData(User user) {

		String sql = "UPDATE user set first_name = ?,last_name = ?, gender = ?, city = ? where user_id = ?";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(
				sql,
				new Object[] { user.getFirstName(), user.getLastName(),
						user.getGender(), user.getCity(), user.getUserId() });

	}

	@Override
	public User getUser(String id) {
		List<User> userList = new ArrayList<User>();
		String sql = "select * from user where user_id= " + id;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList.get(0);
	}


	public List<EquipmentType> getEquipmentTypeList() {
		List userList = new ArrayList();
		String sql = "select * from Equipment_Type_Master";
		System.out.println("SQL result: "+sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userList = jdbcTemplate.query(sql, new FacilityRowMapper());
		System.out.println("userList: "+userList);
		return userList;
	}
	
	@Override
	public List<EquipmentMaster> getEquipmentMasterList() {
		List userLists = new ArrayList();
		String sql = "select * from Equipment_Master";
		System.out.println("SQL result123: "+sql);
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		userLists = jdbcTemplate.query(sql, new MasterRowMapper());
		System.out.println("userLists: "+userLists);
		return userLists;
	}

}
