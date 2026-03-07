package com.chandru.exception_Assignement.test;

import java.util.Scanner;
import com.chandru.exception_Assignement.model.PasswordValidator;
import com.chandru.exception_Assignement.model.InvalidPasswordException;

public class CustomExceptionTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Entert the password");
			String pwd = scanner.nextLine();

			PasswordValidator.checkPassword(pwd);
			System.out.println("valid password");
		} catch (InvalidPasswordException e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("finally block");
			scanner.close();

		}
	}

}
