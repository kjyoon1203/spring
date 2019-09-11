package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserDao {
	/**
	* Method : getUserList
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	List<User> getUserList();
	
	/**
	* Method : getUser
	* 작성자 : PC-08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조회
	 */
	public User getUser(String userId);

	/**
	* Method : getUserListHalf
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트 50명만 조회
	 */
	public List<User> getUserListOnlyHalf();

	/**
	* Method : getUserPagingList
	* 작성자 : PC-08
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	public List<User> getUserPagingList(Page page);
	
	public int getUserTotalCnt();
	
	public int insertUser(User user);
	
	public int deleteUser(String userId);
	
	public int updateUser(User user);
}
