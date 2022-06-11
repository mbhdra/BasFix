package com.mbhdra.basfix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.SeasonDao;
import com.mbhdra.basfix.model.Season;

@Service
public class SeasonService {
	
	@Autowired
	SeasonDao dao;
	
	public void addSeason(String startingYear, String endingYear) {
		
		Season season = new Season();
		season.setseasonName(startingYear + "-" + endingYear + " Season");
		dao.save(season);
		
	}
}
