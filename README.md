Les différents modules de l'application sont reliés par des injections de dépendances.

Pour mettre en place le service web j'ai mis en place une architecture avec un controller un service ainsi qu'un
repository pour le memebership.

Lors de l'appel d'une inscription un objet MembershipApplication contenant les données est passé au controller.

Puis une verification est effectué sur l'objet membership qui est passé à l'aide d'un Predicate afin de tester les deux
scénarios d'inscription avec un MembershipApplication valide et invalide une verification est faite sur l'age.

Suite à la validation de l'inscription le service de paiement est simulé à l'aide d'un StubPaymentService qui est passé
au service.
