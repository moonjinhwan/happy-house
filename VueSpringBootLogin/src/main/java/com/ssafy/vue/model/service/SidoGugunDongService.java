package com.ssafy.vue.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.mapper.SidoGugunDongMapper;

@Service
public class SidoGugunDongService {
	@Autowired
	private SqlSession sqlSession;
	
	public List<SidoGugunCodeDto> getSisoCode() throws Exception {
		return sqlSession.getMapper(SidoGugunDongMapper.class).getSidoCode();
	}
	
	public List<SidoGugunCodeDto> getGugunCode(String sidocode) throws Exception {
		return sqlSession.getMapper(SidoGugunDongMapper.class).getGugunCode(sidocode);
	}
	
	public List<HouseInfoDto> getDongCode(String guguncode) throws Exception {
		return sqlSession.getMapper(SidoGugunDongMapper.class).getDongCode(guguncode);
	}
	
	public List<HouseInfoDto> getHouseInfo(String dongName) throws Exception {
		return sqlSession.getMapper(SidoGugunDongMapper.class).getHouseInfo(dongName);
	}
}