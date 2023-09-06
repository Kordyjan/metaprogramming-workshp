package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

import scala.quoted.*

def test(using Quotes) =

  val x: Expr[List[Int]] =
    val number = 7 // 0
    '{
      val number2 = 8 // 1
      ${
        val number3 = 9 // 0
        val printExpr = '{
          println(number2) // 1
        }
        printExpr // 0
      }
      42 :: Nil // 1
    }