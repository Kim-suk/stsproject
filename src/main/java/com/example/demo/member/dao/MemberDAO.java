package com.example.demo.member.dao;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.member.dto.MemberDTO;

public interface MemberDAO {
	List<MemberDTO> memberList();
	void insertMember(MemberDTO dto);
	int deleteMember(String id);
	void updateMember(MemberDTO dto);
	MemberDTO detailMember(String id);

	

}
