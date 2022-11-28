public class Baralho {
    //Atributos
    public Carta idCarta[] = new Carta[52];;

    //Construtor:
    public Baralho() {
        String[] nomeCarta = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] naipeCarta = {"espadas", "paus", "copas", "ouro"};
        int contadorNome = 0;
        int contadorNaipe = 0;
        //this.idCarta = new Carta[52];

        for (int i = 0; i < 52; i++) {
            idCarta[i] = new Carta(nomeCarta[contadorNome], naipeCarta[contadorNaipe]);
            //System.out.println(idCarta[i].getNome() + " " + idCarta[i].getNaipe()); // comentar depois que verificar

            if (contadorNome == (nomeCarta.length - 1)) {
                contadorNome = 0;
                contadorNaipe = (contadorNaipe == 3) ? 0 : contadorNaipe + 1;
            } else {
                contadorNome++;
            }

        }
    }

    public void Embaralhar(){
        int quantVezesEmbaralhar = (int) (52 - Math.floor(Math.random()*51));

        for (int i = 1; i < quantVezesEmbaralhar; i++ ) {
            int posicaoUm = (int) (Math.floor(Math.random() * 51));
            int posicaoDois = (int) (Math.floor(Math.random() * 51));
            String nomeCartaTemp = idCarta[posicaoUm].getNome();
            String naipeCartaTemp = idCarta[posicaoUm].getNaipe();
            this.idCarta[posicaoUm].setNome(idCarta[posicaoDois].getNome());
            this.idCarta[posicaoUm].setNaipe(idCarta[posicaoDois].getNaipe());
            this.idCarta[posicaoDois].setNome(nomeCartaTemp);
            this.idCarta[posicaoDois].setNaipe(naipeCartaTemp);
        }
    }

    public void ImprimeBaralho() {
        int contadorCarta = 0;
        int contadorNaipe = 0;
        for (int i = 0; i < 52; i++){
            System.out.println((i+1) +"- "+ idCarta[i].getNome() + " " + idCarta[i].getNaipe()); // comentar depois que verificar
        }
    }

//    public void TemCarta(){
//        Baralho();
//    }

    public void setIdCarta(Carta[] idCarta) {
        this.idCarta = idCarta;
    }

    public Carta[] getIdCarta() {
        return idCarta;
    }
}

