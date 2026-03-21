package com.chandru.abstract_interface_exception.model2;

public class ServiceValidator {

	public void validate(double fee) throws InvalidServiceException {

		if (fee <= 0) {
			throw new InvalidServiceException("Consultation fee must be positive");
		}
	}

	public int serviceType(int type) throws InvalidServiceException {

		if (type < 1 || type > 3) {
			throw new InvalidServiceException("Enter a number between 1 and 3");
		}

		return type;
	}
}