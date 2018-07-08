package com.mentotee.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mentotee.app.dao.AccountsDAO;
import com.mentotee.app.dao.CoinPurchaseDAO;
import com.mentotee.app.dao.CoinUseDAO;
import com.mentotee.app.dao.EventDAO;
import com.mentotee.app.dao.MagazinePurchaseDAO;
import com.mentotee.app.vo.AccountsVO;
import com.mentotee.app.vo.CoinPurchaseVO;
import com.mentotee.app.vo.CoinUseVO;
import com.mentotee.app.vo.EventVO;
import com.mentotee.app.vo.MagazinePurchaseVO;

@Service
public class EventService {
	@Autowired
	private EventDAO dao;

	public int insert(EventVO vo) {
		return dao.insert(vo);
	}

	public int update(EventVO vo) {
		return dao.update(vo);
	}
	
	public EventVO getInfo(int id) {
		return dao.getInfo(id);
	}
}
