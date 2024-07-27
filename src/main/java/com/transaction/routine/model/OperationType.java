package com.transaction.routine.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OperationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationTypeId;

    @Column(nullable = false)
    private String description;
    
	public Long getOperationTypeId() {
		return operationTypeId;
	}

	public void setOperationTypeId(Long operationTypeId) {
		this.operationTypeId = operationTypeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
    public OperationType() {}

	public OperationType(Long operationTypeId, String description) {
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
