package io.chrisdavenport.rank3
package typeclasses

trait BifunctorR3[F[_[_[_]], _[_[_]]]]{
  def bimapR3[M[_[_]], N[_[_]], Y[_[_]], Z[_[_]]](fa: F[M, N])(f: M ~~> Y, g: N ~~> Z): F[Y, Z]

  def leftFunctor[N[_[_]]] = {
    type LeftFunctor[M[_[_]]] = F[M, N]
    new FunctorR3[LeftFunctor]{
      def mapR3[H[_[_]], G[_[_]]](fa: LeftFunctor[H])(f: H ~~> G): LeftFunctor[G] = 
        bimapR3[H, N, G, N](fa)(f, idR3)
    }
  }
  def rightFunctor[N[_[_]]] = {
    type RightFunctor[M[_[_]]] = F[N, M]
    new FunctorR3[RightFunctor]{
      def mapR3[H[_[_]], G[_[_]]](fa: RightFunctor[H])(f: H ~~> G): RightFunctor[G] = 
        bimapR3[N, H, N, G](fa)(idR3,f)
    }
  }
}