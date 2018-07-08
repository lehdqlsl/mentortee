package com.mentotee.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentotee.app.dao.InquireDAO;
import com.mentotee.app.vo.InquireVO;

@Service
public class InquireService {
	@Autowired
	private InquireDAO dao;

	public int insert(InquireVO vo) {
		return dao.insert(vo);
	}
}
