package io.chrisdavenport.rank3

trait Function1R3[A[_[_]], Y[_[_]]]{
  def apply[Z[_]](a: A[Z]): Y[Z]
}
trait Function2R3[A[_[_]],B[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z]): Y[Z]
}
trait Function3R3[A[_[_]],B[_[_]],C[_[_]], Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z]): Y[Z]
}
trait Function4R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z]): Y[Z]
}
trait Function5R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z]): Y[Z]
}
trait Function6R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],F[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z],f: F[Z]): Y[Z]
}
trait Function7R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],F[_[_]],G[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z],f: F[Z],g: G[Z]): Y[Z]
}
trait Function8R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],F[_[_]],G[_[_]],H[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z],f: F[Z],g: G[Z], h: H[Z]): Y[Z]
}
trait Function9R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],F[_[_]],G[_[_]],H[_[_]],I[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z],f: F[Z],g: G[Z], h: H[Z],i: I[Z]): Y[Z]
}
trait Function10R3[A[_[_]],B[_[_]],C[_[_]],D[_[_]],E[_[_]],F[_[_]],G[_[_]],H[_[_]],I[_[_]],J[_[_]],Y[_[_]]]{
  def apply[Z[_]](a: A[Z], b: B[Z], c: C[Z],d: D[Z],e: E[Z],f: F[Z],g: G[Z], h: H[Z],i: I[Z],j: J[Z]): Y[Z]
}
