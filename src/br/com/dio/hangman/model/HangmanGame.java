package br.com.dio.hangman.model;

import br.com.dio.hangman.enums.GameStatus;
import br.com.dio.hangman.exception.HangmanException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HangmanGame {
    private String secretWord;
    private Set<Character> guessedLetters;
    private int maxErrors;
    private int errors;
    private GameStatus status;

    public HangmanGame(String secretWord, int maxErrors) {
        this.secretWord = secretWord.toUpperCase();
        this.maxErrors = maxErrors;
        this.guessedLetters = new HashSet<>();
        this.errors = 0;
        this.status = GameStatus.PLAYING;
    }

    public void guess(char letter) throws HangmanException {
        if (status != GameStatus.PLAYING) {
            throw new HangmanException("O jogo já terminou!");
        }

        letter = Character.toUpperCase(letter);

        if (!Character.isLetter(letter)) {
            throw new HangmanException("Por favor, insira apenas letras.");
        }

        if (guessedLetters.contains(letter)) {
            throw new HangmanException("Você já tentou a letra: " + letter);
        }

        guessedLetters.add(letter);

        if (secretWord.indexOf(letter) == -1) {
            errors++;
            if (errors >= maxErrors) {
                status = GameStatus.LOST;
            }
        } else {
            if (isWordGuessed()) {
                status = GameStatus.WON;
            }
        }
    }

    private boolean isWordGuessed() {
        for (char c : secretWord.toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public String getCurrentState() {
        StringBuilder sb = new StringBuilder();
        for (char c : secretWord.toCharArray()) {
            if (guessedLetters.contains(c)) {
                sb.append(c).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString().trim();
    }

    public int getErrors() {
        return errors;
    }

    public int getMaxErrors() {
        return maxErrors;
    }

    public GameStatus getStatus() {
        return status;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }
}
