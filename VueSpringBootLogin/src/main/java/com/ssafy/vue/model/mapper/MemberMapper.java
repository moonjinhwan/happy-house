package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.MyPageDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public int update(MemberDto memberDto) throws SQLException;
	public int delete(String userid) throws SQLException;
	public MemberDto selectOne(String userid) throws SQLException;
	public int join(MemberDto memberDto) throws SQLException;
	public int insertMyPage(MyPageDto myPageDto) throws SQLException;
	public List<MyPageDto> selectMyPage(String userid) throws Exception;
	public int deleteMyPage(String no) throws Exception;
}
