package com.sample.mybatis;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mysql.cj.x.json.JsonArray;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
@WebAppConfiguration
public class MemberProfileTest {
	@Autowired
	private AccountsDAO dao;

	@Test
	public void insert() throws ParseException, org.json.simple.parser.ParseException {
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj = (JSONObject) jsonParser.parse("interest=[123,456,789]");
		JSONArray memberArray = (JSONArray) jsonObj.get("members");
		System.out.println(memberArray);
		System.out.println("앙");
		/*String str = "1993-03-19";
		java.util.Date date = new java.util.Date(); 
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		date = sdf.parse(str);
		int n = dao.insert(new AccountsVO(0, "lehdqlsl@naver.com","1234","이동빈","취미","관심사", "소개말", 1,1,1, 1, 1,sdf.format(date), null, null, null, null, null, null, 0, "경기도 남양주시 화도읍"));
		System.out.println(n);*/
	}

	@Test
	public void getInfo() {
		List<AccountsVO> list = dao.getList();

		for (AccountsVO vo : list) {
			System.out.println(vo.getName());
		}
	}

}
