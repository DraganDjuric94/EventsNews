package org.unibl.etf.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.unibl.etf.helper.SelectionHelper;

@ManagedBean
@SessionScoped
public class SelectionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private SelectionHelper selection = new SelectionHelper(SelectionHelper.FIRST_STEP, SelectionHelper.UNIVERSAL);

	public SelectionHelper getSelection() {
		return selection;
	}
	
	public void nextStep() {
		int currentStep = selection.getSelectedStep();
	
		if (currentStep == 1) {
			// Check if user selected news or events
			String selected = selection.getNoticeType();
			if (!(SelectionHelper.EVENT.equals(selected) || SelectionHelper.NEWS.equals(selected))) {
				selection.setNoticeType(SelectionHelper.UNIVERSAL);
				return;
			}
		} else if (currentStep == 2) {
			// Check if data is ok
		} else if (currentStep == 3) {
			// Write to databese if all data is ok
			// Handle differently for event and news
			selection.setNoticeType(SelectionHelper.UNIVERSAL);
		} else {
			return;
		}
		
		selection.setSelectedStep(currentStep + 1);
	}
	
	public String previousStep() {
		int currentStep = selection.getSelectedStep();
		
		if (currentStep < 5 && currentStep > 1) {
			selection.setSelectedStep(currentStep - 1);
		}
		
		if (currentStep == 2) {
			selection.setNoticeType(SelectionHelper.UNIVERSAL);
		}
		
		return "index";
	}
	
	public boolean hasNext() {
		int currentStep = selection.getSelectedStep();
		return (currentStep < 4 && currentStep > 0);
	}
	
	public boolean hasPrevoius() {
		int currentStep = selection.getSelectedStep();
		return (currentStep < 4 && currentStep > 1);
	}
	
	public void chooseNoticeType(String noticeType) {
		selection.setNoticeType(noticeType);
	}
	
	public Date justNow() {
		return new Date();
	}
	
	public String findFormId() {
		String formId = "";
		int currentStep = selection.getSelectedStep();
		String currentType = selection.getNoticeType();
		
		if (currentStep == 1) {
			formId = "type_form";
		} else if (currentStep == 2 && SelectionHelper.EVENT.equals(currentType)) {
			formId = "event_form";
		} else if (currentStep == 2 && SelectionHelper.NEWS.equals(currentType)) {
			formId = "news_form";
		}
		
		return formId;
	}
	
	public void resetWizard() {
		selection = new SelectionHelper(SelectionHelper.FIRST_STEP, SelectionHelper.UNIVERSAL);
	}

}