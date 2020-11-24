package com.ssafy.vue.model.service;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.MyPageDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public String getServerInfo();
	public boolean update(MemberDto memberDto) throws Exception;
	public boolean delete(String userid) throws Exception;
	public MemberDto selectOne(String userid) throws Exception;
	boolean join(MemberDto memberDto) throws Exception;
	boolean insertMyPage(MyPageDto myPageDto) throws Exception;
}
