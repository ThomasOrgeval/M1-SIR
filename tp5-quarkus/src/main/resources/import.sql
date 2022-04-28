insert into user(id, name)
values (1, 'Orgeval'),
       (2, 'Barais');

insert into kanban(id, kanban, owner_id)
values (1, 'Mon premier kanban', 1),
       (2, 'Notation du projet', 2);

insert into card (id, end, estimated, name, note, place, type, url, kanban_id, user_id)
values (1, '2022-05-01', '3', 'Ajouter des tags', 'Fonction utile et agréable pour nos utilisateurs', 'Paris, France',
        'DOING', 'https://spotify.miyonu.fr', 1, 1),
       (2, '2022-05-05', '4', 'Carte de test', '', 'Espagne', 'TODO', '', 1, 1),
       (3, '2022-05-01', '1', 'Vérification des méthodes utilisées', '-GET, -POST, -PUT, -DELETE', 'Rennes, France',
        'TODO', 'http://localhost:8080/api/', 2, 2),
       (4, '2022-05-01', '1', 'Note maximale 20/20 😋', '', 'Rennes, France', 'DONE', '', 2, 2),
       (5, '2022-05-01', '1', 'Usage de technos récentes', '', 'Rennes, France', 'DOING', '', 2, 2),
       (6, '2022-05-01', '1', 'Regarder le TP7', 'Un besoin de rendre le site un peu plus complet et joli!',
        'Rennes, France',
        'TODO', '', 2, 2);
