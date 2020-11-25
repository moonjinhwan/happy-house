package com.ssafy.vue.model.service;

import java.util.List;

import com.ssafy.vue.model.Notice;

public interface NoticeService {
	public List<Notice> retrieveBoard();
	public List<Notice> retrieveBoard2(String title);
	public Notice detailBoard(int no);
	public boolean writeBoard(Notice notice);
	public boolean updateBoard(Notice notice);
	public boolean deleteBoard(int no);
}
