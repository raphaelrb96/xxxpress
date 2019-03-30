package xxxpress.developer.produto;

import java.util.ArrayList;

import xxxpress.developer.intensoesdeprodutos.IntensoesDeProduto;
import xxxpress.developer.mensagem.Mensagem;

public class ProdutoDetalhe {

    public Produto produto;
    public ArrayList<IntensoesDeProduto> intensoesDeProdutos;
    public ArrayList<Mensagem> mensagens;


    public ProdutoDetalhe() {
    }

    public ProdutoDetalhe(Produto produto, ArrayList<IntensoesDeProduto> intensoesDeProdutos, ArrayList<Mensagem> mensagens) {
        this.produto = produto;
        this.intensoesDeProdutos = intensoesDeProdutos;
        this.mensagens = mensagens;
    }

    public Produto getProduto() {
        return produto;
    }

    public ArrayList<IntensoesDeProduto> getIntensoesDeProdutos() {
        return intensoesDeProdutos;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }
}
