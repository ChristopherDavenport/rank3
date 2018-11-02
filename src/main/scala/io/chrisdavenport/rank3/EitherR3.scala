package io.chrisdavenport.rank3

import cats.implicits._

final case class EitherR3[F[_[_]], G[_[_]], H[_]](run: Either[F[H], G[H]]){
  def left: Option[F[H]] = run.fold(_.some, _ => None)
  def right: Option[G[H]] = run.fold(_ => None, _.some)

  def semiFold[C](left: F[H] => C, right: G[H] => C): C = run.fold(left(_), right(_))
  def fold[M[_[_]]](left: F ~~> M, right: G ~~> M): M[H] = run.fold(left(_), right(_))
}
object EitherR3 {
  def leftc[F[_[_]], G[_[_]], H[_]](left: F[H]): EitherR3[F, G, H] = EitherR3(Left(left))
  def rightc[F[_[_]], G[_[_]], H[_]](right: G[H]): EitherR3[F, G, H] = EitherR3(Right(right))
}