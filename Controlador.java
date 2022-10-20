import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;

public class Controlador {
    HashMap<String, Personagem> personagens;
    HashMap<String, Capitulo> capitulos;

    @FXML
    private Button botaoCarregar;

    @FXML
    private HBox espacoBotoes;

    @FXML
    private Label imagemCapitulo;

    @FXML
    private TextArea textoCapitulo;

    @FXML
    void carregar(ActionEvent event) {
        LeitorCarregador leitor = new LeitorCarregador();
        personagens = leitor.lerPersonagens("Texto/Personagens.txt");
        capitulos = leitor.lerCapitulos("Texto/Capitulos.txt", personagens);

        Capitulo raiz = capitulos.get("Capítulo 1");
        mostrarCapitulo(raiz);
    }

    void mostrarCapitulo(CapituloImagem capituloImagem) {
        Capitulo capitulo = capituloImagem;
        mostrarCapitulo(capitulo);
    }

    void mostrarCapitulo(Capitulo capitulo) {
        imagemCapitulo.setText("");
        try {
            CapituloImagem capituloImagem = (CapituloImagem) capitulo;
            imagemCapitulo.setText(capituloImagem.getImagem());
        }

        catch (Exception e) {
            System.out.println(e);

        }

        textoCapitulo.clear();
        espacoBotoes.getChildren().clear();
        textoCapitulo.setText(
                capitulo.getTitulo() + "\n" + capitulo.getTexto() + "\n" + capitulo.alterarEnergiaPersonagem());

        if (capitulo.getEscolhas().size() > 0) {
            for (Escolha escolha : capitulo.getEscolhas()) {
                Button botao = new Button(escolha.getTexto());
                botao.setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        mostrarCapitulo(escolha.getProximo());
                    }
                });

                espacoBotoes.getChildren().add(botao);
            }
        }
    }
}