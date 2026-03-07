package com.chandru.Interface.model;

public interface PaymentGateway {

	void pay(double amount);

	void refund(double amount);
}