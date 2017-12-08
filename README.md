# Projet_Webservice
### Introduction
Le projet webservice est un projet ayant pour objectif l'implémentation d'une bibliothèque de médias(films, séries, musics) en ligne gérée en java et utilisant une architecture REST pour les films et séries et une architecture SOAP pour la music.

### Prérequis
- outil de test d'API, exemple: POSTMAN
- IDE pour les test

### Installation

Pour la partie serveur:
- Ouvir le projet pjt_epsi_server dans votre IDE
- Se rendre dans le main et faire un "Run As java application server" sur la classe "ServerApplication"
- Une fois le serveur démarrer, ouvrez votre outil de test API


## Tests des fonctions
--Partie REST:--

---Films & Series:---
#Media# = soit "movie" , soit "serie" selon la classe avec laquelle vous travaillez.

----Ajout d'un média:----
- Dans votre outil de test API, remplir le champ URL en spécifiant une méthode POST avec l'url suivante:
http://localhost:8080/#Media#/admin/add#Media#/#titreMedia#
- Lancer la requête.
- L'outil renverra un "true" si l'ajout c'est effectué correctement et renverra un "false" si inversement.
     
----Rechercher un média dans la liste des médias:----
- Dans votre outil de test API, remplir le champ URL en spécifiant une méthode GET avec l'url suivante:
http://localhost8080/#Media#/#titreMedia#
- Lancer la requête.
- L'outil renverra des informations concernant un média, exemple dans le cas d'une recherche pour le film Batman l'outil renverra:
     {
      "title": "Batman",
      "id": 1,
       "isbn": 100,
        "available": true
      }
      Les informations renvoyées sont , le titre du film, son id, son isbn et son statut d'emprunt(available).
      
----Supprimer un média de la liste:----
- Dans votre outil de test API, remplir le champ URL en spécifiant une méthode DELETE avec l'url suivante:
http://localhost:8080/#Media#/admin/#titreMedia#
- L'outil renverra les informations lié au média supprimé si la suppression s'est effectuée correctement
              
----Emprunter un média----
            - Dans votre outil de test API, remplir le champ URL en spécifiant une méthode PUT avec l'url suivante:
            http://localhost:8080/#Media#/take/#titreMedia#
            -L'outil renverra les informations du média et le statut "available" initialment en statut "true" passe à l'état "false"
            
----Rendre un média----
 - Dans votre outil de test API, remplir le champ URL en spécifiant une méthode PUT avec l'url suivante:
http://localhost:8080/#Media#/take/#titreMedia#
- L'outil renverra les informations du média et le statut "available" en statut "false" passe à l'état "true"  

----Afficher la liste des médias----
- Dans votre outil de test API, remplir le champ URL en spécifiant une méthode GET avec l'url suivante:
 http://localhost:8080/#Media#/listing
- L'outil renverra une liste des médias comprenant toutes leurs informations.
       
       
--Partie SOAP--
- Non terminé, tests non-concluants

## Conçu avec

* [Maven](https://maven.apache.org/) - Dependency Management

## Auteur

* **François Werquin*

## Savoirs

* Cours webservice Monsieur Jeffrey Duroyon
* https://spring.io/guides/gs/producing-web-service/
* https://www.codenotfound.com/2016/10/spring-ws-soap-web-service-consumer-provider-wsdl-example.html

