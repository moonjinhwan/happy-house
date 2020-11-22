package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.vue.model.HouseInfoDto;
import com.ssafy.vue.model.SidoGugunCodeDto;
import com.ssafy.vue.model.service.SidoGugunDongService;

@RestController
@RequestMapping("/map")
public class MapController {
	
	@Autowired
	private SidoGugunDongService service;
	
	@GetMapping("/sido")
	public ResponseEntity<Map<String, Object>> getSisoCode(HttpServletRequest req) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			List<SidoGugunCodeDto> list = service.getSisoCode();
			resultMap.put("sidoInfo", list);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/gugun/{sidocode}")
	public ResponseEntity<Map<String, Object>> getGugunCode(@PathVariable String sidocode , HttpServletRequest req) throws Exception {
		System.out.println("시도코드 받음"+sidocode);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			List<SidoGugunCodeDto> list = service.getGugunCode(sidocode);
			resultMap.put("gugunInfo", list);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/dong/{guguncode}")
	public ResponseEntity<Map<String, Object>> getDongCode(@PathVariable String guguncode , HttpServletRequest req) throws Exception {
		System.out.println("구군코드 받음"+guguncode);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			List<HouseInfoDto> list = service.getDongCode(guguncode);
			resultMap.put("dongInfo", list);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/houseinfo/{dongName}")
	public ResponseEntity<Map<String, Object>> getInfo(@PathVariable String dongName , HttpServletRequest req) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println("동이름"+dongName);
		HttpStatus status = HttpStatus.ACCEPTED;
		
		try {
			List<HouseInfoDto> list = service.getHouseInfo(dongName);
			resultMap.put("houseInfo", list);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/detail")
	public ResponseEntity<Map<String, Object>> getDetail(@RequestBody Map<String, Object> info, HttpServletRequest req) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(">>>>>>>>>>>>>>>>"+info.get("code"));
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			List<Map<String, Object>> list = service.getDetail(info);
			for(Map<String, Object> k : list) {
				System.out.println(k.get("dong"));
			}
			resultMap.put("detailInfo", list);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
