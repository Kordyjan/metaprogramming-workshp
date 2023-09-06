package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

// Expr(...)  T => Expr[T]

import scala.quoted.*

inline def test = ${ testImpl }

def testImpl(using Quotes): Expr[Unit] =
  val operation: Expr[List[Int]] = '{ List(1, 2, 3) ++ List(4, 5, 6) }
  operation match
    case '{ ($l: List[Int]) ++ ($r: List[Int]) } =>
      '{ println($l) }
    case '{ $list: List[Int] } =>
      '{ println("???") }
