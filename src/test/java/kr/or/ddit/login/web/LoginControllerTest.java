package kr.or.ddit.login.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.config.test.WebTestConfig;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;

public class LoginControllerTest extends WebTestConfig{

	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	* Method : loginViewTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : 로그인 화면 요청 테스트
	 * @throws Exception 
	 */
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/

		/***When***/
		MvcResult mvcResult = mockMvc.perform(get("/login")).andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}
	
	/**
	* Method : loginProcessTest
	* 작성자 : PC-08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 로그인 요청 테스트
	 */
	@Test
	public void loginProcessTest() throws Exception {
		/***Given***/
		MockHttpSession session = new MockHttpSession();
		
		/***When***/
		MvcResult mvcResult = mockMvc.perform(post("/login")
											.param("userId", "brown")
											.param("pass", "brown1234")
											.session(session))
									.andReturn();
		ModelAndView mav = mvcResult.getModelAndView();
		User user = (User) session.getAttribute("S_USERVO");
		
		/***Then***/
		assertEquals("main", mav.getViewName());
		assertNotNull(user);
	}

}
