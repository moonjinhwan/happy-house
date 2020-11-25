package com.ssafy.vue.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.Notice;
@Mapper
public interface NoticeDAO {
	public List<Notice> selectBoard();
	public List<Notice> selectBoardbyName(String title);
	public Notice selectBoardByNo(int no);
	public int insertBoard(Notice notice);
	public int updateBoard(Notice notice);
	public int deleteBoard(int no);
}