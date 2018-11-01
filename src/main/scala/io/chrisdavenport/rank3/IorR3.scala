package io.chrisdavenport.rank3

import cats.data.Ior

final case class IorR3[F[_[_]], G[_[_]], H[_]](run: Ior[F[H], G[H]]){
  def fold[M[_[_]]](left: F ~~> M, right: G ~~> M, both: Tuple2R3[F, G, ?[_]] ~~> M): M[H] = 
    run.fold(
      left(_),
      right(_),
      (l, r) => both(Tuple2R3[F, G, H]((l, r)))
    )
}