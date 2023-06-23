# Word Counter

[![Build Status](https://github.com/palerique/wordcounter/workflows/Build%20and%20Test/badge.svg)](https://github.com/palerique/wordcounter/actions)

**Exercise:**

Implement a simple Java program that reads a text file and counts the occurrence of
each word in the file. The program should display the words along with their respective
counts in descending order.

**Requirements:**

1. The program should be implemented using Java.
2. The input file path should be provided as a command-line argument.
3. The program should handle large files efficiently.
4. The program should ignore punctuation marks and consider words in a
   case-insensitive manner.
5. The output should display each word along with its count in descending order
   based on the count.
6. The program should be well-structured, readable, and follow good coding
   practices.
7. Provide appropriate error handling for file reading and any other potential exceptions.

**Example:**

Suppose we have a text file named "sample.txt" with the following content:

```
This is a sample text. It contains multiple words. This is a simple exercise.
```

~~Running the program with the command: `java WordCountApp sample.txt` should
produce the following output:~~ (Because we are now packaging the application as a jar, the command to run the
application is slightly different, but the output is the same, check the instructions below)

```
word: this, count: 2 word: a, count: 2 word: is, count: 2 word: sample, count: 1
word: text, count: 1 word: it, count: 1 word: contains, count: 1 word: multiple,
count: 1 word: simple, count: 1 word: exercise, count: 1
```

**Project Specifications:**

To execute this project you need a unix like machine with the following software installed:
- Java 17

You can also run on windows using a terminal emulator like git bash. Or running the build an java jar execution
manually.

**Instructions:**

From the project root run:

```
./wordCounter.sh ./app/src/test/resources/sample.txt
```

Expected output:

```
word: a, count: 2 word: this, count: 2 word: is, count: 2 word: contains, count: 1 word: multiple, count: 1 word: words,
count: 1 word: exercise, count: 1 word: simple, count: 1 word: text, count: 1 word: it, count: 1 word: sample, count:
1 %   
```
