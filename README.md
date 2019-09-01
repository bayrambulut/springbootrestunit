# Spring Boot, PostgreSQL, Rest Example

This sample project shows how to prepare an application using Spring Boot

## Installation

Use the github connection [link](https://github.com/bayrambulut/springbootrestunit.git) to install application.

```git
git clone --bare https://github.com/bayrambulut/springbootrestunit.git
```

## Usage

Create table below

```sql
create table book (
	id serial,
	name varchar(50),
	author varchar(50)
)
```

Change the lines below

```java
## PostgreSQL
spring.datasource.url=jdbc:postgresql://ec2-54-75-245-196.eu-west-1.compute.amazonaws.com:5432/db6rgf44hvalhm
spring.datasource.username=cyaplwfpjksjrv
spring.datasource.password=88d6365d02375a4d1392f954e7770ef2d4b5bede5b025952b90c19ff5dfdd1a7

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
```

## Cloud link
You can access application using link below

[https://springbootrestunit.herokuapp.com/books](https://springbootrestunit.herokuapp.com/books).



## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.


