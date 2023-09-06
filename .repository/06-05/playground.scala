package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

import scala.quoted.*

def test(using Quotes) =
  val text = "Hello World"
  val textExpr: Expr[String] = Expr(text)
  val expr: Expr[Unit] = '{ println(${Expr(text)}) }