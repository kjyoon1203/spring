package kr.or.ddit.lprod.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;

import kr.or.ddit.config.test.WebTestConfig;

public class LprodControllerTest extends WebTestConfig{
	/**
	* Method : lprodListTest
	* 작성자 : PC-08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : lprod 리스트 조회 테스트
	 */
	@Test
	public void lprodListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/lprodList"))
				.andExpect(view().name("lprod/lprodList"));
		
		/***Then***/
	}

	/**
	* Method : lprodPagingListTest
	* 작성자 : PC-08
	* 변경이력 :
	* @throws Exception
	* Method 설명 : lprod 페이징 리스트 조회 테스트
	 */
	@Test
	public void lprodPagingListTest() throws Exception {
		/***Given***/

		/***When***/
		mockMvc.perform(get("/lprodPagingList"))
				.andExpect(view().name("lprod/lprodPagingList"));
		
		/***Then***/
	}
}
