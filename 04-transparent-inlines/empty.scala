package e04

// Excercise 04: Transparent inlines
// Uncomment the commented lines in the run method and try to make it compile by changing the signature of `empty`.
// Then, modify the `empty` method in such a way that it fails during the compilation if the name of the type is not recognized, insted of crashing at runtime.

def run =
  // val intList: List[Int] = 42 :: empty("List")
  // val stringList: List[String] = empty("String") :: empty("List")
  // val number: Int = empty("Int") * 2
  println("ok?")

def empty(name: String) =
  name match
    case "List" => List.empty
    case "String" => ""
    case "Int" => 0
    case _: String => throw IllegalArgumentException()
