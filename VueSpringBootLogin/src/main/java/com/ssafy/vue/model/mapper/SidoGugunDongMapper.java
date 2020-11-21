package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;

@Mapper
public interface SidoGugunDongMapper {
	
	public List<SidoGugunCodeDto> getSidoCode() throws SQLException;
	public List<SidoGugunCodeDto> getGugunCode(String sidocode) throws SQLException;
	public List<HouseInfoDto> getDongCode(String guguncode) throws SQLException;
}