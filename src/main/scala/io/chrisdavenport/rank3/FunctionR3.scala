package io.chrisdavenport.rank3

trait FunctionR3[F[_[_]], G[_[_]]]{
  def apply[H[_]](fh: F[H]): G[H]
}
