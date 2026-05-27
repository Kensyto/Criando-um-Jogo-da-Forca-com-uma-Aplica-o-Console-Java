package br.com.dio.hangman;

import br.com.dio.hangman.enums.GameStatus;
import br.com.dio.hangman.exception.HangmanException;
import br.com.dio.hangman.model.HangmanGame;

import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final String[] WORDS = {"JAVA", "PYTHON", "PROGRAMACAO", "OBJETO", "CLASSE", "METODO", "ENCAPSULAMENTO", "HERANCA", "POLIMORFISMO", "INTERFACE"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String secretWord = WORDS[random.nextInt(WORDS.length)];
        HangmanGame game = new HangmanGame(secretWord, 6);

        System.out.println("=== BEM-VINDO AO JOGO DA FORCA ===");

        while (game.getStatus() == GameStatus.PLAYING) {
            printHangman(game.getErrors());
            System.out.println("\nPalavra: " + game.getCurrentState());
            System.out.println("Erros: " + game.getErrors() + " / " + game.getMaxErrors());
            System.out.println("Letras tentadas: " + game.getGuessedLetters());
            System.out.print("Digite uma letra: ");

            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Erro: Digite apenas uma letra.");
                continue;
            }

            try {
                game.guess(input.charAt(0));
            } catch (HangmanException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        printHangman(game.getErrors());
        if (game.getStatus() == GameStatus.WON) {
            System.out.println("\nParabéns! Você venceu! A palavra era: " + game.getSecretWord());
        } else {
            System.out.println("\nQue pena! Você perdeu. A palavra era: " + game.getSecretWord());
        }

        scanner.close();
    }

    private static void printHangman(int errors) {
        String[] stages = {
            """
              +---+
              |   |
                  |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
                  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
              |   |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|   |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
                  |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
             /    |
                  |
            =========
            """,
            """
              +---+
              |   |
              O   |
             /|\\  |
             / \\  |
                  |
            =========
            """
        };

        if (errors >= 0 && errors < stages.length) {
            System.out.println(stages[errors]);
        }
    }
}
