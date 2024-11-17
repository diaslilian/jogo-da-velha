import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorAtual;
    private boolean jogoAtivo;
    private Scanner scanner;

    public Jogo() {
        tabuleiro = new Tabuleiro();
        scanner = new Scanner(System.in);
        jogoAtivo = true;
    }

    public void exibirBoasVindas() {
        System.out.println("************************************************");
        System.out.println("*           Bem-vindo ao Jogo da Velha!        *");
        System.out.println("************************************************");
        System.out.println("\nPrepare-se para uma disputa emocionante!\n");
    }

    public void registrarJogadores() {
        System.out.println("Por favor, registre os jogadores:");

        System.out.print("\nNome do Jogador 1 (X): ");
        String nomeJogador1 = scanner.nextLine().trim();
        while (nomeJogador1.isEmpty()) {
            System.out.print("O nome não pode estar vazio. Por favor, digite novamente: ");
            nomeJogador1 = scanner.nextLine().trim();
        }
        jogador1 = new Jogador(nomeJogador1, 'X');

        System.out.print("Nome do Jogador 2 (O): ");
        String nomeJogador2 = scanner.nextLine().trim();
        while (nomeJogador2.isEmpty() || nomeJogador2.equals(nomeJogador1)) {
            if (nomeJogador2.isEmpty()) {
                System.out.print("O nome não pode estar vazio. Por favor, digite novamente: ");
            } else {
                System.out.print("Os jogadores não podem ter o mesmo nome. Por favor, escolha outro nome: ");
            }
            nomeJogador2 = scanner.nextLine().trim();
        }
        jogador2 = new Jogador(nomeJogador2, 'O');

        System.out.println("\nÓtimo! Vamos começar o jogo!");
        System.out.printf("%s (X) VS %s (O)\n", jogador1.getNome(), jogador2.getNome());
        System.out.println("\nPressione ENTER para iniciar...");
        scanner.nextLine();
    }

    public void iniciar() {
        exibirBoasVindas();
        registrarJogadores();
        jogadorAtual = jogador1; // Começa com o jogador 1

        do {
            jogoAtivo = true;
            tabuleiro.inicializar();

            while (jogoAtivo) {
                tabuleiro.exibir();
                processarJogada();

                if (tabuleiro.verificarVitoria(jogadorAtual.getSimbolo())) {
                    tabuleiro.exibir();
                    System.out.printf("Parabéns, %s! Você venceu!\n", jogadorAtual.getNome());
                    jogoAtivo = false;
                } else if (tabuleiro.verificarEmpate()) {
                    tabuleiro.exibir();
                    System.out.println("Empate! Bom jogo a ambos os jogadores!");
                    jogoAtivo = false;
                } else {
                    trocarJogador();
                }
            }
        } while (jogarNovamente());

        exibirMensagemFinal();
    }

    private void processarJogada() {
        boolean jogadaValida = false;

        while (!jogadaValida) {
            try {
                System.out.printf("\nVez de %s (%c)\n",
                        jogadorAtual.getNome(),
                        jogadorAtual.getSimbolo());
                System.out.print("Digite a linha (0-2): ");
                int linha = scanner.nextInt();
                System.out.print("Digite a coluna (0-2): ");
                int coluna = scanner.nextInt();

                if (tabuleiro.fazerJogada(linha, coluna, jogadorAtual.getSimbolo())) {
                    jogadaValida = true;
                } else {
                    System.out.println("\nJogada inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("\nEntrada inválida! Use números de 0 a 2.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
    }

    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    private boolean jogarNovamente() {
        System.out.print("\nDesejam jogar novamente? (S/N): ");
        String resposta = scanner.next().toUpperCase();
        scanner.nextLine(); // Limpa o buffer
        return resposta.equals("S");
    }

    private void exibirMensagemFinal() {
        System.out.println("\n************************************************");
        System.out.println("*             Fim do Jogo!                      *");
        System.out.println("*      Obrigado por jogarem! Até a próxima!    *");
        System.out.println("************************************************");
        scanner.close();
    }
}