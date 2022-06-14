package com.mbhdra.basfix.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.GenderDao;
import com.mbhdra.basfix.model.Gender;

@Service
public class GenderService {
	
	@Autowired
	GenderDao genderDao;
	
	public List<Gender> findAllGenders() {
		
		Iterable<Gender> genders =  genderDao.findAll();
		List<Gender> genderList = new ArrayList<Gender>();
		
		for (Gender g : genders)
			genderList.add(g);
		
		return genderList;
		
	}

}
