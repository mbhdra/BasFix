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
	private SeasonDao dao;
	
	public void addSeason(HttpServletRequest req) throws InvalidSeasonException {
		
		String seasonName = "";
		Season season = new Season();
		String startingYear = req.getParameter("startingYear");
		String endingYear = req.getParameter("endingYear");
		
		if(Integer.parseInt(endingYear) - Integer.parseInt(startingYear) != 1)
			throw new InvalidSeasonException();
		
		seasonName = startingYear + "-" + endingYear + " Season";
		season.setseasonName(seasonName);
		dao.save(season);
		
	}
	
	public List<Season> findAllSeasons() {
		
		Iterable<Season> seasons =  dao.findAll();
		List<Season> seasonsList = new ArrayList<Season>();
		
		for (Season s : seasons)
			seasonsList.add(s);
		
		return seasonsList;
		
	}
}
