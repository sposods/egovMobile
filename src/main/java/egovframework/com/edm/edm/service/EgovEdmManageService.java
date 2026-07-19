package egovframework.com.edm.edm.service;

import java.util.List;


/**
 *
 * 지출관리을 처리하는 비즈니스 구현 클래스
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
public interface EgovEdmManageService {

    /**
	 * 지출관리 글을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
	EdmManageVO selectEdmListDetail(EdmManageVO vo) throws Exception;

	/**
	 * 지출관리 글을 수정한다.(조회수를 수정)
	 * @param vo
	 * @exception Exception
	 */
    void updateEdmInqireCo(EdmManageVO vo) throws Exception;

    /**
	 * 지출관리 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
    List<?> selectEdmList(EdmManageDefaultVO searchVO) throws Exception;

    /**
	 * 지출관리 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 */
    int selectEdmListTotCnt(EdmManageDefaultVO searchVO);

	/**
	 * 지출관리 글을 등록한다.
	 * @param vo - 등록할 정보가 담긴 EdmManageVO
	 * @exception Exception
	 */
    void insertEdmDtls(EdmManageVO vo) throws Exception;

    /**
	 * 작성비밀번호를 확인한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 * @exception
	 */
    int selectEdmPasswordConfirmCnt(EdmManageVO vo);

	/**
	 * 지출관리 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
    void updateEdmDtls(EdmManageVO vo) throws Exception;

	/**
	 * 지출관리 글을 삭제한다.
	 * @param vo
	 * @exception Exception
	 */
    void deleteEdmDtls(EdmManageVO vo) throws Exception;


    /**
	 * 상담답변 글을 조회한다.
	 * @param vo
	 * @return 조회한 글
	 * @exception Exception
	 */
	EdmManageVO selectEdmAnswerListDetail(EdmManageVO vo) throws Exception;


    /**
	 * 상담답변 글 목록을 조회한다.
	 * @param searchVO
	 * @return 글 목록
	 * @exception Exception
	 */
    List<?> selectEdmAnswerList(EdmManageDefaultVO searchVO) throws Exception;

    /**
	 * 상담답변 글 총 갯수를 조회한다.
	 * @param searchVO
	 * @return 글 총 갯수
	 * @exception
	 */
    int selectEdmAnswerListTotCnt(EdmManageDefaultVO searchVO);

	/**
	 * 상담답변 글을 수정한다.
	 * @param vo
	 * @exception Exception
	 */
    void updateEdmDtlsAnswer(EdmManageVO vo) throws Exception;



}

