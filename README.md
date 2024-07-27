# Transactions Routine

## Description
This project is a Spring Boot application that manages accounts and transactions for cardholders. It uses an H2 in memory database to store data.


## Features
- Create and retrieve accounts
- Create transactions
- OpenAPI documentation
- Docker support

## Prerequisites
- Java 17
- Maven
- Docker

### Clone the Repository

```sh
git clone https://github.com/shivamkr06/transaction-routine
```

## Endpoints

### Create an Account
*URL: POST /accounts/createAccount*
- **Request Body**:
  ```json
  {
    "accountId":1,
    "documentNumber": "12345678900"
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
  "accountId": 1,
  "operationTypeId": 1,
  "amount": 10.0
}

- **Response Body**:
 ```json
{
    "transactionId": 6,
    "account": {
        "accountId": 1,
        "documentNumber": "12345678900"
    },
    "operationType": {
        "operationTypeId": 1,
        "description": "Normal Purchase"
    },
    "amount": 10.0,
    "eventDate": "2024-07-27T21:46:51.3846312"
}


## Steps to run the docker file:
```cd /path/to/your/project
touch Dockerfile
touch .dockerignore
docker build -t transaction-routine:latest .
docker run -p 8080:8080 transaction-routine:latest
docker build -t transaction-routine:latest .
docker run -p 8080:8080 transaction-routine:latest
```

##Swagger for API documentation
#Access Swagger UI:
```Go to: http://localhost:8080/swagger-ui.html ```
