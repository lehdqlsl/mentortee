package com.mentotee.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.dao.CoinPurchaseDAO;
import com.mentotee.app.dao.CoinUseDAO;
import com.mentotee.app.dao.MagazinePurchaseDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.CoinPurchaseVO;
import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.MagazinePurchaseVO;

@Service
public class CoinPurchaseService {
	@Autowired
	private CoinPurchaseDAO dao;

	@Autowired
	private AccountsDAO accounts_dao;

	@Autowired CoinUseDAO coin_dao;
	
	@Transactional
	public int insert(CoinPurchaseVO vo, AccountsVO avo) {
		int n = 0;
		
		avo.setCoin(avo.getCoin()+vo.getCoin());
		n = accounts_dao.updateCoin(avo);
		n = dao.insert(vo);
		return n;
	}

	public List<CoinPurchaseVO> getHistory(int accounts_num) {
		return dao.getHistory(accounts_num);
	}
	
	public List<CoinUseVO> getCoinUseHistory(int accounts_num) {
		return coin_dao.getHistory(accounts_num);
	}
}
