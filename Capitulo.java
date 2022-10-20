import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Capitulo {
    private String titulo;
    private String texto;
    protected ArrayList<Escolha> escolhas;
    private Personagem perso;
    private int alterarEnergia;

    protected Capitulo() {
    }

    public Capitulo(String nome,
            String texto,
            Personagem perso,
            int alterarEnergia) {

        this.titulo = nome;
        this.texto = texto;
        this.perso = perso;
        this.alterarEnergia = alterarEnergia;
        this.escolhas = new ArrayList<Escolha>();
    }

    public Capitulo(HashMap<String, Personagem> personagens, Scanner escaneadorArquivoCapitulos) {
        this.ler(personagens, escaneadorArquivoCapitulos);
        this.escolhas = new ArrayList<Escolha>();
    }

    protected void ler(HashMap<String, Personagem> personagens, Scanner escaneadorArquivoCapitulos) {
        escaneadorArquivoCapitulos.nextLine(); // TITULO
        this.titulo = escaneadorArquivoCapitulos.nextLine();

        escaneadorArquivoCapitulos.nextLine(); // TEXTO
        this.texto = escaneadorArquivoCapitulos.nextLine();

        escaneadorArquivoCapitulos.nextLine(); // PERSONAGEM
        this.perso = personagens.get(escaneadorArquivoCapitulos.nextLine());

        escaneadorArquivoCapitulos.nextLine(); // VARIAÇÃO DE ENERGIA
        this.alterarEnergia = Integer.parseInt(escaneadorArquivoCapitulos.nextLine());
    }

    public void adicionarEscolha(Escolha escolha) {
        this.escolhas.add(escolha);
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getTexto() {
        return this.texto;
    }

    public String alterarEnergiaPersonagem() {
        return this.perso.alterarEnergia(this.alterarEnergia);
    }

    public ArrayList<Escolha> getEscolhas() {
        return this.escolhas;
    }
}