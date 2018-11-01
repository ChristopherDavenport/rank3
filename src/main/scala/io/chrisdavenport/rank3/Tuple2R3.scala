package io.chrisdavenport.rank3

final case class Tuple2R3[F[_[_]], G[_[_]], H[_]](t: (F[H], G[H]))