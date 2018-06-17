# Project Title

Tiny Crud REST example using Spring Boot, jpa, H2 and Maven


### Prerequisites

JDK 8 and JAVA_HOME environment variable set


### Installing

Clone the repository:

    git clone https://github.com/mdejuan/spring-boot-rest-crud

Navigate to the newly created folder:

    cd spring-boot-rest-crud

Run the project with:

    mvn clean spring-boot:run

To package the project run:

    mvn clean package


## Running integration tests

    mvn clean install

### Running the tests with cURL end points (replace localhost by https://stormy-waters-98152.herokuapp.com for Heroku cloud)

mvn clean spring-boot:run

CREATE COMPANY WITH OWNERS:

curl -i -X POST -H "Content-Type:application/json" http://localhost:8080/companies -d '{"name": "Company1","address": "Address1","city": "City1",
"country": "Country1","email": "Email1","phone": "1234567","owner": [{"name": "Owner A2"},{"name": "Owner A1"},{"name": "Owner A3"}]}'

RETRIEVE COMPANY:

curl http://localhost:8080/company/{idCompanyCreated}

LIST COMPANIES:

curl http://localhost:8080/companies

UPDATE COMPANY:

curl -i -X PUT -H "Content-Type:application/json" http://localhost:8080/companies/{idCompanyCreated} -d '{"name": "Company1","address": "Address1","city": "City1",
"country": "CountryOk","email": "Email1","phone": "1234567","owner": [{"name": "Owner A2"},{"name": "Owner A1"},{"name": "Owner A3"}]}'

DELETE COMPANY:

curl -i -X DELETE http://localhost:8080/companies/{idCompanyCreated}


## H2

To see the H2 db console go to: http://localhost:8080/console/

## Built With

* [Eclipse](http://www.eclipse.org/) - Platform used
* [Maven](https://maven.apache.org/) - Dependency Management
* [H2](http://www.h2database.com) - Database used


## Authors

* **Marcos de Juan** - (https://github.com/mdejuan)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details


How can you make the service redundant?
- Add validations to fields in the controller.
- Create a service or facade layer for these simple CRUD operations.
- Add "Transactional" annotation to controller methods.
- Add other annotations or methods to perform tasks that Spring already do like map objects to JSON.

What considerations should you do?

- If the app grows in complexity is good to add service or facade layer for business and transactional purposes.
- Add any kind of logging capability would be good.
