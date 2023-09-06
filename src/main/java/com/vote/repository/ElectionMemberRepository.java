package com.vote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vote.entity.ElectionMember;
import java.util.List;


public interface ElectionMemberRepository extends JpaRepository<ElectionMember, Integer> {
	
	List<ElectionMember> findByMemberName(String memberName);

}
