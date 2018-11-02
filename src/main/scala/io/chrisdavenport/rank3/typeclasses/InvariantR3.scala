package io.chrisdavenport.rank3
package typeclasses

trait InvariantR3[A[_[_[_]]]]{
  def imapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G)(g: G ~~> F): A[G]
}