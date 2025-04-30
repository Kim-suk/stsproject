package com.example.demo.board.dao;

import java.util.List;

import com.example.demo.board.dto.BoardDTO;

public interface BoardDAO {
	List<BoardDTO> boardList();
	void insertBoard(BoardDTO dto);
	BoardDTO getBoard(int articleNo);
	void update(BoardDTO dto);
	void delete(BoardDTO dto);
	int deleteBoard(int articleNo);
	static List<BoardDTO> getPagedBoardList(int startRow, int endRow) {
		// TODO Auto-generated method stub
		return null;
	}
}