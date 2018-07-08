package com.mentotee.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mentotee.app.dao.MatchDAO;
import com.mentotee.app.service.MatchService;
import com.mentotee.app.vo.MatchingsSignVO;
import com.mentotee.app.vo.MatchingsVO;

@Component
public class Schedule {

	@Autowired
	MatchService service;
	
    public void executeJob(){
    	
    	List<MatchingsVO> list = service.isExpire();
    	
    	for(MatchingsVO vo : list) {
    		vo.setState(4);
    		service.setState(vo);
    	}
    }
}
