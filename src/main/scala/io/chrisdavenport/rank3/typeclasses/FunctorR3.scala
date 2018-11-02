package io.chrisdavenport.rank3
package typeclasses

// What in the world operates at Rank4 to utilize a Rank3 Function.
// Cool concept.
trait FunctorR3[A[_[_[_]]]]{
  def mapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G): A[G]
}

