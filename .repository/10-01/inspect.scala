package e10

import scala.quoted.*

inline def inspect(expr: Any): Map[String, String] = ${ inspectImpl('expr) }

def inspectImpl(expr: Expr[Any])(using Quotes): Expr[Map[String, String]] =
  import quotes.reflect.*
  val term = expr.asTerm

  val pairs: List[Expr[(String, String)]] = term.tpe.typeSymbol.methodMembers
    .filter: m =>
      m.paramSymss.size == 0
    .map: m =>
      val valueExpr = term.select(m).asExpr
      val nameExpr = Expr(m.name)
      '{ $nameExpr -> ${valueExpr}.toString() }

  val pairsVararg: Expr[Seq[(String, String)]] = Varargs(pairs)

  '{ ${pairsVararg}.toMap }