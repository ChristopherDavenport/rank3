package io.chrisdavenport.rank3
package typeclasses

// What in the world operates at Rank4 to utilize a Rank3 Function.
// Cool concept.
trait FunctorR3[A[_[_[_]]]] extends InvariantR3[A]{
  def mapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G): A[G]
  def imapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G)(g: G ~~> F): A[G] = 
    mapR3(fa)(f)
}
object FunctorR3 {
  def apply[A[_[_[_]]]](implicit ev: FunctorR3[A]): FunctorR3[A] = ev
}

