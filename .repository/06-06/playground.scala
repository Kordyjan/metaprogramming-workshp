package e06

// Excercise 06: Expressions

// '{...}  T => Expr[T]
// ${...}  Expr[T] => T

// Expr(...)  T => Expr[T]

import scala.quoted.*

case class Foo(x: Int, y: Int)

def extractString: String = ???

def test(using Quotes) =
  val text = "Hello World"
  val textExpr: Expr[String] = Expr(text)

  val text2 = textExpr.value // Some(...)
  '{ extractString }.value   // None
  Expr(Foo(1, 2)).value