# TP2 – Sockets TCP : E/R de CC & objets
**Samet Youssef – LSI3 – Développement d'applications réparties**

## Étape 1 : Préparation de l'espace de travail
Création du répertoire `SametYoussef_LSI3_DevAppReparties` et des dossiers `Activite2-1` et `Activite2-2`.

![Espace de travail](screenshots/0-workspace.png)

## Activité 2-1 : Échange de chaînes de caractères
Le client valide la syntaxe de l'opération avec une expression régulière (refus de `25 ** 55`, `abc + 3`),
puis envoie opérande 1, opérateur et opérande 2 ligne par ligne (`PrintWriter` / `BufferedReader`).
Le serveur calcule (+, -, *, /) et renvoie le résultat que le client affiche.

**Serveur :**
![Serveur 2-1](screenshots/2-1-serveur.png)

**Client (opération valide + syntaxe invalide) :**
![Client 2-1](screenshots/2-1-client.png)

## Activité 2-2 : Échange d'objets
La classe `Operation` implémente `Serializable`. Le client envoie un objet `Operation`
(`ObjectOutputStream`), le serveur le reçoit (`ObjectInputStream`), récupère les données,
calcule et renvoie le résultat au client.

**Serveur :**
![Serveur 2-2](screenshots/2-2-serveur.png)

**Client :**
![Client 2-2](screenshots/2-2-client.png)

## Exécution
```bash
cd Activite2-2
javac *.java
java Server      # terminal 1
java Client      # terminal 2
```
