package e02

// Excercise 02: Inline params
// Try to guess what will be printed on the console after running the method `run`.
// Possible answers are in the `answers.txt` file.
// Then, try to change the method `double` to get other input.

def run =
  val beeper = new Beeper
  val res = double(beeper.beep())
  println(res)

inline def double(x: Int): Int =
  println("doubling")
  x + x

class Beeper:
  private var counter = 0

  def beep(): Int =
    counter += 1
    println("BEEP! " * counter)
    counter