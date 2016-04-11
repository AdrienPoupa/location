**NE PAS MODIFIER LES DOCUMENTS SOURCE ET TEST MIS EN PLACE PAR GRADLE**

# Installation

1. Récupérer les dépendances externes avec *Gradle*
```
gradle clean // necessaire si il ne s'agit pas d'un clone propre
gradle build
```
2. Installer le plugin `EbeanORM Enhancement` sur IntelliJ
3. Compiler le dossier *models*
4. Lancer location.Application.main()


## Ebean

Il va générer deux fichiers :
- `sqlite-create-all.sql`
- `sqlite-drop-all.sql`

Une fois qu'on aura une base de données stables,
on fera juste des migrations en passant par `flywaydb`.


## Jar exécutable
Vous pouvez tester l'application en dézippant l'archive présente à la source (LocAppli.zip) et en lançant le .jar.