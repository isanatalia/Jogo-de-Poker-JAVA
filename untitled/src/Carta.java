public class Carta {

    //Atributos:
    private String nome;
    private String naipe;

    //Construtor Default: Permite criar o objeto sem os atributo

    //Construtor:
    public Carta(String nome, String naipe){
        this.nome = nome;
        this.naipe = naipe;
    }

    //Métodos:
    public String getNome() {
        return nome;
    }

    public String getNaipe() {
        return naipe;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

}
