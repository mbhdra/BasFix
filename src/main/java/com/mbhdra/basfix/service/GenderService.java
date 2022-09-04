package com.mbhdra.basfix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbhdra.basfix.dao.GenderDao;
import com.mbhdra.basfix.model.Gender;

@Service
public class GenderService {
	
	@Autowired
	private GenderDao genderDao;
	
	public void findAllGenders(List<Gender> genders) {
		
		for (Gender g : genderDao.findAll())
			genders.add(g);
	}
}