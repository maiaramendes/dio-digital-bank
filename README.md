# Dio's DigitalBank
> A digital bank for Dio's BootCamp!

## Setup and run the project
Make sure you have your SSH key already configurated. If not, follow the instructions at this [link](https://docs.github.com/pt/authentication/connecting-to-github-with-ssh/generating-a-new-ssh-key-and-adding-it-to-the-ssh-agent)

#### 1. Clone the repository and open to the directory. 
````bash
git@github.com/dio-digital-bank.git
````

#### 2. Clean and install the dependencies
````bash
./gradlew clean install
````

#### 3. Run docker-compose
```bash
docker compose up 
```

#### 4. Run the project
```bash
./gradlew :run
```

## Database keys
| url             | database     | username | password        |
|-----------------|--------------|----------|-----------------|
| localhost:27017 | digital-bank | dio      | Dio!digit@lB@nk |


## Stack
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Spring](https://spring.io) 
- [Gradle](https://gradle.org)
- [Docker](https://www.docker.com)
- [MongoDB](https://www.mongodb.com)
- [SDKMAN](https://sdkman.io)
