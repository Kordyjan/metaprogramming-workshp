package e08

// Excercise 08: Warnings and Errors
// Modify the previous example so it shows warning when it encounters subtraction.


def run =
  val a = 2
  val b = 4
  val c = 6
  val res: Int = analyze(a - 3 * b + 5 * c)
  println(res)