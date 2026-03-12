package com.chandru.abstract_interface_exception.test1;

import com.chandru.abstract_interface_exception.model1.LoanService;
import com.chandru.abstract_interface_exception.model1.SystemConfig;

public class LoanTest {

	public static void main(String[] args) {

		new SystemConfig();

		LoanService service = new LoanService();

		service.startLoanProcessing();
	}
}