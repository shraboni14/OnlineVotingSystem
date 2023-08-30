package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.entity.ElectionMember;

public interface ElectionMemberRepository extends JpaRepository<ElectionMember, Integer> {

}
