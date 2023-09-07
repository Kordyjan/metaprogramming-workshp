# metaprogramming-workshp

## Setup

To work with the repository you will need [scala-cli](https://scala-cli.virtuslab.org/install).

After running

```sh
scala-cli setup-ide .
```

you can import the project to the IDE of your choice.

## Exercises

There is a script file that will help prograssing with excercises.

To reset all excercises run

```sh
./course.sc reset
```

To move to the next step in one of the excercises (e.g. 7) run

```sh
./course.sc 7 next
```

To see all options run

```sh
./course.sc --help
```

On windows you may have to use longer form of invocation, so to go to the next stop in excercise 7, run:

```sh
scala-cli course.sc -- 7 next
```