package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

// Expr(...)  T => Expr[T]

import scala.quoted.*

inline def test(inline operation: List[Int]) = ${ testImpl('operation) }

def testImpl(operation: Expr[List[Int]])(using Quotes): Expr[Unit] =
  operation match
    case '{ ($l: List[Int]) ++ ($r: List[Int]) } =>
      '{ println($l) }
    case '{ $list: List[Int] } =>
      '{ println("???") }
