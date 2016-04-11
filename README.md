# Projet Efrei Java 2016

Application de location de véhicules avec interface utilisateur Swing.
Sauvegarde des données dans un fichier SQLite sans requêtes : JPA.

## Auteurs
* [Timothée Barbot](https://github.com/btimo)
* [Adrien Poupa](https://github.com/AdrienPoupa)
* [Stéphane Gâteau](https://github.com/stephanegateau)

## Dépendances
* [eBean ORM](https://github.com/ebean-orm/avaje-ebeanorm)
* [iTextPDF](https://github.com/itext/itextpdf)
* [Gradle](http://gradle.org/)
* [Xerial SQLite JDBC Driver](https://bitbucket.org/xerial/sqlite-jdbc)
* [JFreeChart](http://www.jfree.org/jfreechart/)
* [JUnit](http://junit.org/junit4/)
* [JDatePicker](https://github.com/JDatePicker/JDatePicker)

## Installation

1. Récupérer les dépendances externes avec *Gradle*
```
gradle clean // necessaire si il ne s'agit pas d'un clone propre
gradle build
```
2. Installer le plugin `EbeanORM Enhancement` sur IntelliJ
3. Compiler le dossier *models*
4. Lancer location.Application.main()


## Jar exécutable
Vous pouvez tester l'application en dézippant l'archive présente à la source (LocAppli.zip) et en lançant le .jar.
