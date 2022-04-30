1. Démarrer le serveur MySQL :

```docker-compose up```

2. Lancer le TP5 :

Lancer le projet Quarkus

```
cd tp5-quarkus
./mvnw compile quarkus:dev
```

- <a href="localhost:8080/api">localhost:8080/api<a/> pour voir toutes les routes

3. Lancer le TP10 :

```
cd tp10
yarn install 
npm start
```

BUG:
- De temps en temps, il faut refaire plusieurs fois la même action pour que ça marche, je ne comprends pas pourquoi ça me le fait... (créer une carte, un user)
