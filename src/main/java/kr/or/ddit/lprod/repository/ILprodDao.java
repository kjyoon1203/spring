package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

public interface ILprodDao {
	public List<LprodVO> getAllList();
	
	public List<Map> getProdList(String prod_lgu);
	
	public List<LprodVO> getLprodPagingList(Page page);
	
	public int getLprodTotalCnt();
}
