package com.ssafy.vue.model.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberDto login(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).login(memberDto);
	}

	@Override
	public String getServerInfo() {
		return "사용자에게 전달하고 싶은 중요정보";
	}
	
	@Override
	public MemberDto selectOne(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).selectOne(userid);
	}
	
	@Override
	@Transactional
	public boolean update(MemberDto memberDto) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).update(memberDto)==1;
	}
	
	@Override
	@Transactional
	public boolean delete(String userid) throws Exception {
		return sqlSession.getMapper(MemberMapper.class).delete(userid)==1;
	}
}