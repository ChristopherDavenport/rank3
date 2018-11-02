package io.chrisdavenport.rank3
package typeclasses

// What in the world operates at Rank4 to utilize a Rank3 Function.
// Cool concept.
trait ContravariantR3[A[_[_[_]]]] extends InvariantR3[A]{
  def contramapR3[F[_[_]], G[_[_]]](fa: A[F])(f: G ~~> F): A[G]
  def imapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G)(g: G ~~> F): A[G] = 
    contramapR3(fa)(g)
}
