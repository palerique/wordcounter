package br.com.palerique.wordcountapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCountApp {
  public static void main(String[] args) {
    // 2. The input file path should be provided as a command-line argument.
    // 7. Provide appropriate error handling for file reading and any other potential exceptions.
    if (args.length < 1) {
      throw new WordCountException("Usage: java WordCountApp <input_file_path>");
    }

    String inputFile = args[0];

    try {
      Map<String, Integer> wordCounts = countWords(inputFile);
      displayWordCounts(wordCounts);
    } catch (IOException e) {
      // 7. Provide appropriate error handling for file reading and any other potential exceptions.
      throw new WordCountException(e, "Error reading file: %s%n", e.getMessage());
    }
  }

  private static Map<String, Integer> countWords(String inputFile) throws IOException {
    Map<String, Integer> wordCounts = new HashMap<>();

    // 3. The program should handle large files efficiently.
    // We read the file line by line to avoid out of memory issues.
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split("\\s+");
        for (String word : words) {
          // 4. The program should ignore punctuation marks and consider words in a
          //   case-insensitive manner.
          word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
          if (!word.isEmpty()) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
          }
        }
      }
    }

    return wordCounts;
  }

  private static void displayWordCounts(Map<String, Integer> wordCounts) {
    wordCounts.entrySet().stream()
        // 5. The output should display each word along with its count
        // in descending order based on the count.
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(
            entry -> System.out.printf("word: %s, count: %d ", entry.getKey(), entry.getValue()));
  }
}
