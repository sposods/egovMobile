package egovframework.com.edm.edm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.springframework.stereotype.Service;

import egovframework.com.edm.edm.service.EdmManageDefaultVO;
import egovframework.com.edm.edm.service.EdmManageVO;
import egovframework.com.edm.edm.service.EgovEdmManageService;


/**
 *
 * 지출관리을 처리하는  구현 클래스
 * @author 공통서비스 개발팀 박정규
 * @since 2009.04.01
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.04.01  박정규          최초 생성
 *
 * </pre>
 */
@Service("EdmManageService")
public class EgovEdmManageServiceImpl extends EgovAbstractServiceImpl implements
        EgovEdmManageService {

    @Resource(name="EdmManageDAO")
    private EdmManageDAO EdmManageDAO;

//    /** ID Generation */
//	@Resource(name="egovEdmManageIdGnrService")
//	private EgovIdGnrService idgenService;


    /**
	 * 지출관리 글을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
    @Override
	public EdmManageVO selectEdmListDetail(EdmManageVO vo) throws Exception {
        EdmManageVO resultVO = EdmManageDAO.selectEdmListDetail(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

	/**
	 * 지출관리 글을 수정한다.(조회수를 수정)
	 * @param vo
	 * @exception Exception
	 */
    @Override
	public void updateEdmInqireCo(EdmManageVO vo) throws Exception {
    	EdmManageDAO.updateEdmInqireCo(vo);
    }

    /**
	 * 지출관리 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
    @Override
	public List<?> selectEdmList(EdmManageDefaultVO searchVO) throws Exception {
        return EdmManageDAO.selectEdmList(searchVO);
    }

    /**
	 * 지출관리 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 */
    @Override
	public int selectEdmListTotCnt(EdmManageDefaultVO searchVO) {
		return EdmManageDAO.selectEdmListTotCnt(searchVO);
	}

	/**
	 * 지출관리 글을 등록한다.
	 * @param vo
	 * @exception Exception
	 */
    @Override
	public void insertEdmDtls(EdmManageVO vo) throws Exception {
//    	String	expenseId = idgenService.getNextStringId();

//		vo.setExpenseId(expenseId);

    	EdmManageDAO.insertEdmDtls(vo);
    }

    /**
	 * 작성비밀번호를 확인한다.
	 * @param vo
	 * @return 글 총 갯수
	 */
    @Override
	public int selectEdmPasswordConfirmCnt(EdmManageVO vo) {
		return EdmManageDAO.selectEdmPasswordConfirmCnt(vo);
	}

	/**
	 * 지출관리 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
    @Override
	public void updateEdmDtls(EdmManageVO vo) throws Exception {
    	EdmManageDAO.updateEdmDtls(vo);
    }

	/**
	 * 지출관리 글을 삭제한다.
	 * @param vo
	 * @exception Exception
	 */
    @Override
	public void deleteEdmDtls(EdmManageVO vo) throws Exception {
    	EdmManageDAO.deleteEdmDtls(vo);
    }


    /**
	 * 상담답변 글을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
    @Override
	public EdmManageVO selectEdmAnswerListDetail(EdmManageVO vo) throws Exception {
        EdmManageVO resultVO = EdmManageDAO.selectEdmAnswerListDetail(vo);
        if (resultVO == null)
            throw processException("info.nodata.msg");
        return resultVO;
    }

    /**
	 * 상담답변 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
    @Override
	public List<?> selectEdmAnswerList(EdmManageDefaultVO searchVO) throws Exception {
        return EdmManageDAO.selectEdmAnswerList(searchVO);
    }

    /**
	 * 상담답변 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 */
    @Override
	public int selectEdmAnswerListTotCnt(EdmManageDefaultVO searchVO) {
		return EdmManageDAO.selectEdmListTotCnt(searchVO);
	}

	/**
	 * 상담답변 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
    @Override
	public void updateEdmDtlsAnswer(EdmManageVO vo) throws Exception {
    	EdmManageDAO.updateEdmDtlsAnswer(vo);
    }

}
