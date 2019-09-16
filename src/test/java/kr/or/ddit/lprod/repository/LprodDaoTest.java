package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	 "classpath:kr/or/ddit/config/spring/context-root.xml"
	,"classpath:kr/or/ddit/config/spring/context-datasource-test.xml"
	,"classpath:kr/or/ddit/config/spring/context-transaction.xml"	
})
public class LprodDaoTest {

	@Resource(name="datasource")
	private BasicDataSource datasource;
	
	@Resource(name="lprodDao")
	private ILprodDao lprodDao;
	
	/**
	* Method : getAllListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getAllList 테스트
	 */
	@Test
	public void getAllListTest() {
		/***Given***/

		/***When***/
		List<LprodVO> lprodList = lprodDao.getAllList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	/**
	* Method : getProdListTest
	* 작성자 : PC-08
	* 변경이력 :
	* Method 설명 : getProdList 테스트
	 */
	@Test
	public void getProdListTest() {
		/***Given***/
		String prod_lgu = "P101";

		/***When***/
		List<Map> prodList = lprodDao.getProdList(prod_lgu);

		/***Then***/
		assertEquals(6, prodList.size());
	}
	
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(1);
		page.setPagesize(5);
		
		/***When***/
		List<LprodVO> list = lprodDao.getLprodPagingList(page);

		/***Then***/
		assertEquals(5, list.size());
	}

	@Test
	public void getLprodTotalCntTest() {
		/***Given***/

		/***When***/
		int totalCnt = lprodDao.getLprodTotalCnt();

		/***Then***/
		assertEquals(10, totalCnt);
	}
}
