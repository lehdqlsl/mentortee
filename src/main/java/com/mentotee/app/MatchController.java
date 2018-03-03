package com.mentotee.app;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.service.MatchService;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.MatchingsVO;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MatchController {
	@Autowired
	private MatchService match_service;
	@Autowired
	private AccountsService accounts_service;

	@RequestMapping(value = { "/matching" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	public HashMap<String, Object> matching(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String,Object>();

		int mentor_id = ((Integer) data.get("mentor_number")).intValue();
		int mentee_id = ((Integer) data.get("mentee_number")).intValue();

		MatchingsVO vo = new MatchingsVO(0, mentor_id, mentee_id, 1, null, null, null, null);
		
		try {
			int n = this.match_service.insert(vo);
			if (n > 0) {
				String baseUrl = "https://android.googleapis.com/gcm/send";

				AccountsVO avo = this.accounts_service.getInfo(mentor_id);
				AccountsVO mvo = this.accounts_service.getInfo(mentee_id);
				RestTemplate restTemplate = new RestTemplate();

				JSONObject parameters = new JSONObject();
				JSONObject param = new JSONObject();
				param.put("type", Integer.valueOf(1));
				param.put("title", "���� ��û");
				param.put("message", mvo.getName() + "������ ���� ���� ��û�� �Խ��ϴ�.");
				parameters.put("to", avo.getToken());
				parameters.put("content_available", Boolean.valueOf(true));
				parameters.put("priority", "high");
				parameters.put("data", param);

				restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
				HttpEntity<?> requestEntity = apiClientHttpEntity("json", parameters.toString());
				ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity,
						String.class, new Object[0]);

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
		MatchingsVO vo = new MatchingsVO(0, mentor_id, mentee_id, state, null, null, null, null);
		try {
			int n = this.match_service.update(vo);
			if (n > 0) {
				String baseUrl = "https://android.googleapis.com/gcm/send";

				AccountsVO mentee = this.accounts_service.getInfo(mentee_id);
				AccountsVO mentor = this.accounts_service.getInfo(mentor_id);

				RestTemplate restTemplate = new RestTemplate();

				JSONObject parameters = new JSONObject();
				JSONObject param = new JSONObject();
				param.put("type", Integer.valueOf(1));
				param.put("title", "���� ��û");
				if (state == 2) {
					param.put("message", mentor.getName() + "�԰��� ���� ��û�� ü��Ǿ����ϴ�.");
				} else {
					param.put("message", mentor.getName() + "������ ���� ���� ��û�� �����Ǿ����ϴ�.");
				}
				parameters.put("to", mentee.getToken());
				parameters.put("content_available", Boolean.valueOf(true));
				parameters.put("priority", "high");
				parameters.put("data", param);

				restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
				HttpEntity<?> requestEntity = apiClientHttpEntity("json", parameters.toString());
				ResponseEntity<String> responseEntity = restTemplate.exchange(baseUrl, HttpMethod.POST, requestEntity,
						String.class, new Object[0]);

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

	private HttpEntity<?> apiClientHttpEntity(String appType, String params) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set("Authorization", "key=AIzaSyCuJZDLGW4xr6d-gVNICgx_wf9dfUAHLoo");
		requestHeaders.set("Content-Type", "application/" + appType);
		return new HttpEntity(params, requestHeaders);
	}
}
