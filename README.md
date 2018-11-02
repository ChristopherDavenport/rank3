# rank3 [![Build Status](https://travis-ci.com/ChristopherDavenport/rank3.svg?branch=master)](https://travis-ci.com/ChristopherDavenport/rank3)

A set of algebras exposing operations for rank3 transformations. Such that the expression operates on
`F[_[_]]` and forall `H[_]`.

To this end we currently expose 4 sets of rank3 constructs

```scala
trait Function1R3[F[_[_]], G[_[_]]]{
  def apply[H[_]](a: F[H]): G[H]
}
type ~~> = Function1R3

EitherR3[F[_[_]], G[_[_]], H[_]] = Either[F[H], G[H]]
IorR3[F[_[_]], G[_[_]], H[_]] = Ior[F[H], G[H]]
Tuple2R3[F[_[_]], G[_[_]], H[_]] = (F[H], G[H])
```

Each of the algebras can be mixed to build arbitrary composition over rank3 values `forall * -> *`

## Example

```scala
trait Foo[F[_]]{
  def foo: F[Int]
}
trait Bar[F[_]]{
  def bar: F[Int]
}
val transform = new ~~>[Tuple2R3[Functor, Foo, ?[_]], Bar] {
  def apply[F[_]](fh: Tuple2R3[Functor, Foo, F]): Bar[F] = new Bar[F]{
    def bar = fh.fst.map(fh.snd.foo)(_ + 1)
  }
}
```
