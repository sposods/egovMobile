package egovframework.mbl.com.edm.edm.web;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.edm.edm.service.EdmManageDefaultVO;
import egovframework.com.edm.edm.service.EdmManageVO;
import egovframework.com.edm.edm.service.EgovEdmManageService;
import egovframework.mbl.com.cmm.annotation.IncludedMblInfo;

/**
 *
 * 지출관리를 처리하는 Controller 클래스
 * @author 이율경
 * @since 2011.08.05
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2011.08.05  이율경          최초 생성
 *
 * </pre>
 */
@Controller
public class EgovEdmEdmManageController {

    @Resource(name = "EdmManageService")
    private EgovEdmManageService edmManageService;

    /** EgovPropertyService */
    @Resource(name = "propertiesService")
    protected EgovPropertyService propertiesService;

	/** EgovMessageSource */
    @Resource(name="egovMessageSource")
    EgovMessageSource egovMessageSource;

    /**
     * 상담내역등록 화면을 출력한다.
     * @param searchVO
     * @param edmManageVO
     * @param model
     * @return "egovframework/com/edm/edm/EgovEdmDtlsRegist"
     * @throws Exception
     */
    @RequestMapping(value="/edm/edm/EdmDtlsRegistView.mdo")
    public String insertEdmDtlsView(@ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
    		EdmManageVO edmManageVO,
            ModelMap model)
    throws Exception {

        // 로그인VO에서  사용자 정보 가져오기
        LoginVO	loginVO = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

        String	mberNm 	= loginVO.getName();					// 사용자명
        String	emailAdres 	= loginVO.getEmail();					// email 주소

        edmManageVO.setMberNm(mberNm);							// 작성자명

    	model.addAttribute("edmManageVO", edmManageVO);

    	return "egovframework/mbl/com/edm/edm/EgovEdmDtlsRegist";

    }

    /**
     * 상담내역수정 화면을 출력한다.
     * @param searchVO
     * @param model
     * @param edmManageVO
     * @return "egovframework/com/edm/edm/EgovEdmDtlsUpdt"
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	@RequestMapping(value="/edm/edm/EdmDtlsUpdtView.mdo")
    public String updateEdmManage(@ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
    		EdmManageVO edmManageVO,
            ModelMap model)
    throws Exception {

    	EdmManageVO edmManage = edmManageService.selectEdmListDetail(edmManageVO);

		model.addAttribute("edmManageVO", edmManage);

    	return "egovframework/mbl/com/edm/edm/EgovEdmDtlsUpdt";

    }

    /**
     * 지출관리목록 조회한다.
     * @param searchVO
     * @param model
     * @return mbl/com/edm/edm/EgovEdmManageListInqire
     * @throws Exception
     */
    @IncludedMblInfo(name="지출관리",order = 201 ,gid = 20)
    @RequestMapping(value="/edm/edm/EgovEdmManageListInqire.mdo")
    public String selectEdmManageList(
    		@ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
    		ModelMap model)
    throws Exception {

    	/** EgovPropertyService.WordDicaryList */
    	searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
    	searchVO.setPageSize(propertiesService.getInt("pageSize"));

    	/** paging setting */
    	PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(10);
		paginationInfo.setPageSize(1);

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
        searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
        searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

        List<?> edmManageList = edmManageService.selectEdmList(searchVO);

        model.addAttribute("edmManageList", edmManageList);
        model.addAttribute("listSize", edmManageList.size());

        /** paging */
        int totCnt = edmManageService.selectEdmListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);

		model.addAttribute("paginationInfo", paginationInfo);
		model.addAttribute("searchVO", searchVO);

        return "egovframework/mbl/com/edm/edm/EgovEdmManageListInqire";

    }


    /**
     * 상담정보 목록에 대한 상세정보를 조회한다.
     * @param edmManageVO
     * @param searchVO
     * @param model
     * @return	"mbl/com/edm/edm/EgovEdmManageDetailInqire"
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	@RequestMapping("/uss/olp/cnm/EdmDetailInqire.mdo")
    public String	selectEdmListDetail(
    		EdmManageVO edmManageVO,
            @ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
            ModelMap model) throws Exception {

    	// 조회 수 증가
    	edmManageService.updateEdmInqireCo(edmManageVO);

    	EdmManageVO vo = edmManageService.selectEdmListDetail(edmManageVO);

		model.addAttribute("edmManageVO", vo);
		model.addAttribute("searchVO", searchVO);

        return "egovframework/mbl/com/edm/edm/EgovEdmManageDetailInqire";
    }

    /**
     * 상담정보를 등록한다.
     * @param searchVO
     * @param edmManageVO
     * @param model
     * @return "redirect:/edm/edm/EdmListInqire.mdo"
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
	@RequestMapping("/edm/edm/EdmDtlsRegist.mdo")
    public String insertEdmDtls(
            @ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
            @ModelAttribute("edmManageVO") EdmManageVO edmManageVO,
            ModelMap model)
            throws Exception {

    	ModelAndView modelAndView = new ModelAndView();

    	// 로그인VO에서  사용자 정보 가져오기
    	LoginVO	loginVO = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
    	String	mberId = loginVO.getUniqId();

    	edmManageVO.setMberId(mberId);		// 최초등록자ID

        edmManageService.insertEdmDtls(edmManageVO);

        modelAndView.addObject("searchVO", searchVO);

        return "redirect:/edm/edm/EdmListInqire.mdo";
    }

    /**
     * 상담정보를 수정처리한다.
     * @param searchVO
     * @param edmManageVO
     * @param model
     * @return "redirect:/uss/olp/cnm/EdmListInqire.mdo"
     * @throws Exception
     */
    @SuppressWarnings({ "deprecation", "unused" })
	@RequestMapping("/edm/edm/EdmDtlsUpdt.mdo")
    public String updateEdmDtls(@ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
            @ModelAttribute("edmManageVO") EdmManageVO edmManageVO,
            ModelMap model)
            throws Exception {

    	ModelAndView modelAndView = new ModelAndView();

    	// 로그인VO에서  사용자 정보 가져오기
    	LoginVO	loginVO = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();

    	String	mberId = loginVO.getUniqId();

    	edmManageVO.setMberId(mberId);		// 최초등록자ID

    	edmManageService.updateEdmDtls(edmManageVO);

        model.addAttribute("edmManageVO", edmManageVO);

        return "redirect:/edm/edm/EdmListInqire.mdo";
    }

    /**
     * 상담정보를 삭제처리한다.
     * @param edmManageVO
     * @param searchVO
     * @param model
     * @return	"redirect:/edm/edm/EdmListInqire.mdo"
     * @throws Exception
     */
    @RequestMapping("/edm/edm/EdmDtlsDelete.mdo")
    public String deleteEdmDtls(
            EdmManageVO edmManageVO,
            @ModelAttribute("searchVO") EdmManageDefaultVO searchVO,
    		ModelMap model)
            throws Exception {

    	model.addAttribute("searchVO", searchVO);
    	edmManageService.deleteEdmDtls(edmManageVO);

        return "redirect:/edm/edm/EdmListInqire.mdo";
    }


}
