package egovframework.com.edm.edm.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import egovframework.com.edm.edm.service.EdmManageDefaultVO;
import egovframework.com.edm.edm.service.EdmManageVO;

/**
 *
 * 지출관리을 처리하는 DAO 클래스
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
@Repository("EdmManageDAO")
public class EdmManageDAO extends EgovComAbstractDAO {

	/**
	 * 지출관리 글 목록에 대한 상세내용을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
	public EdmManageVO selectEdmListDetail(EdmManageVO vo) throws Exception {

		return (EdmManageVO) selectOne("EdmManageDAO.selectEdmListDetail", vo);

	}

	/**
	 * 지출관리 글을 수정한다.(조회수를 수정)
	 * @param vo
	 * @exception Exception
	 */
	public void updateEdmInqireCo(EdmManageVO vo) throws Exception {

		update("EdmManageDAO.updateEdmInqireCo", vo);

	}

	/**
	 * 지출관리 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectEdmList(EdmManageDefaultVO searchVO) throws Exception {

		return list("EdmManageDAO.selectEdmList", searchVO);

	}

	/**
	 * 지출관리 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 */
	public int selectEdmListTotCnt(EdmManageDefaultVO searchVO) {

		return (Integer) selectOne("EdmManageDAO.selectEdmListTotCnt", searchVO);

	}

	/**
	 * 지출관리 글을 등록한다.
	 * @param vo
	 * @exception Exception
	 */
	public void insertEdmDtls(EdmManageVO vo) throws Exception {

		insert("EdmManageDAO.insertEdmDtls", vo);

	}

	/**
	 * 작성비밀번호를 확인한다.
	 * @param vo
	 * @return 글 총 갯수
	 */
	public int selectEdmPasswordConfirmCnt(EdmManageVO vo) {

		return (Integer) selectOne("EdmManageDAO.selectEdmPasswordConfirmCnt", vo);

	}

	/**
	 * 지출관리 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
	public void updateEdmDtls(EdmManageVO vo) throws Exception {

		update("EdmManageDAO.updateEdmDtls", vo);

	}

	/**
	 * 지출관리 글을 삭제한다.
	 * @param vo
	 * @exception Exception
	 */
	public void deleteEdmDtls(EdmManageVO vo) throws Exception {

		delete("EdmManageDAO.deleteEdmDtls", vo);

	}

	/**
	 * 상담답변 글 목록에 대한 상세내용을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
	public EdmManageVO selectEdmAnswerListDetail(EdmManageVO vo) throws Exception {

		return (EdmManageVO) selectOne("EdmManageDAO.selectEdmAnswerListDetail", vo);

	}

	/**
	 * 상담답변 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectEdmAnswerList(EdmManageDefaultVO searchVO) throws Exception {

		return list("EdmManageDAO.selectEdmAnswerList", searchVO);

	}

	/**
	 * 상담답변 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 */
	public int selectEdmAnswerListTotCnt(EdmManageDefaultVO searchVO) {

		return (Integer) selectOne("EdmManageDAO.selectEdmAnswerListTotCnt", searchVO);

	}

	/**
	 * 상담답변 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
	public void updateEdmDtlsAnswer(EdmManageVO vo) throws Exception {

		update("EdmManageDAO.updateEdmDtlsAnswer", vo);

	}

}
