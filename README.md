Les différents modules de l'application sont reliés par le biais d'injection de dépendances.

Pour mettre en place le service web j'ai mis en place une architecture avec un controller un service ainsi qu'un repository

Lors de l'inscription une verification est effectué sur l'objet membership qui est passé à l'aide d'un Predicate afin de tester les deux scénarios d'inscription avec un MembershipApplication valide et invalide j'ai mis en place deux validateur qui 