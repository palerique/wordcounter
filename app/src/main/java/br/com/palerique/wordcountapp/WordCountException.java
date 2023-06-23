package br.com.palerique.wordcountapp;

import java.io.IOException;

public class WordCountException extends RuntimeException {
  public WordCountException(String message) {
    super(message);
  }

  public WordCountException(IOException cause, String message, Object... params) {
    super(String.format(message, params), cause);
  }
}
