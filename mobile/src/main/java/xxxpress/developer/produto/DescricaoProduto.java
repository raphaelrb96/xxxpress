package xxxpress.developer.produto;

public class DescricaoProduto {

    public String Observacao;
    public String fraseDestaque;
    public String especificações;

    public DescricaoProduto() {

    }

    public DescricaoProduto(String observacao, String fraseDestaque, String especificações) {
        Observacao = observacao;
        this.fraseDestaque = fraseDestaque;
        this.especificações = especificações;
    }

    public String getObservacao() {
        return Observacao;
    }

    public String getFraseDestaque() {
        return fraseDestaque;
    }

    public String getEspecificações() {
        return especificações;
    }
}
