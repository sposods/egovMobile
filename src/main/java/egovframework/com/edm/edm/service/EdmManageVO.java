package egovframework.com.edm.edm.service;


/**
 * 
 * 지출내용을 처리하는 VO 클래스
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
public class EdmManageVO extends EdmManageDefaultVO {
	
    private static final long serialVersionUID = 1L;
    
    /** 지출 ID */
    private String expenseId;
    
    /** 사용자 ID */
    private String mberId;

    /** 사용자 명 */
    private String mberNm;
    
    /** 카테고리 ID */
    private String categoryId;
    
    /** 카테고리 명 */
    private String categoryNm;
    
    /** 지출날짜 */
    private String expenseDt;
    
    /** 지출시간 */
    private String expenseTm;
    
    /** 지출금액 */
    private String amount;
    
    /** 지출내용 */
    private String expenseNote;
    
    /** 생성일시 */
    private String creatDt;
    
    /** 수정일시 */
    private String updtDt;

	/**
	 * @return the expenseId
	 */
	public String getExpenseId() {
		return expenseId;
	}

	/**
	 * @param expenseId the expenseId to set
	 */
	public void setExpenseId(String expenseId) {
		this.expenseId = expenseId;
	}

	/**
	 * @return the mberId
	 */
	public String getMberId() {
		return mberId;
	}

	/**
	 * @param mberId the mberId to set
	 */
	public void setMberId(String mberId) {
		this.mberId = mberId;
	}

	/**
	 * @return the mberNm
	 */
	public String getMberNm() {
		return mberNm;
	}

	/**
	 * @param mberNm the mberNm to set
	 */
	public void setMberNm(String mberNm) {
		this.mberNm = mberNm;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryNm
	 */
	public String getCategoryNm() {
		return categoryNm;
	}

	/**
	 * @param categoryNm the categoryNm to set
	 */
	public void setCategoryNm(String categoryNm) {
		this.categoryNm = categoryNm;
	}

	/**
	 * @return the expenseDt
	 */
	public String getExpenseDt() {
		return expenseDt;
	}

	/**
	 * @param expenseDt the expenseDt to set
	 */
	public void setExpenseDt(String expenseDt) {
		this.expenseDt = expenseDt;
	}

	/**
	 * @return the expenseTm
	 */
	public String getExpenseTm() {
		return expenseTm;
	}

	/**
	 * @param expenseTm the expenseTm to set
	 */
	public void setExpenseTm(String expenseTm) {
		this.expenseTm = expenseTm;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the expenseNote
	 */
	public String getExpenseNote() {
		return expenseNote;
	}

	/**
	 * @param expenseNote the expenseNote to set
	 */
	public void setExpenseNote(String expenseNote) {
		this.expenseNote = expenseNote;
	}

	/**
	 * @return the creatDt
	 */
	public String getCreatDt() {
		return creatDt;
	}

	/**
	 * @param creatDt the creatDt to set
	 */
	public void setCreatDt(String creatDt) {
		this.creatDt = creatDt;
	}

	/**
	 * @return the updtDt
	 */
	public String getUpdtDt() {
		return updtDt;
	}

	/**
	 * @param updtDt the updtDt to set
	 */
	public void setUpdtDt(String updtDt) {
		this.updtDt = updtDt;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
    
	    
   
}
