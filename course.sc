#!/usr/bin/env -S scala-cli shebang

//> using scala 3.3.0
//> using toolkit latest

val wd = os.pwd / os.RelPath(scriptPath) / os.up
val repository = wd / ".repository"

args match
  case Array("--help" | "-help" | "-h") =>
    printUsageInfo(None)
  case Array("reset") =>
    resetAll()
  case Array(Number(excercise), "reset") =>
    resetExcercise(excercise)
  case Array(Number(excercise), "next") =>
    nextStep(excercise)
  case Array(Number(excercise), "clear") =>
    clearExcercise(excercise)
  case Array(Number(excercise), "goto", Number(step)) =>
    gotoStep(excercise, step)
  case _ =>
    printUsageInfo(Some(args))

def printUsageInfo(args: Option[Array[String]]) =
  args.foreach: a =>
    println("Unknown command: " + a.mkString(" ") + "\n")
  println("Usage: course.sc [command]")
  println("Commands:")
  println("  reset\t\t reset all excercises")
  println("  <excercise number> reset \t reset excercise")
  println("  <excercise number> next \t next step")
  println("  <excercise number> clear \t clear current changes in the excercise")
  println("  <excercise number> goto <step number> \t go to step")
  println("  --help\t\t print this help message")


def resetAll() =
  os.list(wd)
    .collect:
      case Excercise(n) => n
    .foreach(resetExcercise)

def resetExcercise(excercise: Int) =
  gotoStep(excercise, 0)

def nextStep(excercise: Int) =
  val current = getCurrent(excercise)
  val next = current + 1
  try gotoStep(excercise, next)
  catch case _ =>
    println(s"No more steps for the excercise $excercise")

def clearExcercise(excercise: Int) =
  val current = getCurrent(excercise)
  gotoStep(excercise, current)

def gotoStep(excercise: Int, step: Int) =
  val exPath = excercisePath(excercise)
  val stepPath = excerciseStep(excercise, step)
  os.remove.all(exPath)
  os.copy(stepPath, exPath)
  setCurrent(excercise, step)

def excercisePath(excercise: Int) =
  val maybePath = os.list(wd).find: path =>
    path.last.startsWith(f"$excercise%02d-")
  maybePath match
    case Some(path) if os.isDir(path) => path
    case _ => throw new Exception(s"Excercise $excercise not found")

def excerciseStep(excercise: Int, step: Int) =
  val path = repository / f"$excercise%02d-$step%02d"
  if !os.isDir(path) then
    throw new Exception(s"Excercise $excercise does not have step $step")
  path

def setCurrent(excercise: Int, step: Int) =
  val path = repository / f"$excercise"
  os.write.over(path, step.toString)

def getCurrent(excercise: Int) =
  val path = repository / f"$excercise"
  if !os.isFile(path) then 0
  else os.read(path).toInt

object Number:
  def unapply(s: String): Option[Int] =
    try
      Some(s.toInt)
    catch
      case _: NumberFormatException => None

object Excercise:
  def unapply(path: os.Path): Option[Int] =
    val name = path.last
    if os.isDir(path) && name.matches("""\d\d-.*""") then
      Some(name.take(2).toInt)
    else None