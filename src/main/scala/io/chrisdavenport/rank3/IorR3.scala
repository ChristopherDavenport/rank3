package io.chrisdavenport.rank3

import cats.data.Ior
import cats.implicits._

final case class IorR3[F[_[_]], G[_[_]], H[_]](run: Ior[F[H], G[H]]){

  def left: Option[F[H]] = run.fold(_.some, _ => None, (l, _) => l.some)
  def onlyLeft: Option[F[H]] = run.fold(_.some, _ => None, (_, _) => None)

  def right: Option[G[H]] = run.fold(_ => None, _.some, (_, r) => r.some)
  def onlyRight: Option[G[H]] = run.fold(_ => None, _.some, (_, _) => None)

  def mapR3[N[_[_]]](f: G ~~> N): IorR3[F, N, H] = IorR3(run.map(f(_)))
  def leftMapR3[N[_[_]]](f: F ~~> N): IorR3[N, G, H] = IorR3(run.leftMap(f(_)))


  def semiFold[C](left: F[H] => C, right: G[H] => C, both: (F[H], G[H]) => C): C =
    run.fold(left, right, both)

  def fold[M[_[_]]](left: F ~~> M, right: G ~~> M, both: Tuple2R3[F, G, ?[_]] ~~> M): M[H] = 
    run.fold(
      left(_),
      right(_),
      (l, r) => both(Tuple2R3(l, r))
    )
}

object IorR3 {
  def leftc[F[_[_]], G[_[_]], H[_]](left: F[H]): IorR3[F, G, H] = IorR3(Ior.left(left))
  def rightc[F[_[_]], G[_[_]], H[_]](right: G[H]): IorR3[F, G, H] = IorR3(Ior.right(right))
  def bothc[F[_[_]], G[_[_]], H[_]](left: F[H], right: G[H]): IorR3[F, G, H] = IorR3(Ior.both(left, right))
}