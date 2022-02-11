##Not tested
- The application has not been tested because the allocated time run out. 
- it however shows how i'd structure a service
- No tests have been implemented

###Technologies used
- Swagger for documentation
- Lombok for stubbing
- Docker for containerization
- docker-compose for orchestration





###Back End Exercise

Welcome to TOQIO, a Fintech startup company which provides banking solutions such as card management (virtual or real),
accounts, payments, transfers and expense management to other financial institutions. We integrate with other banks 
running on cloud to sell our products as a Bank as a Service.

All our back-end is built using micro-services and we are missing a micro-service that manages both credit card and 
account creation, retrieval, update and delete operation (CRUD). Everything is implemented using API REST.

You have 2 models:

- Card
    - Card id: the id of the card (not editable)
    - Card alias: personalised name of the card (editable)
    - Account id: account to which the card belongs (not editable)
    - Type of card: indicates if a card is virtual or physical (not editable)

- Account
    - Account id: id of the account
    - Iban: iban of the account
    - bicSwift: bic swift of the account
    - Client id: client to whom the account belongs


Each card is associated to one account using the accountId and only clients belonging to an account can retrieve the 
cards belonging to that account.

We want you to implement the CRUD operations for the card and account entities and also an endpoint to return all 
cards associated to an account.

Notes from the exercise:

* Create a new spring boot application using maven--------------
* Use any fake data that you want, there must be at least two different account ids and two different client ids.
* You can mock data
* You can store data in memory.
* Use Java version 8+-------------------
* Keep everything simple. Don't implement or use any third party library without an explanation
* Explain everything you need in a file named notes.md with everything you think it's important to take into consideration.
* Think that this service could run in a production environment.


Extras:

* Run the code inside a container
* Use a DB, preferably mongoDB
* Implement tests