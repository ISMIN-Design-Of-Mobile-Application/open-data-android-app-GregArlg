
Stations Carrefour  
  
Codé par :   
 - Grégory Arliguy   
 - Timothée Choukroun-Tardy 

## Description  
  
URL des données : https://data.opendatasoft.com/explore/dataset/prix_des_carburants_stations%40public/information/
  
Liste des stations services de France, le jeu de données ne contient pas de prix contrairement à ce que son titre indique.
Le jeu de données était trop volumineux à traiter pour l'application, donc nous avons filtré les stations pour ne garder que les stations services du groupe Carrefour.

Problème rencontré : 

 Sur le dernier commit nous avons ajouté le Clustering des markers, mais cela nous a posé un problème, le clic sur un marker n'ouvre plus la page d'informations correspondant à la station. Cliquer sur un marker affiche le nom et l'identifiant de la station au dessus de l'icône.
 Dans le commit précédent, ( sans le clustering des markers ), cliquer sur un marker ouvre bien la page d'informations correspondant à la station.
  
## Librairies externes  
  
Room pour la base de données interne
Retrofit pour la communication avec le serveur
Material pour le thème de l'application
  
## Consignes  
  
Lien vers le sujet : https://docs.google.com/presentation/d/1mwu2xx7_qfCZDfsRxseC94n7oBGYfhw-9xIftaTDbzk/edit#slide=id.p97  
  
### But du projet  
  
 - Le but du projet est de réaliser une application permettant de visualiser une série de données OpenData  
 - Les données devront être récupérées sur un serveur distant et affichées dans une liste et sur une carte  
 - Un clique sur un élément de la liste ou sur un marker de la carte permet d’accéder à un écran présentant le détail de l’élément  
 - Un écran présentera des informations générales sur les données récupérées  
  
### Exigences    
- [ ] Format des données OpenData :   
	 - Format Json  
	 - Avec un champ correspondant à l’url d’une image  
	 - Avec un champ correspondant à une position  
 - [ ] Application composée au minimum de 3 Fragment et 2 Activity  
 - [ ] Une Actionbar sera présente et permettra de rafraîchir les données récupérées et affichées
 
 ## Bonus
 
 - Amélioration de l’expérience utilisateur :
    - Clustering des markers sur la carte en fonction du niveau de zoom
    - Mise en place d’un système de recherche/filtre sur la liste affichée
 
 - Enrichissements techniques :
    - Mise en place d’une base de données locale pour afficher la liste d’élément en mode hors connexion
    - Utilisation de LiveData ou d’Observable pour la récupération de données dans la BDD
   
