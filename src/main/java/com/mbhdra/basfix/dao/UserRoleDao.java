package com.mbhdra.basfix.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbhdra.basfix.model.UserRole;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Integer> {

}