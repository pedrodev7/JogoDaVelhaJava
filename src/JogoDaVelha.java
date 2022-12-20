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

} 
