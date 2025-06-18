# Microservices - Écosystème Scolaire

Ce projet est une architecture de microservices basée sur Spring Boot et Spring Cloud. Il modélise un système scolaire composé d’écoles et d’étudiants, en exploitant divers composants de l’écosystème Spring pour la configuration centralisée, la découverte de services, le routage API et la communication entre services.

## 📐 Architecture

L'architecture repose sur les services suivants :

- **Config Server** : Fournit la configuration centralisée pour tous les microservices.
- **Discovery Service (Eureka)** : Permet l’enregistrement et la découverte automatique des services.
- **API Gateway** : Point d’entrée unique, il redirige les requêtes vers les services internes via le service Eureka.
- **School Service** : Gère les données des écoles (nom, email).
- **Student Service** : Gère les données des étudiants (prénom, nom, email, école associée).

Chaque service (hors `gateway`, `discovery` et `config`) possède sa propre base de données PostgreSQL.


## ⚙️ Technologies utilisées

- **Java 21**
- **Spring Boot**
- **Spring Cloud (Eureka, Config Server, Gateway)**
- **PostgreSQL**
- **Docker / Docker Compose (optionnel pour orchestration future)**
- **Maven**
- **REST APIs**
- **Communication inter-services (REST / Feign / Eureka)**


## 🗂️ Structure du projet

micro-services/

├── config-server/ # Configuration centralisée (Spring Cloud Config)

├── discovery-service/ # Service Eureka

├── gateway-service/ # API Gateway (Spring Cloud Gateway)

├── school-service/ # Microservice École avec BDD PostgreSQL

├── student-service/ # Microservice Étudiant avec BDD PostgreSQL

└── README.md



