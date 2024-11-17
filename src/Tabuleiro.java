public class Tabuleiro {
    private char[][] matriz;

    public Tabuleiro() {
        matriz = new char[3][3];
        inicializar();
    }

    public void inicializar() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = '-';
            }
        }
    }

    public void exibir() {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean fazerJogada(int linha, int coluna, char simbolo) {
        if (validarPosicao(linha, coluna)) {
            matriz[linha][coluna] = simbolo;
            return true;
        }
        return false;
    }

    public boolean validarPosicao(int linha, int coluna) {
        if (linha < 0 || linha > 2 || coluna < 0 || coluna > 2) {
            return false;
        }
        return matriz[linha][coluna] == '-';
    }

    public boolean verificarVitoria(char jogador) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((matriz[i][0] == jogador && matriz[i][1] == jogador && matriz[i][2] == jogador) ||
                    (matriz[0][i] == jogador && matriz[1][i] == jogador && matriz[2][i] == jogador)) {
                return true;
            }
        }

        // Verifica diagonais
        return (matriz[0][0] == jogador && matriz[1][1] == jogador && matriz[2][2] == jogador) ||
                (matriz[0][2] == jogador && matriz[1][1] == jogador && matriz[2][0] == jogador);
    }

    public boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }
}
