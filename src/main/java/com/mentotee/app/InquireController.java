package com.mentotee.app;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.service.InquireService;
import com.mentotee.app.service.MatchService;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.InquireVO;
import com.mentotee.app.vo.MatchingsSignVO;
import com.mentotee.app.vo.MatchingsVO;

import util.PushService;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InquireController {
	@Autowired
	private InquireService service;
	@Autowired
	private AccountsService accounts_service;

	// 매칭 신청
	@RequestMapping(value = { "/inquire" }, method = RequestMethod.POST)
	public HashMap<String, Object> test(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		 
		int accounts_num = ((Integer) data.get("accounts_num")).intValue();
		String title = (String) data.get("title");
		String contents = (String) data.get("contents");
		int type = ((Integer) data.get("type")).intValue();
		
		int n = service.insert(new InquireVO(0, accounts_num, title, contents, type, null));
		
		if(n>0)
			map.put("responseCode",200);
		else
			map.put("responseCode",201);
		return map;
	}
	
	// 매칭 신청
	@RequestMapping(value = { "/inquire/{test}" }, method = RequestMethod.GET)
	public HashMap<String, Object> test1(@PathVariable("test") int test) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("test", test);
		return map;
	}
}
