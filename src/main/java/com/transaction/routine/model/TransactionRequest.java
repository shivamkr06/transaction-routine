package com.transaction.routine.model;

public class TransactionRequest {

    private Long operationTypeId;

    private Long accountId;

    private double amount;

	public Long getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(Long operationTypeId) {
		this.operationTypeId = operationTypeId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
