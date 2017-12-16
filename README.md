Dépôt du projet de test ParisVentes :

Voilà un (tout) début d'implémentation de site avec le framework Struts.

Pour le moment, les fonctionnalités sont les suivantes:

- Connexion (login) et déconnexion (logout)
- Enregistrement d'un·e nouvel·le utilisateur·ice dans une base de données (avec quelques validations rudimentaires)
- Recherche d'un·e utilisateur·ice préalablement enregistré·e (par e-mail uniquement)
- Affichage d'une liste d'articles pour tout·e utilisateur·ice connecté·e
- Page "détail d'un article" au clic sur l'une des images de la liste.


Pour pouvoir tester cette implémentation, trois étapes simples:

- Vérifiez que vous avez bien un serveur lancé avec maven jetty:run dans le dossier du pom.xml.
- Dans le fichier src/main/java/com/parisventes/beans/DB.java, changez les deux attributs statiques pour l'emplacement absolu de vos fichiers articles.txt et personnes.txt
- Entrez localhost:8080/struts/index dans votre navigateur pour commencer à naviguer.


Les différentes fonctionnalités du site arriveront au fur et à mesure du développement.
