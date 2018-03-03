package com.mentotee.app;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.vo.AccountsVO;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@Autowired
	AccountsService accounts_service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = { "/accounts" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> test1(HttpServletRequest request) {
		HashMap<String, Object> map = new HashMap();
		map.put("abcaa", "ddeeed");

		return map;
	}

	@RequestMapping(value = { "/accounts/{id}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> getInfo(@PathVariable("id") int id) {
		HashMap<String, Object> map = new HashMap();
		List<AccountsVO> list = new ArrayList();
		AccountsVO vo = this.accounts_service.getInfo(id);
		if (vo != null) {
			map.put("responseCode", "200");
			HashMap<String, Object> data = new HashMap();
			data.put("s_email", vo.getEmail());
			data.put("s_name", vo.getName());
			data.put("s_interest", vo.getInterest());
			data.put("ui_coin", Integer.valueOf(vo.getCoin()));
			data.put("b_is_mentor", Integer.valueOf(vo.getMentor()));
			data.put("type_id", Integer.valueOf(vo.getJob()));

			data.put("date_birth", vo.getBirth());
			data.put("t_greeting", vo.getGreeting());
			data.put("t_career", vo.getCareer());
			data.put("t_hobby", vo.getHobby());
			data.put("date_accepted", vo.getAccepted());

			map.put("data", data);
			list.add(vo);
			map.put("data2", list);
		} else {
			map.put("responseCode", "400");
		}
		return map;
	}

	@RequestMapping(value = { "/mentees" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> getMentees() {
		HashMap<String, Object> map = new HashMap();

		List<AccountsVO> list = this.accounts_service.getMentees();

		map.put("responseCode", "200");
		map.put("data", list);

		return map;
	}

	@RequestMapping(value = { "/mentors" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> getMentors() {
		HashMap<String, Object> map = new HashMap();

		List<AccountsVO> list = this.accounts_service.getMentors();
		map.put("responseCode", "200");
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = { "/accounts" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, consumes = { "application/json" })
	public HashMap<String, Object> test2(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap();

		int state = ((Integer) data.get("state")).intValue();
		if (state == 1) {
			String email = (String) data.get("email");
			String password = (String) data.get("password");
			String name = (String) data.get("name");

			String s_gender = (String) data.get("gender");
			int gender;

			if (s_gender.equals("m")) {
				gender = 0;
			} else {
				gender = 1;
			}
			String s_mentor = (String) data.get("type");

			int type;
			if (s_mentor.equals("mentor")) {
				type = 1;
			} else {
				type = 0;
			}
			String birth = (String) data.get("birth");
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = sdf.parse(birth);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			AccountsVO vo = new AccountsVO(email, password, name, type, gender, sdf.format(date));
			this.accounts_service.insert(vo);
			map.put("responseCode", Integer.valueOf(201));
		} else if (state == 2) {
			int id = ((Integer) data.get("id")).intValue();
			int job = ((Integer) data.get("company")).intValue();
			String address = (String) data.get("address");
			String greeting = (String) data.get("greeting");
			String hobby = (String) data.get("hobby");
			int careeryears = ((Integer) data.get("careeryears")).intValue();
			String wish = (String) data.get("wish");
			String career = (String) data.get("career");
			String interest = data.get("interest").toString();
			AccountsVO vo = new AccountsVO(id, hobby, wish, greeting, job, careeryears, 2, null, null, null, null, null,
					null, address, interest, career, null);
			int n = this.accounts_service.update(vo);
			if (n > 0) {
				map.put("responseCode", Integer.valueOf(201));
			} else {
				map.put("responseCode", Integer.valueOf(500));
			}
		}
		return map;
	}

	@RequestMapping(value = { "/accounts/findEmail" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> getinfo(HttpServletRequest request, String email) {
		HashMap<String, Object> map = new HashMap();

		AccountsVO vo = this.accounts_service.getInfo(email);
		if (vo != null) {
			map.put("responseCode", Integer.valueOf(200));
		} else {
			map.put("responseCode", Integer.valueOf(201));
		}
		return map;
	}

	@RequestMapping(value = { "/login" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public HashMap<String, Object> getinfo(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap();

		AccountsVO vo = new AccountsVO();

		vo = this.accounts_service.getInfo((String) data.get("email"));
		if (vo != null) {
			BCryptPasswordEncoder bcr = new BCryptPasswordEncoder();
			boolean res = bcr.matches((String) data.get("password"), vo.getPassword());
			if (vo.getState() == 1) {
				map.put("responseCode", Integer.valueOf(202));
				map.put("account_id", Integer.valueOf(vo.getAccounts_num()));
			} else if (res) {
				map.put("responseCode", Integer.valueOf(201));
				map.put("account_id", Integer.valueOf(vo.getAccounts_num()));
			} else {
				map.put("responseCode", Integer.valueOf(400));
			}
		} else {
			map.put("responseCode", Integer.valueOf(400));
		}
		return map;
	}

	@RequestMapping(value = { "/tokens" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public HashMap<String, Object> tokens(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap();

		AccountsVO vo = new AccountsVO();

		String token = (String) data.get("token");
		int accounts_num = (Integer) data.get("account_id");

		vo.setToken(token);
		vo.setAccounts_num(accounts_num);

		int n = this.accounts_service.updateToken(vo);
		if (n > 0) {
			map.put("responseCode", Integer.valueOf(200));
		} else {
			map.put("responseCode", Integer.valueOf(400));
		}
		return map;
	}

}
