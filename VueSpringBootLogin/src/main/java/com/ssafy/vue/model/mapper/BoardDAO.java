package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.Board;
@Mapper
public interface BoardDAO {
	public List<Board> selectBoard();
	public List<Board> selectBoardbyName(String title);
	public Board selectBoardByNo(int no);
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(int no);
}