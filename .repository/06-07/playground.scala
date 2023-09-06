package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

// Expr(...)  T => Expr[T]

import scala.quoted.*

def test(using Quotes) =
  val operation = '{ 3 :: Nil }
  operation match
    case '{ ($a: Int) :: ($rest: List[Int]) } =>
      '{ println($a) }
    case '{ $list: List[Int] } =>
      '{ println("???") }
