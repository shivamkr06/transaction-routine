package com.transaction.routine.model;

import java.util.Objects;

public class OperationType {
    private Integer operationTypeId;

    private String description;

	public Integer getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(Integer operationTypeId) {
		this.operationTypeId = operationTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public OperationType(Integer operationTypeId, String description) {
		super();
		this.operationTypeId = operationTypeId;
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, operationTypeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperationType other = (OperationType) obj;
		return Objects.equals(description, other.description) && Objects.equals(operationTypeId, other.operationTypeId);
	}
    
}
