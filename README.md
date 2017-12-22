Dépôt du projet de test ParisVentes :

Voilà un (tout) début d'implémentation de site avec le framework Struts.

Pour le moment, les fonctionnalités sont les suivantes:

- Connexion (login) et déconnexion (logout)
- Enregistrement d'un·e nouvel·le utilisateur·ice dans une base de données (avec quelques validations rudimentaires)
- Recherche d'un·e utilisateur·ice préalablement enregistré·e (par e-mail uniquement)
- Affichage d'une liste d'articles pour tout·e utilisateur·ice connecté·e
- Page "détail d'un article" au clic sur l'une des images de la liste.


Pour pouvoir tester cette implémentation, trois étapes simples:

- IMPORTANT: éxécutez le fichier parisventes.sql, car l'implémentation de ce code dépend de mon dump.

- Vérifiez que vous avez bien un serveur lancé avec maven jetty:run dans le dossier du pom.xml (ou qu'un Tomcat 8.5 tourne, c'est selon)

- Entrez localhost:8080/struts/index dans votre navigateur pour commencer à naviguer.


Les différentes fonctionnalités du site arriveront au fur et à mesure du développement.
