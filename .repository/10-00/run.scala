package e10

// Excercise 10: Reflection API 2
// Modify `inspect` macro so it returns map representing all public methods that do not take parameters.
// Keys in the map should be method names, values should be string representations of the method results.
// For example the method below should print out something similar to:
// ```
//   someConstant: 42
//   ##: 1775434506
//   greeting: Hello, I am John
// ```

class Foo(name: String):
  def greeting: String = s"Hello, I am $name"
  def someConstant = 42

def run =
  val john = Foo("John")
  val inspection: Map[String, String] = inspect(john)
  inspection.foreach: (k, v) =>
    println(s"$k: $v")