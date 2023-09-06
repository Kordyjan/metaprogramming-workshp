package e05

// Excercise 05: Type refinements

class Json(data: Map[String, Any])

type PersonJson = Json { val name: String; val age: Int }

def run =
  val personJson = Json(Map("name" -> "John", "age" -> 42)).asInstanceOf[PersonJson]
  val name: String = personJson.name
  println(name)