package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;

@Service
public class LprodService implements ILprodService {
	
	@Resource(name = "lprodDao")
	private ILprodDao lprodDao;
	
	public LprodService() {
	}

	public LprodService(ILprodDao lprodDao) {
		this.lprodDao = lprodDao;
	}
	
	@Override
	public List<LprodVO> getAllList() {
		return lprodDao.getAllList();
	}

	@Override
	public List<Map> getProdList(String prod_lgu) {
		return lprodDao.getProdList(prod_lgu);
	}

	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<LprodVO> lprodList = lprodDao.getLprodPagingList(page);
		int totalCnt = lprodDao.getLprodTotalCnt();
		
		map.put("lprodList", lprodList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt/page.getPagesize()));
		
		return map;
	}

	@Override
	public int getLprodTotalCnt() {
		return lprodDao.getLprodTotalCnt();
	}

}
