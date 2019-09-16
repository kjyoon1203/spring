package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

@Repository
public class LprodDao implements ILprodDao {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<LprodVO> getAllList() {
		return sqlSession.selectList("lprod.getAllList");
	}

	@Override
	public List<Map> getProdList(String prod_lgu) {
		return sqlSession.selectList("lprod.getProdList", prod_lgu);
	}

	@Override
	public List<LprodVO> getLprodPagingList(Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}

	@Override
	public int getLprodTotalCnt() {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}

}
