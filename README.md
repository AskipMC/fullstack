Je n'ai pas eu le temps de terminer.
Il manque la gestion des images.
Les tags sont affichés mais pas gérés pour les restaurants.


Examen de fullstack - 08/12/23 - HUSSON Mattéo

- Concernant la possibilité de modifier une image d'illustration, avez-vous fait une route dédiée au fait de remplacer la photo ou bien considérez-vous qu'il faille simplement appeler la route de suppression puis la route d'ajout ? 
Je n'ai pas eu le temps de terminer les images.

- Concernant le stockage des images, est-il préférable de mettre d'avoir une seule table contenant tous les IDs de toutes les images (et faire une jointure systématique donc) ou bien vaut-il mieux mettre l'ID de la photo d'illustration dans la table restaurant et ne pas mettre d'ID en DB pour l'image d'illustration d'un restaurant ?
Je n'ai pas eu le temps de terminer les images.

- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner la photo systématiquement (via un lien bien sûr) ?
Non pour retourner la photo on ne passe pas par le backend, on retourne un lien puis le frontend appel de lui meme si besoin.

- Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner l'évaluation finale systématiquement ?
Non il faut retourner uniquement ce qui est nécessaire à chaque fois. C'est pour cela que je retourne 2 objets différents en fonction de la page.
- RestaurantDto
- RestaurantDetailDto

- Expliquez l'implémentation que vous avez fait des tags (quelles solutions avez-vous envisagées et pourquoi avoir retenu la vôtre en particulier)
J'ai implémenté les tags de facon à ce qu'une table regroupe le 1 par 1 je string du tag et l'id correspondant pour les restaurants.
Cette implémentation permet d'optimiser et de prendre ou pas les tags quand on le souhaite très facilement en faisant un JOIN.
Je n'ai pas fait les autres solutions comme 5 booleans dans l'objet car ce n'est pas optimisé ni bien codé.