package org.unibl.etf.helper;

import java.io.Serializable;

public class SelectionHelper implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String NEWS = "news";
	public static final String EVENT = "event";
	public static final String UNIVERSAL = "universal";
	public static final Integer FIRST_STEP = 1;
	public static final Integer SECOND_STEP = 2;
	public static final Integer THIRD_STEP = 3;
	public static final Integer FINAL_STEP = 4;
	
	private Integer selectedStep;
	private String noticeType;
	
	public SelectionHelper(Integer selectedStep, String noticeType) {
		super();
		this.selectedStep = selectedStep;
		this.noticeType = noticeType;
	}
	
	public SelectionHelper() {}

	public Integer getSelectedStep() {
		return selectedStep;
	}

	public void setSelectedStep(Integer selectedStep) {
		this.selectedStep = selectedStep;
	}

	public String getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(String noticeType) {
		this.noticeType = noticeType;
	}
	
	public boolean isStepActive(String noticeType, int stepNo) {
		return (noticeType != null && noticeType.equals(this.noticeType) && stepNo == selectedStep);
	}

}
