package com.app.registro.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.app.registro.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {}