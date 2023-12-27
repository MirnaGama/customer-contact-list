# Customer Contact List - API Module ![Build Status](https://github.com/MirnaGama/customer-contact-list/actions/workflows/maven-api.yml/badge.svg)

This is API project built with Spring Boot 3.2.1 and JDK 17. The project uses Maven 4.0.0 as the build tool. The API provides two endpoints: "customers" and "telephones".

### Customers
This endpoint is used to add customers to the database. 

- To add a customer, make a POST request to **/api/v1.0/customers** with the customer data in the body. Example:

 ```json
{
    "cep": "5100000",
    "city": "Recife",
    "fullname": "Fulana",
    "houseNumber": 500,
    "neighborhood": "Boa Viagem",
    "state": "PE",
    "street": "Rua Teste"
}
```

### Telephones
This endpoint is used to add telephones to customers in the database. 

- To get all phone numbers, make a GET request to **/api/v1.0/telephones**.

- To add a phone number to a customer, make a POST request to **/api/v1.0/telephones** with the phone number and related customer id in the body. Example:
 
 ```json
{
    "customerId": "3187b27c-ded9-496e-a2a0-daaa3b51d68e",
    "number": "(87)2124-2572"
}
```

_Validations:_
1. The phone number cannot be null.
2. The phone number needs to be in a valid brazilian format, for example, (XX) XXXX-XXXX.

## Prerequisites

- `mvn --version`<br>
You should see the version of Maven installed along with the version of the JDK. It is important to know that the JDK is mandatory, as is the definition of the **JAVA_HOME** and **M2_HOME** environment variables.

## Running the application

1. `git clone https://github.com/MirnaGama/customer-contact-list/`
2. `cd customer-contact-list-api`
3. `mvn clean install`<br>
It will build the jar file in the target folder
4. `mvn spring-boot:run`<br>
It will compile and run the application on default port (8080)

## Running tests
- `mvn test`<br>
It will executes all the tests.

- `mvn -Dtest=packageName.className test`<br>
It will execute only one test class

- `mvn -Dtest=packageName.className#methodName test`<br>
It will run only one test method from one test class
  
