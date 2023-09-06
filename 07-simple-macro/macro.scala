package e07

import scala.quoted.*

inline def analyze(inline operation: Int) = ${ analyzeImpl('operation) }

def analyzeImpl(operation: Expr[Int])(using Quotes): Expr[Int] = operation match
  case '{ ($l: Int) + ($r: Int) } => {
    val lRec = analyzeImpl(l)
    val rRec = analyzeImpl(r)
    '{
      val l = $lRec
      val r = $rRec
      val res = l + r
      println("sum of " + l + " and " + r + " is " + res)
      res
    }
  }
  case '{ ($l: Int) * ($r: Int) } => {
    val lRec = analyzeImpl(l)
    val rRec = analyzeImpl(r)
    '{
      val l = $lRec
      val r = $rRec
      val res = l * r
      println("product of " + l + " and " + r + " is " + res)
      res
    }
  }
  case expr => expr

