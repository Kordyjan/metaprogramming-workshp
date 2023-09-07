package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

// Expr(...)  T => Expr[T]

import scala.quoted.*

def test(using Quotes) =
  val operation = '{ List(1, 2) ++ List(3, 4) }
  operation match
    case '{ ($l: List[Int]) ++ ($r: List[Int]) } =>
      '{ println($l) }
    case '{ $list: List[Int] } =>
      '{ println("???") }
