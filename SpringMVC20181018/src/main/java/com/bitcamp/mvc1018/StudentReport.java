package com.bitcamp.mvc1018;

import org.springframework.web.multipart.MultipartFile;

public class StudentReport {
	private String studentNumber;
	private MultipartFile report;
	private String reportName;
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public MultipartFile getReport() {
		return report;
	}
	public void setReport(MultipartFile report) {
		this.report = report;
	}	
}
