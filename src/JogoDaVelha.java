import java.util.Scanner;

public class JogoDaVelha {

private Character[][] tabuleiro;
private int rodada;
private int vez;
private Scanner sc;

public JogoDaVelha() {
  tabuleiro = new Character[3][3];
  rodada = 0;
  vez = 0;
}

private void imprimirTabuleiro() {
  for (int i = 0; i < tabuleiro.length; i++) {
    for (int j = 0; j < tabuleiro.length; j++) {
      if (tabuleiro[i][j] == null) {
        System.out.print("_ ");
      } else {
        System.out.print(tabuleiro[i][j] + " ");
      }
    }
    System.out.println();
  }
}

private void definirJogada(int linha, int coluna, int vez) {
  if (vez == 0)
    tabuleiro[linha][coluna] = 'X';
  else
    tabuleiro[linha][coluna] = 'O';

  verificarVitoria(vez);
}

private void verificarJogada(int linha, int coluna) {
  if (tabuleiro[linha][coluna] == null)
    definirJogada(linha, coluna, vez);
  else
    System.out.println("Casa preenchida, tente novamente");
}

private void vezJogador(int vez) {
  if (vez % 2 == 0) {
    this.vez = 1;
  } else {
    this.vez = 0;
  }
}

private void verificarVitoria(int vez) {
  boolean vitoria = false;

  // Verificar Diagonais
  if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[2][2] != null)
    ||
    (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0]
      &&      tabuleiro[2][0] != null))
    vitoria = true;

  // Verificar Linhas
  if ((tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2] && tabuleiro[0][2] != null)
    ||
    (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2] && tabuleiro[1][2] != null)
    ||
    (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2]
      &&      tabuleiro[2][2] != null))
    vitoria = true;

  // Verificar Colunas
  if ((tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0] && tabuleiro[2][0] != null)
    ||
    (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1] && tabuleiro[2][1] != null)
    ||
    (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2]
      &&      tabuleiro[2][2] != null))
    vitoria = true;

  if (!vitoria)
    imprimirTabuleiro();

  if (rodada == 8 && vitoria == false)
    System.out.println("Empate. Deu Velha!");

  if (vitoria) {
    imprimirTabuleiro();
    System.out.println("Vitória do jogador " + (vez + 1));
    rodada = 9;
  }
  rodada++;
  vezJogador(vez);
}

public void partida() {
  int linha = 0;
  int coluna = 0;
  sc = new Scanner(System.in);

  do {
    System.out.println("Vez do Jogador " + (vez + 1));
    for (;;) {
      System.out.print("Informe a linha: ");
      linha = sc.nextInt();
      if (linha >= 0 && linha <= 2) {
        break;
      }
    }

    for (;;) {
      System.out.print("Informe a coluna: ");
      coluna = sc.nextInt();
      if (coluna >= 0 && coluna <= 2) {
        break;
      }
    }
    verificarJogada(linha, coluna);
  } while (rodada < 9);
}

}

} 
