package com.mbhdra.basfix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.DivisionDao;
import com.mbhdra.basfix.model.Division;

@Service
public class DivisionService {
	
	@Autowired
	private DivisionDao divisionDao;
	
	public void addDivision(Division division) {
		
		// Capitalize each word of the division name
		String finalDivisionName = "";
		String[] words = division.getDivisionName().split(" ");
		for (String s : words) {
			s = s.toLowerCase();
			s = s.substring(0,1).toUpperCase() + s.substring(1);
			finalDivisionName = finalDivisionName + s + " ";
		}
		finalDivisionName = finalDivisionName.trim();
		division.setDivisionName(finalDivisionName);
		divisionDao.save(division);
		
	}
	
	public List<Division> findAllDivisions() {
		
		Iterable<Division> divisions =  divisionDao.findAll();
		List<Division> divisionList = new ArrayList<Division>();
		
		for (Division d : divisions)
			divisionList.add(d);
		
		return divisionList;
		
	}
}
