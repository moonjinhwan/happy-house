package com.ssafy.vue.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.MemberDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public int update(MemberDto memberDto) throws SQLException;
	public int delete(String userid) throws SQLException;
	public MemberDto selectOne(String userid) throws SQLException;
}
