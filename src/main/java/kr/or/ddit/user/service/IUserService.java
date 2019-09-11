package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;

public interface IUserService {
	/**
	* Method : getUserList
	* 작성자 : PC-08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	List<User> getUserList();
	
	public User getUser(String userId);

	public List<User> getUserListOnlyHalf();

	public Map<String, Object> getUserPagingList(Page page);
	
	public int insertUser(User user);
	
	public int deleteUser(String userId);
	
	public int updateUser(User user);
}
