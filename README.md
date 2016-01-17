# TP Refactoring d'un viewer

CE CODE EST VOLONTAIREMENT CRADE : Il sert de support pour un TP sur le refactoring
de code. Dans la vraie vie, utilisez une bibliothèque telle [Apache™ Batik SVG Toolkit](https://xmlgraphics.apache.org/batik/).

## MAVEN

Le projet s'appuie sur MAVEN pour gérer les dépendances. Le fichier [pom.xml](pom.xml) liste
les différentes dépendances :

* log4j2 : Gestion des logs applicatifs
* JDOM : Lecture de fichier XML
* JUnit : Ecriture de tests unitaires

Pour l'import du projet dans eclipse :

File/Import/MAVEN/Existing Maven Projects, puis browser pour trouver le fichier pom.xml

Pour lancer les tests en ligne de commande : ```maven clean test```

# TODO

Le fichier [TODO.md](TODO.md) énumère la liste des actions a effectuer pour chaque version.

Ces versions sont tagguées en guise de correction.






