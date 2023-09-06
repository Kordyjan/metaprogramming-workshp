package e10

import scala.quoted.*

inline def inspect(expr: Any): Map[String, String] = ${ inspectImpl('expr) }

def inspectImpl(expr: Expr[Any])(using Quotes): Expr[Map[String, String]] =
  '{ Map() }