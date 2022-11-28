import java.util.Scanner;

public class JogoDePoker {

    public static void main(String[] args) {
        Baralho jogo = new Baralho();

        System.out.println("-------------P Ô K E R -------------");
        jogo.Embaralhar();

        System.out.println("Há quantos jogadores na mesa?");
        Scanner scanner = new Scanner(System.in);
        int quantJogadores = scanner.nextInt();

//Distribuir cartas:
        Carta[][] cartasJogador = new Carta[quantJogadores][2];
        int contadorCartas = 0;
//        jogo.ImprimeBaralho();

        System.out.println("-------------Inicializando a distribuição das cartas:-------------");
        for (int i = 0; i < quantJogadores; i++) {
            System.out.println("Cartas Jogador " + (i + 1) + " :");
            for (int j = 0; j < cartasJogador[i].length; j++) {
                cartasJogador[i][j] = new Carta(jogo.idCarta[contadorCartas].getNome(), jogo.idCarta[contadorCartas].getNaipe());
                System.out.println("Carta " + (j + 1) + ": " + cartasJogador[i][j].getNome() + " - " + cartasJogador[i][j].getNaipe());
                contadorCartas++;
            }
            System.out.println();
        }

//Abandonar a mão ou apostar?
        boolean[] permanenciaJogo = new boolean[quantJogadores];
        int[] valorAposta = new int[quantJogadores];
        String varAuxPermanencia = "nao";
        int valorAuxAposta = 0;
        int valorAcumuladoAposta = 0;
        int quantJogadoresFinal = 0;
        boolean novaRodada;
        boolean reinicializar = false;

        do {
            novaRodada = false;
            quantJogadoresFinal = 0;
            valorAuxAposta = 0;

            for (int i = 0; i < quantJogadores; i++) {

                if(!reinicializar || permanenciaJogo[i] ){
                    System.out.println("Jogador " + (i + 1) + " deseja permanecer no jogo? ");
                    varAuxPermanencia = scanner.next();
                }

                if (varAuxPermanencia.equalsIgnoreCase("Sim")) {
                    permanenciaJogo[i] = true;
                    quantJogadoresFinal++;
                    System.out.println("Qual será o valor da aposta?");
                    valorAposta[i] = scanner.nextInt();
                    valorAcumuladoAposta += valorAposta[i];

                    if (quantJogadoresFinal == 1) {
                        valorAuxAposta = valorAposta[i];
                    }

                    if (valorAuxAposta != valorAposta[i]) { //tentar fazer um else
                        novaRodada = true;
                    }
                } else {
                    permanenciaJogo[i] = false;
                }
                varAuxPermanencia = "nao"; //tentar ajeitar com exception depois

            }

            if(novaRodada){
                reinicializar = true;
            }else{
                reinicializar = false;
            }

            System.out.println("-------------Distribuição atual das cartas dos participante:-------------");
            for(int i = 0; i < quantJogadores; i++) {
                if(permanenciaJogo[i]){
                    for(int j=0; j < 2;j++) {
                        System.out.println("Carta " + (j + 1) + " : " + cartasJogador[i][j].getNome() + " - " + cartasJogador[i][j].getNaipe());
                        System.out.println();
                    }
                }
            }

        } while (reinicializar);
        System.out.println(contadorCartas);


//Exibir próximas 5 cartas e definir o vencedor:
         Carta[] cartasJogo = new Carta[5];
         System.out.println("-------------Distribuição atual das cartas do jogo:-------------");
         for (int i = 0; i < cartasJogo.length ; i++) {

            cartasJogo[i] = new Carta(jogo.idCarta[contadorCartas].getNome(), jogo.idCarta[contadorCartas].getNaipe());
            System.out.println("Carta " + (i + 1) + ": " + cartasJogo[i].getNome() + " - " + cartasJogo[i].getNaipe());
            contadorCartas++;
         }

        System.out.println("Quem é o vencedor?");
        int jogadorVencedor = scanner.nextInt();
        System.out.println();
        System.out.println("-------------P Ô K E R-------------");
        System.out.println("Parabéns jogador n° "+ jogadorVencedor+"! Você receberá o prêmio equivalente à R$"+valorAcumuladoAposta+".");
    }
}