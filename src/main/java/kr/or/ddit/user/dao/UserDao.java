package kr.or.ddit.user.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

// 클래스명에서 맨 첫글자를 소문자로 변경한 문자열이 스프링 빈 이름으로 기본 설정됨
// 다른 이름의 스프링 빈 이름으로 등록하려면 속성 설정: @Repository("설정하고자 하는 스프링 빈 이름")
@Repository
public class UserDao implements IUserDao {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;
	
	/**
	* Method : getUserList
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<User> getUserList() {
		return sqlSession.selectList("user.getUserList");
		/*List<User> userList = new ArrayList<User>();
		userList.add(new User("brown"));
		userList.add(new User("cony"));
		userList.add(new User("sally"));
		
		return userList;*/
	}

	/**
	* Method : getUser
	* 작성자 : PC-08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조회
	 */
	@Override
	public User getUser(String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}

	/**
	* Method : getUserListHalf
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트 50명만 조회
	 */
	@Override
	public List<User> getUserListOnlyHalf() {
		return sqlSession.selectList("user.getUserListOnlyHalf");
	}

	/**
	* Method : getUserPagingList
	* 작성자 : PC-08
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	/*
	 * @Override public Map<String, Object> getUserPagingList(Page page) { return
	 * null; }
	 */

	@Override
	public int insertUser(User user) {
		return sqlSession.insert("user.insertUser", user);
	}

	@Override
	public int deleteUser(String userId) {
		return sqlSession.delete("user.deleteUser", userId);
	}

	@Override
	public int updateUser(User user) {
		return sqlSession.update("user.updateUser", user);
	}

	@Override
	public int getUserTotalCnt() {
		return sqlSession.selectOne("user.getUserTotalCnt");
	}

	@Override
	public List<User> getUserPagingList(Page page) {
		return sqlSession.selectList("user.getUserPagingList", page);
	}

}
