# Pokemon Cards Battle Simulator

## Overview

This application was built on SpringBoot framework, written in Java 17 with Maven project handler and exposing REST services

The proposed prototype solution consist of the following services:

- Start game

This service allows to begin a game simulating a set of cards for human and computer player

- Start fight

This service receives the selected card from the human user and reassigns the remaining health of each card by subtraction of attack points

- Retrieving fights

This service is in charge to get all the information of persisted fights


## Basic flow

The basic interaction with services is made of the following steps:

1. Start game

- Method: GET
- Url: /battles/play
- Result: Response with loaded cards for human and computer player

2. Send to fight

- Method: POST
- Url: /battles/fight
- Request body attributes: health points and attack points of cards chosen from both human and computer
- Result: Response with "OK" or "KO" result

3. Retrieve fights log

- Method: GET
- Url: /fights
- Result: Response with an attribute containing the list of fights

As reference, a set of integration tests are available in https://github.com/jcotalorac/pokemon-card-battle-simulator/tree/main/src/test/java/org/pokemon/controllers tests

## Considerations

### Simple version of clean architecture

The layers used here are controller, services and domain. Each endpoint is exposed by mean of a concrete class annotated with @RestController and interacts with DTO objects for requests and response.

Each service is implemented as a functional interface, and instantiated as a Spring service. Each one interacts with domain elements.

The domain layer wraps the representation of model objects. At the moment of implementation, and outcome achieved was that the application layer is completely stateless, allowing full data transference between persistence and user interface

Best practices of clean code are used here too. Comments in code are not recommended. Instead, the code itself is part of documentation.

To set complete independence of the layers, all the translations were made with the help of mappers, very useful to convert all kind of objects with proper declarations

### Deployment strategy

The strategy used to deploy is git-flow, considering the best approach for now to take care of the `main` branch and joining different features delivered and re-implemented in different times in the `development` branch. Some branches used are:

- `feature/init-project`: Initial dependencies for application from scratch
- `feature/battle-retrieving`: Development of feature X
- `feature/battle-logic`: Branch to fix feature X
- `development`: Branch to join feature branches, allowing to solve emerging conflicts for all devs
- `main`: Usual reference branch. Used for production purposes

Branches `development` and `main` have build and test jobs on pull requests and push events with GitHub Actions scripting for CI/CD purposes. All the jobs are executed with a provided docker template to download dependencies and execute tests 

All CI/CD pipeline scripts are available in ./github/workflows folder

Results of execution of pipelines are:

![Screen capture of actions](/documentation/img/actions.png "Actions")

### Database scripts

Cleaning and creating SQL scripts were included with all permissions required by security enhancements of Postgres 16

### Database configuration

It was possible to hide database connection parameters from code repository without sacrifice maintainability with the use of spring config import in the application.yml file. Secrets will keep being secrets. Scripts available in `db` directory

### Logging

Lombok Slf4j is the library used for logging. Default level is debug.


### Unit tests

Unit test of all layers are included, using JUnit 5 framework

### External API handling

Taking advantage of spring configuration beans, a sample of API cards are loaded at configuration phase to allow domain and service layers to deal decks for players randomly

### Feature enhancements

Possible enhancements for application could be:

- UI loading of chosen cards for both players
- Deliver fight and battle result to enhance UI controls
- Implement use of swagger or similar to document API
- In favour of versatility, it's possible to execute application with a configuration profile.
- Different profiles allow different debug levels

## Tech Stack

- SpringBoot 3.1.5
- Java 17
- Lombok
- Mapstruct
- Mockito
- JUnit 5
- Docker
- JQuery
- Bootstrap
- OKHttp
- PostgreSQL 16
- JPA
- Spring Data
- Maven
- Apache
- GitHub Actions

## Deployment

Application server and database server are part of a common environment

- Application server is deployed on http://env-6850457.sh2.hidora.net:8080/ and available for 10 days approximately (free-trial)
- Database server is available on https://node182719-env-6850457.sh2.hidora.net/ but is only visible from the application server and is maintained by a provided phpPgAdmin web interface to configure database (10 days approximately due to free-trial)
- The UI layer is deployed on http://35.226.139.229/ui/ with VM Apache Server (owned bill)
- Code repository: https://github.com/jcotalorac/pokemon-card-battle-simulator

## Sponsors

- Hidora PaaS provider: https://hidora.io/
- Google Cloud Provider: https://cloud.google.com 
