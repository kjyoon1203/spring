package kr.or.ddit.user.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class UserControllerTest extends WebTestConfig{

	/**
	* Method : userListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : 사용자 전체 리스트 조회 테스트
	 * @throws Exception 
	 */
	@Test
	public void userListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/user/userList"))
				.andExpect(model().attributeExists("userList"))
				.andExpect(view().name("user/userList"));
		
		/***Then***/
	}
	
	/**
	* Method : userListOnlyHalfTest
	* 작성자 : PC-08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 하프 리스트 테스트
	 */
	@Test
	public void userListOnlyHalfTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/user/userListOnlyHalf"))
				.andExpect(view().name("user/userListOnlyHalf"));
		
		/***Then***/
	}
	
	/**
	* Method : userPagingListTest
	* 작성자 : PC-08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : 사용자 페이징 리스트 테스트(파라미터x)
	 */
	@Test
	public void userPagingListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/user/userPagingList"))
				.andExpect(view().name("user/userPagingList"));
		
		/***Then***/
	}

}
