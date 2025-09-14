# Basic To-Do CLI

A tiny command-line To‑Do application written in Java. Stores tasks in a simple text file (`tasks.txt`) and supports listing, adding, completing, and removing tasks. Intended as a small learning project, easy to run and extend.

---

## Features

* List tasks with completion status
* Add tasks
* Mark tasks complete (keeps them in the file as completed)
* Remove tasks
* Simple file-based persistence (`tasks.txt`)

---

## Prerequisites

* Java 11+ (Java 21 recommended)

---

## Build & Run

### Using IntelliJ

You mentioned you know how to create a JAR in IntelliJ — use the Build → Build Artifacts... menu to produce a runnable JAR and run with:

```
java -jar todo.jar
```

### Manual (javac + jar)

1. Compile: `javac -d out src/*.java`
2. Create a jar: `jar --create --file todo.jar -C out/ .`
3. Run: `java -jar todo.jar`

---

## Usage (interactive)

Start the program and follow the numbered menu:

* `1` List tasks
* `2` Add task — enter the task description when prompted
* `3` Complete task — enter the task number to mark it done
* `4` Remove task — enter the task number to remove
* `5` Exit (saves on exit)

---

## Data format (`tasks.txt`)

Each task is stored as one line. The app uses a literal separator string (a key) between description and completion flag. Example line format (literal):

```
<description><key><true|false>
```

Notes:

* The key is treated as a literal sequence of characters; the program parses by finding the first occurrence of the key.
* Empty or malformed lines are ignored when loading.

---

## Troubleshooting

* If the app crashes reading `tasks.txt`, make sure lines follow the format above.
* If you see encoding issues, open or save the file with UTF‑8.
* Non-numeric menu input is handled; if the app prints `Invalid input` try entering a number (1–5).

---

## Next steps / ideas (I may or may not do)

* Persist richer metadata as JSON
* Add undo / confirm on delete
* Convert to a simple REST API (Spring Boot)
