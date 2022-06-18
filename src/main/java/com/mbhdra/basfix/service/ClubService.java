package com.mbhdra.basfix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.ClubDao;
import com.mbhdra.basfix.model.Club;

@Service
public class ClubService {
	
	@Autowired
	private ClubDao clubDao;
	
	public void addClub(Club club)  {
		
		// Capitalize each word of the club name
		String finalClubName = "";
		String[] words = club.getClubName().split(" ");
		for (String s : words) {
			s = s.toLowerCase();
			s = s.substring(0,1).toUpperCase() + s.substring(1);
			finalClubName = finalClubName + s + " ";
		}
		finalClubName = finalClubName.trim();
		club.setClubName(finalClubName);
		clubDao.save(club);
		
	}
	
	public List<Club> findAllClubs() {
		
		Iterable<Club> clubs =  clubDao.findAll();
		List<Club> clubList = new ArrayList<Club>();
		
		for (Club c : clubs)
			clubList.add(c);
		
		return clubList;
		
	}
}
