package e07

import scala.quoted.*

inline def analyze(inline operation: Int) = ${ analyzeImpl('operation) }

def analyzeImpl(operation: Expr[Int])(using Quotes): Expr[Int] = operation // TODO: implement analyze macro