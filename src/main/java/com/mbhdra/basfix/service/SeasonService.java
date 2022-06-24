package com.mbhdra.basfix.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.SeasonDao;
import com.mbhdra.basfix.exception.InvalidSeasonException;
import com.mbhdra.basfix.model.Season;

@Service
public class SeasonService {
	
	@Autowired
	private SeasonDao seasonDao;
	
	public void addSeason(HttpServletRequest req, Season season) throws InvalidSeasonException {
		
		String seasonName = "";
		String startingYear = req.getParameter("startingYear");
		String endingYear = req.getParameter("endingYear");
		
		// ending year must be bigger than starting year and the difference must be 1.
		if(Integer.parseInt(endingYear) - Integer.parseInt(startingYear) != 1)
			throw new InvalidSeasonException();
		
		seasonName = startingYear + "-" + endingYear + " Season";
		season.setseasonName(seasonName);
		seasonDao.save(season);
		
	}
	
	public List<Season> findAllSeasons() {
		
		Iterable<Season> seasons =  seasonDao.findAll();
		List<Season> seasonList = new ArrayList<Season>();
		
		for (Season s : seasons)
			seasonList.add(s);
		
		return seasonList;
		
	}
}
