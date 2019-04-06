package xxxpress.developer.produto;

import java.util.ArrayList;

public class DescricaoProduto {

    public String observacao;
    public String fraseDestaque;
    public ArrayList<String> especificações;

    public DescricaoProduto() {

    }

    public DescricaoProduto(String observacao, String fraseDestaque, ArrayList<String> especificações) {
        this.observacao = observacao;
        this.fraseDestaque = fraseDestaque;
        this.especificações = especificações;
    }

    public String getObservacao() {
        return observacao;
    }

    public String getFraseDestaque() {
        return fraseDestaque;
    }

    public ArrayList<String> getEspecificações() {
        return especificações;
    }
}
