package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

import scala.quoted.*

def test(using Quotes) =
  val x: Expr[List[Int]] = '{
    println("x")
    42 :: Nil
  }

  val y = ${x} // ???