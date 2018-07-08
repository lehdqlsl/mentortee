package com.mentotee.app;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.service.MatchService;
import com.mentotee.app.vo.AccountsVO;
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
public class MatchController {
	@Autowired
	private MatchService match_service;
	@Autowired
	private AccountsService accounts_service;

	// 매칭 신청
	@RequestMapping(value = { "/matching" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public HashMap<String, Object> matching(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		int mentor_id = ((Integer) data.get("mentor_number")).intValue();
		int mentee_id = ((Integer) data.get("mentee_number")).intValue();

		MatchingsVO vo = new MatchingsVO(0, mentor_id, mentee_id, 1, null, null, null, null);

		try {
			int n = this.match_service.insert(vo);
			if (n > 0) {

				AccountsVO avo = this.accounts_service.getInfo(mentor_id);
				AccountsVO mvo = this.accounts_service.getInfo(mentee_id);

				JSONObject param = new JSONObject();
				param.put("type", Integer.valueOf(1));
				param.put("title", "매칭 신청");
				param.put("message", mvo.getName() + "님께서 맨토신청을 하였습니다.");

				PushService.SendPush(param, avo.getToken());
				map.put("responseCode", Integer.valueOf(200));
			}
		} catch (Exception e) {
			map.put("responseCode", Integer.valueOf(400));
		}
		return map;
	}

	@RequestMapping(value = { "/matching/result" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	public HashMap<String, Object> result(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap();

		int mentor_id = ((Integer) data.get("mentor_id")).intValue();
		int mentee_id = ((Integer) data.get("mentee_id")).intValue();
		int state = ((Integer) data.get("state")).intValue();
		
		AccountsVO mentee = this.accounts_service.getInfo(mentee_id);
		AccountsVO mentor = this.accounts_service.getInfo(mentor_id);
		if(mentee.getCoin() < 500) {
			//멘티 코인 부족
			JSONObject param = new JSONObject();
			param.put("type", Integer.valueOf(1));
			param.put("title", "코인 부족");
			param.put("message", "코인이 부족하여 멘토 체결을 실패하였습니다. 코인을 충전해주세요.");
			PushService.SendPush(param, mentee.getToken());
			map.put("responseCode",202);
			return map;
		}
		
		if(mentor.getCoin() < 500) {
			//멘토 코인 부족
			map.put("responseCode",201);
			return map;
		}		
		
		MatchingsVO vo = new MatchingsVO(0, mentor_id, mentee_id, state, null, null, null, null);
		try {
			int n = this.match_service.update(vo,mentee,mentor);
			if (n > 0) {

				JSONObject param = new JSONObject();
				param.put("type", Integer.valueOf(1));
				param.put("title", "멘토 체결");
				if (state == 2) {
					param.put("message", mentor.getName() + "님과의 멘토 신청이 체결되었습니다.");
				} else {
					param.put("message", mentor.getName() + "님이 멘토 신청을 거절하였습니다.");
				}
				PushService.SendPush(param, mentee.getToken());
				map.put("responseCode", Integer.valueOf(200));
			}
		} catch (Exception e) {
			map.put("responseCode", Integer.valueOf(400));
		}
		return map;
	}

	@RequestMapping(value = { "/matching/{id}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> matchingList(@PathVariable("id") int id) {
		HashMap<String, Object> map = new HashMap();

		AccountsVO avo = this.accounts_service.getInfo(id);
		List<AccountsVO> a_list = new ArrayList();
		List<MatchingsVO> state_list = new ArrayList();
		if (avo.getMentor() == 1) {
			List<MatchingsVO> list = this.match_service.getMenteeList(id);
			for (MatchingsVO vo : list) {
				a_list.add(this.accounts_service.getInfo(vo.getMentee_id()));
				state_list.add(vo);
			}
			map.put("responseCode", "200");
			map.put("dataLength", Integer.valueOf(list.size()));
			map.put("data", a_list);
			map.put("state", state_list);
		} else {
			List<MatchingsVO> list = this.match_service.getMentorList(id);
			for (MatchingsVO vo : list) {
				a_list.add(this.accounts_service.getInfo(vo.getMentor_id()));
				state_list.add(vo);
			}
			map.put("responseCode", "200");
			map.put("dataLength", Integer.valueOf(list.size()));
			map.put("data", a_list);
			map.put("state", state_list);
		}
		return map;
	}
	
	@RequestMapping(value = { "/matching/sign/{id}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	public HashMap<String, Object> matchingList2(@PathVariable("id") int id) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		AccountsVO avo = this.accounts_service.getInfo(id);

		//멘토
		if (avo.getMentor() == 1) {
			List<MatchingsSignVO> list = this.match_service.getMatchingMentees(id);
			map.put("responseCode", "200");
			map.put("dataLength", Integer.valueOf(list.size()));
			map.put("data", list);
		} else {
			List<MatchingsSignVO> list = this.match_service.getMatchingMentors(id);
			map.put("responseCode", "200");
			map.put("dataLength", Integer.valueOf(list.size()));
			map.put("data", list);
		}
		return map;
	}
	
	@RequestMapping(value = { "/matching/renewal" }, method = RequestMethod.POST)
	public HashMap<String, Object> matchingRenewal(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		
		int accounts_num = ((Integer) data.get("accounts_num")).intValue();
		int matchings_num = ((Integer) data.get("matchings_num")).intValue();
		
		AccountsVO vo = accounts_service.getInfo(accounts_num);
		
		if(vo.getCoin() < 650) {
			map.put("responseCode", "201");
		}else {
			match_service.setRenewal(matchings_num, vo);
			map.put("responseCode", "200");
		}

		return map;
	}
}
