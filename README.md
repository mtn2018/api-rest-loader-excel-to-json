# api-rest-loader-excel-to-json

L'objectif de ce test est de concevoir une API REST pour pouvoir charger un fichier Excel et 
offrir la possibilité de retrouver la structure du fichier chargé sous un format JSON

# Features

* Upload and process Excel file and saving the file in the h2 database
* Recherche du nom d'un fichier Excel et affichage sous un format Json

* Ajout du nom de fichier Excel dans une base de donnee et affichage sous format JSON
* Mise à jour des éléments du fichier Excel et affichage sous format Json

# NB

J'ai travaillé sur un fichier nommé Employee.xlsx avec un schema de table bien défini.
Vous pouvouvez le recupérer 
via ce lien: https://github.com/mtn2018/api-rest-loader-excel-to-json/tree/master/src/main/resources/templates
Créer un dossier avec le chemin  suivant : C:/temp pour que avoir le service de Upload File qui l'utilisera.


# Methods Procédé

Librairies utilisés:

- Apache POI pour manipuler le fichier Exel
- Jackson pour afficher les objects sous format JSON
- h2 pour stocker les données en mémoire lorsqu'on lance l'application
- Spring Boot pour l'automation des configurations et Spring MVC pour créer les ressoures de nos services REST
- Utilisation de Spring Jpa pour gérer les tables Employee et ExelFile avec les repositories. Il y'a une relation OneToMany entre 
  Employee et ExelFile nous permettant de gérer le service qui fait des mises à jour.
  

# End Points 
URLS END-POINTS
- Upload File: http://localhost:8080//api/ositel/uploadExcelFile/idExcelFile
- Ajout du nom de fichier : http://localhost:8080//api/ositel/searchExcelFile/{name}
- Affichage dees données du fichier Excel : http://localhost:8080//api/ositel//allEmployees




# Usage

## If you are using IntelliJ

Open the project in IntelliJ

Go to src/java/com.github.chen0040.bootslingshot and right-click SpringSlingshotApplication and select "Run main()" in IntelliJ

Navigate to your web browser to http://localhost:8080

## If you are uploading a Excel file

Once at http://localhost:8080, click "Excel Sample Download" to download a csv sample, then click "Choose File" to load the
downloaded Excel sample,and then click "Upload Excel", you will notice that as the product is being saved on the remote server,
the web page keeps on updating the progress (done using websocket and sockjs). At the backend, the Thread.sleep is used to simulate
long running process.
