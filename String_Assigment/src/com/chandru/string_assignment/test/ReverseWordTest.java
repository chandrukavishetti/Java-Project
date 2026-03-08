package com.chandru.string_assignment.test;

import java.util.Scanner;
import com.chandru.string_assignment.model.ReverseWordModel;

public class ReverseWordTest {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		
		try {
			System.out.println("enter the sentence to reverse :");
			String sentence=scanner.nextLine();
			
			ReverseWordModel reverse =new ReverseWordModel(sentence);
			reverse.reverseWord();
		}catch(Exception e) {
			System.out.println("error : "+e.getMessage());
		}finally {
			scanner.close();
		}
	}

}
