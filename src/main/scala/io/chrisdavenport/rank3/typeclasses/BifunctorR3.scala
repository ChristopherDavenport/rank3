package io.chrisdavenport.rank3
package typeclasses

trait BifunctorR3[F[_[_[_]], _[_[_]]]]{ self => 
  def bimapR3[M[_[_]], N[_[_]], Y[_[_]], Z[_[_]]](fa: F[M, N])(f: M ~~> Y, g: N ~~> Z): F[Y, Z]
}