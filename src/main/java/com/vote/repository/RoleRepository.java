package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
