package e09

// Excercise 09: Reflection API
// Modify `inspect` macro so it prints the underlying tree for the expression.

import scala.quoted.*

inline def inspect(inline expr: Any): String = ${ inspectImpl('expr) }

def inspectImpl(expr: Expr[Any])(using Quotes): Expr[String] =
  import quotes.reflect.*

  val result: Term = expr.asTerm
  result match
    case Inlined(_, _, Block(_, value)) => Expr(value.toString())
    case _ => Expr("???")