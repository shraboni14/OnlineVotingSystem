package com.vote.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.vote.entity.ElectionMember;
import com.vote.repository.ElectionMemberRepository;
import com.vote.service.ElectionMemberService;

@SpringBootTest
class ElectionMemberServiceTest {

	@MockBean
	ElectionMemberRepository eMemberRepository;

	@Autowired
	ElectionMemberService eMemberService;

	@Test
	@DisplayName("Positive TestCase")
	void positiveTestcreateMember() {
		ElectionMember electionMember = ElectionMember.builder().memberName("Person1").memberParty("BJP")
				.noOfTotalVote(20).build();

		Mockito.when(eMemberRepository.save(electionMember)).thenReturn(electionMember);

		assertEquals("Person1", eMemberService.createElectionMember(electionMember).getMemberName());
	}

	@Test
	@DisplayName("Negative Testcase")
	void negTestCreateMember() {
		ElectionMember electionMember = ElectionMember.builder().memberName("Person1").memberParty("BJP")
				.noOfTotalVote(20).build();

		Mockito.when(eMemberRepository.save(electionMember)).thenReturn(electionMember);

		assertEquals(10, eMemberService.createElectionMember(electionMember).getNoOfTotalVote());

	}

}
