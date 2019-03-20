package com.wanz.user.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

    User getById(int id);

    List<User> findAll();

    User save(User user);

    User getByName(String name);
}