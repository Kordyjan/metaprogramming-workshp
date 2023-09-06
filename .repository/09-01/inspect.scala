package e09

// Excercise 09: Reflection API
// Modify `inspect` macro so it prints the underlying tree for the expression.

import scala.quoted.*

inline def inspect(inline expr: Any): String = ${ inspectImpl('expr) }

def inspectImpl(expr: Expr[Any])(using Quotes): Expr[String] =
  val result = expr.show
  Expr(result)