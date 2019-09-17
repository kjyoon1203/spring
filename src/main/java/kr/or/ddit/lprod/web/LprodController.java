package kr.or.ddit.lprod.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.service.ILprodService;

@Controller
public class LprodController {

	@Resource(name = "lprodService")
	private ILprodService lprodService;
	
	/**
	* Method : lprodList
	* 작성자 : PC-08
	* 변경이력 :
	* @param model
	* @return
	* Method 설명 : lprod 리스트 조회
	 */
	@RequestMapping(path = "lprodList", method = RequestMethod.GET)
	public String lprodList(Model model) {
		model.addAttribute("lprodList", lprodService.getAllList());
		
		return "lprod/lprodList";
	}
	
	/**
	* Method : lprodPagingList
	* 작성자 : PC-08
	* 변경이력 :
	* @param page
	* @param model
	* @return
	* Method 설명 : lprod 페이징 리스트 조회
	 */
	@RequestMapping(path = "lprodPagingList", method = RequestMethod.GET)
	public String lprodPagingList(Page page, Model model) {
		model.addAttribute("pageVo", page);
		model.addAllAttributes(lprodService.getLprodPagingList(page));
		
		return "lprod/lprodPagingList";
	}
	
	
}
