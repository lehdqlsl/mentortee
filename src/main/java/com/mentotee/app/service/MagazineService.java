package com.mentotee.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentotee.app.dao.MagazineDAO;
import com.mentotee.app.vo.MagazineVO;

@Service
public class MagazineService {
	@Autowired
	private MagazineDAO dao;

	public int insert(MagazineVO vo) {
		return dao.insert(vo);
	}
	
	public List<MagazineVO> getList(){
		return dao.getList();
	}
}
