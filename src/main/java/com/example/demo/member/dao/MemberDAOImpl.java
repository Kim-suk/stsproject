package com.example.demo.member.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.board.dto.BoardDTO;
import com.example.demo.member.dto.MemberDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<MemberDTO> memberList() {
		// TODO Auto-generated method stub
		   return em.createQuery("SELECT m FROM Member m", MemberDTO.class)
				   .getResultList();
	}

	@Override	
	public void insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		 em.persist(dto);
		
	}

	@Override
	public int deleteMember(String id) {
		// TODO Auto-generated method stub
		 return em.createQuery("DELETE FROM Member m WHERE m.id = :id")
                 .setParameter("id", id)
                 .executeUpdate();
	}

	@Override
	public void updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		 em.merge(dto);
	}

	@Override
	public MemberDTO detailMember(String id) {
		// TODO Auto-generated method stub
		return em.createQuery("SELECT m FROM Member m WHERE m.id = :id", MemberDTO.class)
		.setParameter("id", id)
        .getSingleResult();
		
		
	}
	
}
