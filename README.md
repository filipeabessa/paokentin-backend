# SysGuardeiNoCorazonBackend

"SysGuardeiNoCorazonBackend" é uma API RESTful desenvolvida para o curso "Desenvolvimento Web 2" no curso "Análise e Desenvolvimento de Sistemas" no IFPE. O sistema tem como objetivo auxiliar pessoas que tenham enfrentado situações de bullying a registrar informações sobre os agressores e os incidentes que sofreram.

## Tecnologias utilizadas

* [Java](https://www.java.com/pt-BR/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [JDBC](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html)
* [MySQL](https://www.mysql.com/)
* [Maven](https://maven.apache.org/)

## SQL para criação do banco

```sql

CREATE DATABASE sysguardeinocorazon;
USE sysguardeinocorazon;


CREATE TABLE IF NOT EXISTS disaffections (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
description VARCHAR(255) NOT NULL,
witnesses VARCHAR(255) NOT NULL,
involved_people VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS offenses (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
disaffection_id BIGINT NOT NULL,
title VARCHAR(50) NOT NULL,
description VARCHAR(255) NOT NULL,
cursed_family_member VARCHAR(20) NOT NULL,
offending_person VARCHAR(255) NOT NULL,
occurrence_date_time VARCHAR(255) NOT NULL,
FOREIGN KEY (disaffection_id) REFERENCES disaffections(id)
);

```

