# api-rest-loader-excel-to-json

L'objectif  est de concevoir une API REST pour pouvoir charger un fichier Excel et 
offrir la possibilité de retrouver la structure du fichier chargé sous un format JSON

# Etude et Conception

Pour atteindre cet objectif il faut récupérer le fichier Excel et enregistrer ses éléments sur une base de données h2 en mémoire.
Ensuite créer deux tableaux ExelFile pour enregistrer le nom du fichier pour ensuite y faire appel lorsqu'on veut par exemple récupérer le nom du fichier et la table Employee pour enregistrer les données de ce fichier.
Faire un Mapping entre ces tables avec une relation OneToMany, cela me permettra de récupérer le nom du fichier et ses éléments comme on l'a défini sur le WS qui recherche le nom du fichier et qui l'affiche avec ses éléments.
Enfin cela me permettra aussi de faire des mis à jour sur les données du fichier en créant une interface qui étends   l'interface CrudRepository avec des méthodes spécifiques que je définirai sur cette interface en utilisant l'annotation @Query.
Ces repositories seront utilisés sur le contrôleur nous permettant de créer ses WS REST.
Pour charger le fichier Excel et faire des recherches, j’avais prévu de créer un IHM avec Angular une fois qu'on sera sur le localhost:8080 puisqu'on ne devait pas utiliser un autre logiciel.


# Test

Pour tester l'implémentation des WS REST , j'avais prévu d'utiliser REST Assured 

# Documentation API WS REST

J'avais prévu d'utiliser SWAGGER pour faire la documentation des WS


# Fonctionnalités API WS REST

* Upload and process Excel file and saving the file in the h2 database
* Recherche du nom d'un fichier Excel et affichage sous un format Json

* Ajout du nom de fichier Excel dans une base de donnee et affichage sous format JSON
* Mise à jour des éléments du fichier Excel et affichage sous format Json

# NB

J'ai travaillé sur un fichier nommé Employee.xlsx avec un schema de table bien défini.
Vous pouvouvez le recupérer via le lien en dessous.

Créer un dossier  sur C avec le chemin  suivant  C:/temp pour que le service de Upload File soit disponible.
Vous pouvouvez aussi regarder quelques images sur les résultats que j'ai obtenu sur POSTMAN et la console de h2.
Vous pouvouvez le recupérer sur le lien. 
Pour voir le console h2 et effectuer des requêtes sur les données : http://localhost:8080/console
https://github.com/mtn2018/api-rest-loader-excel-to-json/tree/master/src/main/resources/templates



# Méthode Procédé

Librairies utilisés:

- Apache POI pour manipuler le fichier Exel
- Jackson pour afficher les objects sous format JSON
- h2 pour stocker les données en mémoire lorsqu'on lance l'application
- Spring Boot pour l'automation des configurations et Spring MVC pour créer les ressoures de nos services REST
- Utilisation de Spring Jpa pour gérer les tables Employee et ExelFile avec les repositories. Il y'a une relation OneToMany entre 
  Employee et ExelFile nous permettant de gérer le service qui fait des mises à jour.
  

#  END-POINTS URL

- Upload File: http://localhost:8080//api/ositel/uploadExcelFile/idExcelFile avec idExcelFile  un type Long
- Ajout du nom de fichier : http://localhost:8080//api/ositel/searchExcelFile/{name}
- Affichage dees données du fichier Excel : http://localhost:8080//api/ositel//allEmployees

# Usage

## Ouvrez votre ligne de commande et placez vous sur un dossier

* git clone https://github.com/mtn2018/api-rest-loader-excel-to-json.git
* cd api-rest-loader-excel-to-json
* mvn spring-boot:run
* Attendez le lancement de l'application 
* Aller sur votre  navigateur to http://localhost:8080 si vous voyez ce message sur le console "Tomcat started on port(s): 8080 ..."



