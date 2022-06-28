package com.mbhdra.basfix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.SportsHallDao;
import com.mbhdra.basfix.model.SportsHall;

@Service
public class SportsHallService {

	@Autowired
	private SportsHallDao sportsHallDao;
	
	public void addSportsHall(SportsHall sportsHall) {
		
		// Capitalize each word of the sports hall name
		String finalsportsHallName = "";
		String[] words = sportsHall.getSportsHallName().split(" ");
		
		for (String s : words) {
			s = s.toLowerCase();
			s = s.substring(0,1).toUpperCase() + s.substring(1);
			finalsportsHallName = finalsportsHallName + s + " ";
		}
		
		finalsportsHallName = finalsportsHallName.trim();
		sportsHall.setSportsHallName(finalsportsHallName);
		sportsHallDao.save(sportsHall);
		
	}
	
	public void findAllSportHalls(List<SportsHall> sportsHallList) {
		
		for (SportsHall s : sportsHallDao.findAll())
			sportsHallList.add(s);
		
	}
}
