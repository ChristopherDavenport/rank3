package io.chrisdavenport.rank3
package typeclasses

trait InvariantR3[A[_[_[_]]]]{
  def imapR3[F[_[_]], G[_[_]]](fa: A[F])(f: F ~~> G)(g: G ~~> F): A[G]
}
object InvariantR3 {
  def apply[A[_[_[_]]]](implicit ev: InvariantR3[A]): InvariantR3[A] = ev
}