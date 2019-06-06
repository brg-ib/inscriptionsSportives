# inscriptionsSportives
1ère présentation : https://prezi.com/p/d3pqtdjxa_vo/
-----------------


# PPE-JAVA | Inscriptions Sportives
***

## Mise en situation 
Cette situation professionnelle est réalisée dans le contexte de la M2L, ou la maison des ligues de Lorraine. Sa mission est de fournir aux ligues sportives différents services. De plus, elle gère l’organisation de compétitions et ainsi la gestion des équipes et des personnes y participant. 

## Intitulé de la situation professionnelle
Création d’une application de gestion d’inscriptions aux événements sportifs.

## Technologie 

inscriptionsSportives est un projet java qui a été imposé comme base de départ pour notre projet.

De plus il nous été imposé d'utilisé [Hibernate](https://hibernate.org/) comme ORM. 

## Décomposition du projet

Le projet se décompose en 4 itérations majeure.

###### Itération 1
- Tests unitaires
- Ajout des fonctionalités manquantes, indiquées dans le code avec des //TODO
- Ajout d’exceptions dans la couche métier pour gérer les erreurs
- Modélisation de la base de données
- MCD

###### Itération 2
  - Création d’une base de données
  - Installation de la base de données sur un serveur
  - Mise en place d’un dialogue utilisateur à l’aide de la bibliothèque [CommandLine](https://github.com/alexandreMesle/CommandLine)
  
###### Itération 3
  - Connexion à la base de données avec Hibernate
  - Réflexion sur le maquettage des fenêtres

###### Itération 4 (Option)
  - Développement d’une IHM en Java (Swing)
  - Documentation utilisateur

  
## Installation 

#### Prérequis
* JAVA
* MySQL
* [Hibernate]
* [CommandLine](https://github.com/alexandreMesle/CommandLine) 

#### Procédure
- Une fois téléchargé CommandLine accolé le au dossier InscriptionsSportives et vérifiez que le lien dans le Build Path est fonctionnel.

- Dans le dossier `src/hibernate/` copiez le fichier `config.cfg.xml.example` en `config.cfg.xml`.

- Configurez le fichier `config.cfg.xml` pour qu'il puisse avoir accès à la base de donnée MySQL.

- L'application possède un mode en version ligne de commande [CommandLine].

- Veuillez à bien lancer votre serveur MySQL et ensuite lancez l'application à partir du fichier `src/hibernate/mainApp.java`.

## Auteur
* **Ihcen Borgi** - [www.borgi.fr](http://www.borgi.fr/)

