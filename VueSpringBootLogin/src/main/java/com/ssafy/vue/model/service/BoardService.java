package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.Board;

public interface BoardService {
	public List<Board> retrieveBoard();
	public List<Board> retrieveBoard2(String title);
	public Board detailBoard(int no);
	public boolean writeBoard(Board board);
	public boolean updateBoard(Board board);
	public boolean deleteBoard(int no);
}
