package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.config.test.RootTestConfig;
import kr.or.ddit.user.model.User;

public class UserServiceTest extends RootTestConfig{

	private String userId = "brownTest";
	
	@Resource(name = "userService")
	private IUserService userService;
	
	/**
	 * Method : getUserListTest 
	 * 작성자 : PC-08 
	 * 변경이력 : 
	 * Method 설명 : 사용자 전체 리스트 조회 테스트
	 */
	@Test
	public void getUserListTest() {
		/*** Given ***/

		/*** When ***/
		List<User> userList = userService.getUserList();

		/*** Then ***/
		assertTrue(userList.size() >= 5);
	}

	/**
	 * 
	 * Method : getUserTest 
	 * 작성자 : PC-08 
	 * 변경이력 : Method 
	 * 설명 : 사용자 정보 조회 테스트
	 */
	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		User userVo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", userVo.getUserNm());
	}

	/**
	 * 
	 * Method : getUserListHalf 
	 * 작성자 : PC-08 
	 * 변경이력 : 
	 * Method 설명 : getUserListHalf 테스트
	 */
	@Test
	public void getUserListOnlyHalfTest() {
		/*** Given ***/
	
		/*** When ***/
		List<User> userListHalf = userService.getUserListOnlyHalf();
	
		/*** Then ***/
		assertTrue(userListHalf.size() > 2);
	}

	/**
	 * Method : getUserPagingListTest 
	 * 작성자 : PC-08 
	 * 변경이력 : 
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	  @Test 
	  public void getUserPagingListTest() {
		 /*** Given ***/
		  Page page = new Page(); 
		  page.setPage(1); 
		  page.setPagesize(10);
		  
		 /*** When ***/
		  Map<String, Object> resultMap = userService.getUserPagingList(page);
		  List<User> userList = (List<User>) resultMap.get("userList"); 
		  int paginationSize = (Integer) resultMap.get("paginationSize");
		  
		 /*** Then ***/
		  assertEquals(5, userList.size()); 
		  assertEquals("brown", userList.get(0).getUserId()); 
		  assertEquals(1, paginationSize); 
	  }
						 

	@Test
	public void ceilingTest() {
		/*** Given ***/
		int totalCnt = 1;
		int pagesize = 10;
	
		/*** When ***/
		double paginationSize = Math.ceil((double) totalCnt / pagesize);
	
		/*** Then ***/
		assertEquals(1, (int) paginationSize);
	}

	@Test
	public void insertUserTest() throws ParseException {
		/*** Given ***/
		User user = new User();
		user.setUserId(userId);
		user.setUserNm("브라운테스트");
		user.setAlias("곰테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 202호");
		user.setZipcode("34940");
		user.setFilename("test");
		user.setRealfilename("test");
		
		/*** When ***/
		int insertCnt = userService.insertUser(user);

		/*** Then ***/
		assertEquals(1, insertCnt);
	}

	@Test
	public void updateUserTest() throws ParseException {
		/*** Given ***/
		User user = new User();

		user.setUserId(userId);
		user.setUserNm("테스트");
		user.setPass("brownTest1234");
		user.setReg_dt(new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08"));
		user.setAlias("곰테스트");
		user.setAddr1("대전광역시 중구 중앙로 76");
		user.setAddr2("영민빌딩 2층 DDIT");
		user.setZipcode("34940");
		user.setFilename("3333");
		user.setRealfilename("333");

		/*** When ***/
		int updateCnt = userService.insertUser(user);

		/*** Then ***/
		assertEquals(1, updateCnt);
	}
}
