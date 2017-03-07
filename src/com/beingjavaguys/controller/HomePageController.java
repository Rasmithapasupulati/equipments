package com.beingjavaguys.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beingjavaguys.domain.EquipmentMaster;
import com.beingjavaguys.domain.EquipmentType;
import com.beingjavaguys.domain.User;
import com.beingjavaguys.services.UserService;

@Controller
public class HomePageController {

	@Autowired
	UserService userService;

	@RequestMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		List<String> typeList = new ArrayList<String>();
		List<EquipmentType> userList = userService.getEquipmentTypeList();
		
System.out.println("Equipment Type List: " +userList.get(0).getNAME());
	for(int i =0;i<userList.size(); i++){
		typeList.add(userList.get(i).getNAME());
	}
		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		//List<String> typeList = new ArrayList<String>();
		
		
		Map<String, List> map = new HashMap<String, List>();
		map.put("genderList", genderList);
		map.put("typeList", typeList);
		return new ModelAndView("register", "map", map);
	}

	@RequestMapping("/insert")
	public String inserData(@ModelAttribute User user) {
		if (user != null)
			userService.insertData(user);
		return "redirect:/getList";
	}

	/*@RequestMapping("/getList")
	public ModelAndView getUserLIst() {
		List<User> userList = userService.getUserList();
		System.out.println("UserList: "+userList);
		return new ModelAndView("userList", "userList", userList);
	}*/
	@RequestMapping("/getList")
	public ModelAndView getUserLIst() {
		List<EquipmentMaster> userLists = userService.getEquipmentMasterList();
		System.out.println("UserList: "+userLists.get(0).getEquipment_Name());
		return new ModelAndView("userLists", "userLists", userLists);
	}
	@RequestMapping("/edit")
	public ModelAndView editUser(@RequestParam String id,
			@ModelAttribute User user) {

		user = userService.getUser(id);

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		List<String> cityList = new ArrayList<String>();
		cityList.add("delhi");
		cityList.add("gurgaon");
		cityList.add("meerut");
		cityList.add("noida");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		map.put("user", user);

		return new ModelAndView("edit", "map", map);

	}
	
	@RequestMapping("/update")
	public String updateUser(@ModelAttribute User user) {
		userService.updateData(user);
		return "redirect:/getList";

	}
	@RequestMapping("/qrservlet")
	public String getQRcode(@ModelAttribute User user) {
		System.out.println("test one");
		userService.updateData(user);
		return "redirect:/getList";

	}

	@RequestMapping("/delete")
	public String deleteUser(@RequestParam String id) {
		System.out.println("id = " + id);
		userService.deleteData(id);
		return "redirect:/getList";
	}
}