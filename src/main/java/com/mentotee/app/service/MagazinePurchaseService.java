package com.mentotee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.dao.CoinUseDAO;
import com.mentotee.app.dao.MagazinePurchaseDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.MagazinePurchaseVO;

@Service
public class MagazinePurchaseService {
	@Autowired
	private MagazinePurchaseDAO dao;

	@Autowired
	private AccountsDAO accounts_dao;
	
	@Autowired
	private CoinUseDAO coin_dao;

	@Transactional
	public int insert(MagazinePurchaseVO vo, AccountsVO avo) {
		int n = 0;
		int coin = avo.getCoin();
		coin = coin-10;
		avo.setCoin(coin);
		n = accounts_dao.updateCoin(avo);
		n = dao.insert(vo);
		n = coin_dao.insert(new CoinUseVO(0, avo.getAccounts_num(), 10, null,2));
		return n;
	}

	public MagazinePurchaseVO getHistory(MagazinePurchaseVO vo) {
		return dao.getHistory(vo);
	}

}
