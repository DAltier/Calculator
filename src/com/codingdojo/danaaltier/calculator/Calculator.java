package com.codingdojo.danaaltier.calculator;

import java.util.ArrayList;

public class Calculator implements java.io.Serializable {
	
	// Part II
	
	// Attributes
	// ArrayList containing the numbers, boolean to test if the list is empty, int to keep track of size of ArrayList
	private ArrayList<Double> numbers = new ArrayList<>();
	private boolean hasNumbers = false;
	private int nSize = 0;
	// ArrayList containing the operators, boolean to test if the list is empty, int to keep track of size of ArrayList
	private ArrayList<String> operators = new ArrayList<>();
	private boolean hasOperators = false;
	private int oSize = 0;
	// Double to keep track of total, boolean to see if it's null
	private double total;
	private boolean hasValue = false;
	
	
	// Constructor
	public Calculator() {
	}
	
	
	// Handle numbers
	public void performOperation(double operand) {
		
		// If the numbers ArrayList is empty, add operand, set boolean to true, increase size by 1
		if(!hasNumbers) {
			numbers.add(operand);
			hasNumbers = true;
			nSize++;
		// If the numbers ArrayList is not empty, the operators ArrayList cannot be empty.
		// Cannot have more than one number and no operators.
		} else if(hasOperators) {
			// If the ArrayLists are the same size
			if(nSize == oSize) {
				// Handle case where the last operator entered was "*" 
				if(operators.get(oSize-1) == "*") {
					// Set the last operand in the ArrayList to its value multiplied by the new operand
					numbers.set(nSize-1, (numbers.get(nSize-1)*operand));
					// Remove operator from the ArrayList 
					operators.remove(oSize-1);
					// Reduce the size of the ArrayList by 1
					oSize--;
				// Handle case where the last operator entered was "/"
				} else if(operators.get(oSize-1) == "/") {
					// Set the last operand in the ArrayList to its value divided by the new operand
					numbers.set(nSize-1, (numbers.get(nSize-1)/operand));
					// Remove operator from the ArrayList 
					operators.remove(oSize-1);
					// Reduce the size of the ArrayList by 1
					oSize--;
				// If the last operator entered was "+" or "-",
				// Add the new number to the numbers ArrayList
				// This ensures all multiplications and division are handled first
				// Increase the size of the numbers ArrayList
				} else {
					numbers.add(operand);
					nSize++;
				}
			}
		// If the numbers ArrayList is not empty, but the operators ArrayList is, throw error
		// Cannot have more than one number and no operators.
		} else {
			throw new IllegalThreadStateException();
		}
	}
	
	
	// Handle operators
	public void performOperation(String operation) {
		// Throw error for invalid operators
		if(operation != "=" && operation != "+" && operation != "-" && operation != "*" && operation != "/") {
			throw new UnsupportedOperationException();
		// Handle case where the operator entered is "=" and calculate the total 
		} else if(operation == "=") {
			// If the numbers ArrayList is empty, cannot calculate total
			if(!hasNumbers) {
				throw new IllegalThreadStateException();
			// If the numbers ArrayList is not empty
			// Set the total to the first number
			// Then perform all additions and subtractions in the order of the operators in the operator ArrayList
			} else {
				this.total = numbers.get(0);
				for(int i=1; i<nSize; i++) {
					if(operators.get(i-1) == "+") {
						this.total += numbers.get(i);
					} else {
						this.total -= numbers.get(i);
					}
				}
				// Total is no longer null
				this.hasValue = true;
			}
		// Handle the case where the operator is "+", "-", "*", or "/"
		// If the numbers ArrayList contains one more item than the operators ArrayList
		// Add operator to the list, change boolean to true, and increase the size by 1
		} else if(oSize == nSize-1) {
			operators.add(operation);
			hasOperators = true;
			oSize++;
		// If the operators list size is not equal to the numbers list size - 1
		// We cannot add any more operators to the list
		} else {
			throw new IllegalThreadStateException();
		}
	}
	
	
	// If the total is not null, print its value
	// Else throw error
	public void getResults() {
		if(hasValue == true) {
			System.out.println(this.total);
		} else {
			throw new IllegalThreadStateException();
		}
	}
	
	/*
	 * Part I
	 * 
	 * // Attributes 
	 * private double operandOne; 
	 * private double operandTwo; 
	 * private String operation; 
	 * private double result;
	 * 
	 * 
	 * // Constructor 
	 * public Calculator() {
	 * 
	 * }
	 * 
	 * 
	 * // Getters 
	 * public double getOperandOne() { 
	 * 		return operandOne; 
	 * } public double
	 * getOperandTwo() { 
	 * 		return operandTwo; 
	 * } 
	 * public String getOperation() { 
	 * 		return operation; 
	 * }
	 * 
	 * 
	 * // Setters 
	 * public void setOperandOne(double operandOne) { 
	 * 		this.operandOne = operandOne; 
	 * } 
	 * public void setOperandTwo(double operandTwo) { 
	 * 		this.operandTwo = operandTwo; 
	 * } 
	 * public void setOperation(String operation) { 
	 * 		if (operation == "+" || operation == "-") { 
	 * 			this.operation = operation; 
	 * 		} else {
	 * 			System.out.println("Invalid operation."); 
	 * 		} 
	 * }
	 * 
	 * 
	 * public void performOperation() { 
	 * 		if (getOperation() == "+") { 
	 * 			this.result = getOperandOne() + getOperandTwo(); 
	 * 		} else if (getOperation() == "-") {
	 * 			this.result = getOperandOne() - getOperandTwo(); 
	 * 		} else {
	 * 			System.out.println("Invalid operation. No result to return."); 
	 * 		} 
	 * } 
	 * 
	 * public void getResults() { 
	 * 		System.out.println(this.result); 
	 * }
	 */
}
