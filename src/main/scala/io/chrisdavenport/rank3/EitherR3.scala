package io.chrisdavenport.rank3

final case class EitherR3[F[_[_]], G[_[_]], H[_]](e: Either[F[H], G[H]]){
  def fold[M[_[_]]](left: F ~~> M, right: G ~~> M): M[H] = e.fold(left(_), right(_))
}