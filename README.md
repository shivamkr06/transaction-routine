# Transactions Microservice

## Description
This project is a Spring Boot application that manages accounts and transactions for cardholders. It uses an in-memory database to store data.

## Endpoints

### Create an Account
*URL: POST /accounts/createAccount*
- **Request Body**:
  ```json
  {
    "document_number": "12345678900"
  }

  
 - **Response Body**:
 ```json
 {
  "accountId": 1,
  "documentNumber": "12345678900"
}

## Retrieve an Account
*URL: GET /accounts/{accountId}*
- **Response Body**:
```json
{
  "accountId": 1,
  "documentNumber": "12345678900"
}

#Create a Transaction
*URL: POST /transactions/createTransaction*
- **Request Body**:
```json
{
  "account_id": 1,
  "operation_type_id": 1,
  "amount": -50.0
}

- **Response Body**:
 ```json
{
  "transactionId": 1,
  "account": {
    "accountId": 1,
    "documentNumber": "12345678900"
  },
  "operationType": {
    "operationTypeId": 1,
    "description": "Normal Purchase"
  },
  "amount": -50.0,
  "eventDate": "2020-01-01T10:32:07.7199222"
}
