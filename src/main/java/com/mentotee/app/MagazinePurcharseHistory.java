package com.mentotee.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mentotee.app.service.AccountsService;
import com.mentotee.app.service.CoinPurchaseService;
import com.mentotee.app.service.MagazinePurchaseService;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.MagazinePurchaseVO;

@RestController
public class MagazinePurcharseHistory {
	@Autowired
	MagazinePurchaseService service;

	@Autowired
	AccountsService accounts_service;

	@Autowired
	CoinPurchaseService coin_service;
	
	// 구매 내역 확인
	@RequestMapping(value = { "/magazine/{accounts_num}/{b_num}" }, method = RequestMethod.GET)
	public HashMap<String, Object> history(@PathVariable("accounts_num") int accounts_num,
			@PathVariable("b_num") int b_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		MagazinePurchaseVO vo = service.getHistory(new MagazinePurchaseVO(0, accounts_num, b_num, null));

		if (vo != null) {
			// 구매함
			map.put("responseCode", Integer.valueOf(200));
		} else {
			// 구매하지 않음
			map.put("responseCode", Integer.valueOf(201));
		}
		return map;
	}

	// 구매
	@RequestMapping(value = { "/magazine/purchase" }, method = RequestMethod.POST)
	public HashMap<String, Object> purchase(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		int accounts_num = ((Integer) data.get("accounts_num")).intValue();
		int b_num = ((Integer) data.get("b_num")).intValue();

		AccountsVO vo = accounts_service.getInfo(accounts_num);

		if (vo.getCoin() >= 10) {
			service.insert(new MagazinePurchaseVO(0, accounts_num, b_num, null), vo);
			// 성공
			map.put("responseCode", Integer.valueOf(200));
		} else {
			// 실패
			map.put("responseCode", Integer.valueOf(201));
		}

		return map;
	}

	// 코인 사용 목록
	@RequestMapping(value = { "/coinuse/{accounts_num}" }, method = RequestMethod.GET)
	public HashMap<String, Object> purchase(@PathVariable("accounts_num") int accounts_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		List<CoinUseVO> list = coin_service.getCoinUseHistory(accounts_num);
		
		map.put("responseCode", 200);
		map.put("data", list);
		
		return map;
	}
}
