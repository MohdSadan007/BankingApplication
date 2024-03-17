package com.task2;

import java.util.Scanner;

public class BankApplicationExample {
	private static Scanner input = new Scanner(System.in);
	private static double bankBalance = 0;

	public static void main(String[] args) {
		menuDisplay();
//			System.out.println("Welcome to Bank Application!");
//			System.out.println("Press D for Deposit");
//			System.out.println("Press W for Withdrawals");
//			System.out.println("Press C for Check Balance");
//			System.out.println("Press E for Exit");
		boolean flag = true;
		while (flag) {
			System.out.println("Press M for show again Menu");
			String operation = input.next();
			switch (operation) {
			case "D":
				depositeMoney();
				break;
			case "W":
				withdrawMoney();
				break;
			case "C":
				checkBalance();
				break;
			case "E":
				System.out.println("Existing from Bank Application!");
				flag = false;
				break;
			case "M":
				menuDisplay();
				break;
			default:
				System.out.println("Invoice Operation!");
			}
		}
		input.close();
	}

	private static void depositeMoney() {
		System.out.println("Please enter the amount to deposite");
		double amount = input.nextDouble();
		if(amount > 0) {
			bankBalance = bankBalance + amount;
			System.out.println("Successfully Deposited the amount, you current balance is now :" + bankBalance);
		}else {
			System.out.println("Invalid amount, Please enter valid amount to deposite");
		}
	}
	
	private static void withdrawMoney() {
		System.out.println("Please enter the amount to withdraw");
		double amount = input.nextDouble();
		if(amount > 0 && bankBalance >= amount) {
			double calculatedBalance = bankBalance - amount;
			if(calculatedBalance < 500) {
				System.out.println("Can't widthraw money as your balance has been reached to the minimum limit 500Rs");
			}else {
				bankBalance = bankBalance - amount;
				System.out.println("Successfully Withdraw the amount, you current balance is now :" + bankBalance);
			}
		} else if (amount > bankBalance) {
			System.out.println("Insufficient Balance!");
		} else {
			System.out.println("Invalid amount, Please enter valid amount to withdraw");
		}
	}
	
	private static void checkBalance() {
		System.out.println("Your current balance is : " + bankBalance);
	}
	private static void menuDisplay() {
		System.out.println("Welcome to Bank Application!");
		System.out.println("Press D for Deposit");
		System.out.println("Press W for Withdrawals");
		System.out.println("Press C for Check Balance");
		System.out.println("Press E for Exit");	
	}

}
