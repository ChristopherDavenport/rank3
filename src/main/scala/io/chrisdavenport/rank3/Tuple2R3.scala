package io.chrisdavenport.rank3

final case class Tuple2R3[F[_[_]], G[_[_]], H[_]](run: (F[H], G[H])){
  def fst: F[H] = run._1
  def snd: G[H] = run._2
}
object Tuple2R3 {
  def of[F[_[_]], G[_[_]], H[_]](fst: F[H], snd: G[H]): Tuple2R3[F, G, H] = Tuple2R3((fst, snd))
}