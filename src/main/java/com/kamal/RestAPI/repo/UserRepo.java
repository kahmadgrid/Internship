package com.kamal.RestAPI.repo;

import com.kamal.RestAPI.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserRepo extends JpaRepository<User, Long>{

}