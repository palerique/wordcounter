package br.com.palerique.wordcountapp;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordCountAppTest {

  private PrintStream originalSystemOut;
  private ByteArrayOutputStream outputStream;

  @BeforeEach
  void setUp() {
    // Redirect System.out to capture the output
    originalSystemOut = System.out;
    outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));
  }

  @AfterEach
  void tearDown() {
    // Restore System.out
    System.setOut(originalSystemOut);
  }

  @Test
  void testDisplayWordCounts() {
    // Prepare test data
    String inputFile = "src/test/resources/sample.txt";

    // Invoke the method under test
    WordCountApp.main(new String[] {inputFile});

    // Verify the output
    String expectedOutput =
        "word: a, count: 2 word: this, count: 2 word: is, count: 2 word: contains, count: 1 word: multiple, count: 1 "
            + "word: words, count: 1 word: exercise, count: 1 word: simple, count: 1 word: text, count: 1 "
            + "word: it, count: 1 word: sample, count: 1 ";
    assertEquals(expectedOutput, outputStream.toString());
  }

  @Test
  void testFileNotFound() {
    // Prepare test data
    String inputFile = "nonexistent.txt";

    // Invoke the method under test
    WordCountException thrown =
        assertThrows(WordCountException.class, () -> WordCountApp.main(new String[] {inputFile}));

    assertEquals(
        "Error reading file: nonexistent.txt (No such file or directory)\n", thrown.getMessage());
  }

  @Test
  void testNoParameters() {
    // Invoke the method under test
    WordCountException thrown =
        assertThrows(WordCountException.class, () -> WordCountApp.main(new String[] {}));

    assertEquals("Usage: java WordCountApp <input_file_path>", thrown.getMessage());
  }
}
