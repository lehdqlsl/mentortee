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
	
	public List<MagazineVO> getList(int type){
		if(type == 0) {
			return dao.getNoList();	
		}else {
			return dao.getList();
		}
	}

	public int auth(String b_num) {
		return dao.setAuth(b_num);
	}
	
	public MagazineVO getMagazine(String b_num) {
		return dao.getMagazine(b_num);
	}
}
