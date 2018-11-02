package io.chrisdavenport

package object rank3 {
  type ~~>[F[_[_]], G[_[_]]] = Function1R3[F, G]
  def idR3[F[_[_]]] = new ~~>[F, F]{
    def apply[H[_]](fa: F[H]): F[H] = fa
  }
}