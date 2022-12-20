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

} 
