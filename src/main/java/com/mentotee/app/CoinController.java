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
import com.mentotee.app.vo.CoinPurchaseVO;
import com.mentotee.app.vo.MagazinePurchaseVO;

@RestController
public class CoinController {
	@Autowired
	CoinPurchaseService service;

	@Autowired
	AccountsService accounts_service;

	// 코인 구매
	@RequestMapping(value = { "/coin/purchase" }, method = RequestMethod.POST)
	public HashMap<String, Object> purchase(@RequestBody Map<String, Object> data) {
		HashMap<String, Object> map = new HashMap<String, Object>();

		int accounts_num = ((Integer) data.get("accounts_num")).intValue();
		String productId = (String) data.get("productId");
		int coin = 0;

		if (productId.equals("coin100")) {
			coin = 100;
		} else if (productId.equals("coin300")) {
			coin = 300;
		} else if (productId.equals("coin500")) {
			coin = 500;
		} else if (productId.equals("coin1000")) {
			coin = 1000;
		} else if (productId.equals("coin3000")) {
			coin = 3000;
		} else {
			System.out.println("debug: " + productId);
		}

		AccountsVO vo = accounts_service.getInfo(accounts_num);
		service.insert(new CoinPurchaseVO(0, accounts_num, coin, null), vo);
		map.put("responseCode", Integer.valueOf(200));

		return map;
	}
	
	// 코인 구매
	@RequestMapping(value = { "/coin/purchase/{accounts_num}" }, method = RequestMethod.GET)
	public HashMap<String, Object> history(@PathVariable("accounts_num") int accounts_num) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		List<CoinPurchaseVO> list = service.getHistory(accounts_num);
		map.put("responseCode", "200");
		map.put("length", Integer.valueOf(list.size()));
		map.put("coinList", list);

		return map;
	}
}
