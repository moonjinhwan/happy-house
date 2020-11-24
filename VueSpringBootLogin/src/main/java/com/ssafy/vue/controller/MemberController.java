package com.ssafy.vue.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.MyPageDto;
import com.ssafy.vue.model.service.JwtService;
import com.ssafy.vue.model.service.MemberService;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class MemberController {

	@Autowired
	private JwtService jwtService;

	@Autowired
	private MemberService memberService;

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@PostMapping("/confirm/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody MemberDto memberDto, HttpServletResponse response,
			HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			MemberDto loginUser = memberService.login(memberDto);

			if (loginUser != null) {
//				jwt.io에서 확인
//				로그인 성공했다면 토큰을 생성한다.
				String token = jwtService.create(loginUser);
				logger.trace("로그인 토큰정보 : {}", token);

//				토큰 정보는 response의 헤더로 보내고 나머지는 Map에 담는다.
//				response.setHeader("auth-token", token);
				resultMap.put("auth-token", token);
				resultMap.put("user-id", loginUser.getUserid());
				resultMap.put("user-name", loginUser.getUsername());
//				resultMap.put("status", true);
//				resultMap.put("data", loginUser);
				status = HttpStatus.ACCEPTED;
			} else {
				resultMap.put("message", "로그인 실패");
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("로그인 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}


	@GetMapping("/info")
	public ResponseEntity<Map<String, Object>> getInfo(HttpServletRequest req) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		System.out.println(">>>>>> " + jwtService.get(req.getHeader("auth-token")));
		try {
			// 사용자에게 전달할 정보이다.
			// String info = memberService.getServerInfo();
			// MemberDto info = memberService.selectOne();

			resultMap.putAll(jwtService.get(req.getHeader("auth-token")));

			Map<String, Object> temp = (Map<String, Object>) resultMap.get("user");
			MemberDto info = memberService.selectOne((String) temp.get("userid"));
			resultMap.put("info", info);

//			resultMap.put("status", true)
//			resultMap.put("info", info);
			status = HttpStatus.ACCEPTED;
		} catch (RuntimeException e) {
			logger.error("정보조회 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 수정
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> updateInfo(@RequestBody MemberDto memberDto,
			HttpServletResponse response, HttpServletRequest req) {

		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			memberService.update(memberDto);
		} catch (Exception e) {
			resultMap.put("message", "로그인 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 삭제
	@DeleteMapping("{id}")
	public ResponseEntity<Map<String, Object>> deleteInfo(@PathVariable("id") String userid,
			HttpServletResponse response, HttpServletRequest req) {
		// System.out.println(userid);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {

			memberService.delete(userid);
		} catch (Exception e) {
			System.out.println("로그인실패");
			resultMap.put("message", "로그인 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// 회원가입
	@PostMapping("/confirm/join")
	public ResponseEntity<Map<String, Object>> joinInfo(@RequestBody MemberDto memberDto, HttpServletResponse response){
		System.out.println(memberDto.toString());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {		
			memberService.join(memberDto);
		}catch (Exception e) {
			System.out.println("회원가입 실패");
			resultMap.put("message", "회원가입 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	@PostMapping("/mypage")
	public ResponseEntity<Map<String, Object>> insertMyPage(@RequestBody MyPageDto myPageDto){
		System.out.println(myPageDto.toString());
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {		
			memberService.insertMyPage(myPageDto);
		}catch (Exception e) {
			System.out.println("내 페이지 저장 실패");
			resultMap.put("message", "내 페이지 저장 실패");
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String,Object>>(resultMap, status);
	}
	
}
