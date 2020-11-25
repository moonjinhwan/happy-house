package com.ssafy.vue.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.mapper.NoticeDAO;
import com.ssafy.vue.model.Notice;

@Service
public class NoticeServiceImpl implements NoticeService {
	
    @Autowired
	private NoticeDAO noticeDao;

    @Override
	public List<Notice> retrieveBoard() {
		return noticeDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(Notice notice) {
		return noticeDao.insertBoard(notice) == 1;
	}

	@Override
	public Notice detailBoard(int no) {
		return noticeDao.selectBoardByNo(no);
	}

	@Override
	@Transactional
	public boolean updateBoard(Notice notice) {
		return noticeDao.updateBoard(notice) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int no) {
		return noticeDao.deleteBoard(no) == 1;
	}

	@Override
	public List<Notice> retrieveBoard2(String title) {
		// TODO Auto-generated method stub
		return noticeDao.selectBoardbyName(title);
	}
}