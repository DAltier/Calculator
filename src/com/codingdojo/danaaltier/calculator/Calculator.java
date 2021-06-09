package com.codingdojo.danaaltier.calculator;

public class Calculator implements java.io.Serializable {
	
	// Attributes
	private double operandOne;
	private double operandTwo;
	private String operation;
	private double result;
	
	
	// Constructor
	public Calculator() {
		
	}

	
	// Getters
	public double getOperandOne() {
		return operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public String getOperation() {
		return operation;
	}
	
	
	// Setters
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public void setOperation(String operation) {
		if (operation == "+" || operation == "-") {
			this.operation = operation;
		} else {
			System.out.println("Invalid operation.");
		}
	}
	
	
	
	public void performOperation() {
		if (getOperation() == "+") {
			this.result = getOperandOne() + getOperandTwo();
		} else if (getOperation() == "-") {
			this.result = getOperandOne() - getOperandTwo();
		} else {
			System.out.println("Invalid operation. No result to return.");
		}
	}
	public void getResults() {
		System.out.println(this.result);
	}
}
