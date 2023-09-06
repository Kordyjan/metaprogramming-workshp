package e07

// Excercise 07: Simple Macro
// Modify the analyze implementation (you can find it in the `macro.scala` file) so it prints explanation of the multiplication and addition operations it performs.
// The output should look like this:
// '''
//  product of 3 and 4 is 12
//  sum of 2 and 12 is 14
//  product of 5 and 6 is 30
//  sum of 14 and 30 is 44
//  44
// '''

def run =
  val a = 2
  val b = 4
  val c = 6
  val res: Int = analyze(a + 3 * b + 5 * c)
  println(res)