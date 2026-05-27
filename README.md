# Jogo da Forca - Desafio de POO em Java

Este projeto foi desenvolvido como parte de um desafio da **DIO (Digital Innovation One)** com o objetivo de aplicar conceitos fundamentais de **Programação Orientada a Objetos (POO)** na linguagem Java.

## 📝 Descrição do Projeto

O projeto consiste em uma aplicação console que implementa o clássico Jogo da Forca. O jogo seleciona aleatoriamente uma palavra de um banco de dados pré-definido e desafia o usuário a adivinhá-la letra por letra antes que o número máximo de erros seja atingido.

## 🚀 Tecnologias e Conceitos Utilizados

Neste projeto, foram aplicados os seguintes conceitos:

- **Classes e Objetos**: Estruturação do jogo em classes com responsabilidades bem definidas.
- **Encapsulamento**: Uso de modificadores de acesso (private) e métodos getters para proteger o estado interno dos objetos.
- **Enums**: Utilização de `GameStatus` para representar os possíveis estados do jogo (JOGANDO, VENCEU, PERDEU).
- **Exceções Personalizadas**: Criação da classe `HangmanException` para tratar entradas inválidas ou estados inesperados.
- **Listas e Coleções**: Uso de `Set` para gerenciar letras já tentadas e arrays para o banco de palavras.
- **Manipulação de Strings**: Formatação e comparação de caracteres e strings.
- **Lógica de Programação**: Controle de fluxo, loops e condicionais para gerenciar o estado do jogo.

## 🎮 Como Funciona

1. O jogo escolhe uma palavra secreta aleatória.
2. O jogador visualiza a representação visual da forca e os espaços vazios da palavra.
3. O jogador digita uma letra:
   - Se a letra estiver na palavra, ela é revelada.
   - Se a letra não estiver, o número de erros aumenta e a forca é desenhada.
4. O jogo termina quando:
   - O jogador descobre todas as letras (Vitória).
   - O jogador comete 6 erros (Derrota).

## 🛠️ Como Executar

Para executar o projeto, você precisará ter o Java JDK instalado em sua máquina (versão 15 ou superior, devido ao uso de Text Blocks).

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd Criando-um-Jogo-da-Forca-com-uma-Aplica-o-Console-Java
   ```

3. Compile os arquivos fonte:
   ```bash
   javac -d bin src/br/com/dio/hangman/enums/GameStatus.java src/br/com/dio/hangman/exception/HangmanException.java src/br/com/dio/hangman/model/HangmanGame.java src/br/com/dio/hangman/Main.java
   ```

4. Execute o jogo:
   ```bash
   java -cp bin br.com.dio.hangman.Main
   ```

## 📂 Estrutura do Projeto

```
src/
└── br/com/dio/hangman/
    ├── Main.java (Classe principal)
    ├── enums/
    │   └── GameStatus.java
    ├── exception/
    │   └── HangmanException.java
    └── model/
        └── HangmanGame.java (Lógica do jogo)
```

## 🎓 Experiência de Aprendizado

A construção deste desafio permitiu consolidar a prática de separação de responsabilidades. A lógica do jogo foi isolada na classe `HangmanGame`, enquanto a interação com o usuário ficou concentrada na classe `Main`. O uso de exceções personalizadas ajudou a tornar o código mais robusto e fácil de ler, tratando especificamente erros como letras repetidas ou caracteres não permitidos.
