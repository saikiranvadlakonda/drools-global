package com.ruleengine.dto;

public class LoanRequest {
	
	private String name;
	private int loanAmount;
	private int income;
	private int roi;
	private int score;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(int loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getIncome() {
		return income;
	}
	public void setIncome(int income) {
		this.income = income;
	}
	public int getRoi() {
		return roi;
	}
	public void setRoi(int roi) {
		this.roi = roi;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "LoanRequest [name=" + name + ", loanAmount=" + loanAmount + ", income=" + income + ", roi=" + roi
				+ ", score=" + score + ", age=" + age + "]";
	}
	
	
	

}
