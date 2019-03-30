package xxxpress.developer.produto;

import java.util.ArrayList;

public class Produto {

    public String idProduto;
    public String nomeProduto;
    public double valorFrete;
    public double precoAntigo;
    public double precoNovo;
    public ArrayList<String> tagsPesquisa;
    public ArrayList<ParametrosExtrasProdutos> variantes1;
    public ArrayList<ParametrosExtrasProdutos> variantes2;
    public ArrayList<String> cores;
    public ArrayList<String> tamanhos;
    public DescricaoProduto descricao;
    public int categoria;
    public int tempoDeEntregaEmDias;
    public int quantidadeEstoque;
    public ArrayList<String> fotosDoProduto;
    public String idReferenciaForumComentarios;
    public String pathVideoPrincipal;
    public boolean promoFree;

    public Produto() {

    }

    public Produto(String idProduto, String nomeProduto, double valorFrete, double precoAntigo, double precoNovo, ArrayList<String> tagsPesquisa, ArrayList<ParametrosExtrasProdutos> variantes1, ArrayList<ParametrosExtrasProdutos> variantes2, ArrayList<String> cores, ArrayList<String> tamanhos, DescricaoProduto descricao, int categoria, int tempoDeEntregaEmDias, int quantidadeEstoque, ArrayList<String> fotosDoProduto, String idReferenciaForumComentarios, String pathVideoPrincipal, boolean promoFree) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.valorFrete = valorFrete;
        this.precoAntigo = precoAntigo;
        this.precoNovo = precoNovo;
        this.tagsPesquisa = tagsPesquisa;
        this.variantes1 = variantes1;
        this.variantes2 = variantes2;
        this.cores = cores;
        this.tamanhos = tamanhos;
        this.descricao = descricao;
        this.categoria = categoria;
        this.tempoDeEntregaEmDias = tempoDeEntregaEmDias;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fotosDoProduto = fotosDoProduto;
        this.idReferenciaForumComentarios = idReferenciaForumComentarios;
        this.pathVideoPrincipal = pathVideoPrincipal;
        this.promoFree = promoFree;
    }

    public boolean isPromoFree() {
        return promoFree;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    public double getPrecoAntigo() {
        return precoAntigo;
    }

    public double getPrecoNovo() {
        return precoNovo;
    }

    public ArrayList<String> getTagsPesquisa() {
        return tagsPesquisa;
    }

    public ArrayList<ParametrosExtrasProdutos> getVariantes1() {
        return variantes1;
    }

    public ArrayList<ParametrosExtrasProdutos> getVariantes2() {
        return variantes2;
    }

    public ArrayList<String> getCores() {
        return cores;
    }

    public ArrayList<String> getTamanhos() {
        return tamanhos;
    }

    public DescricaoProduto getDescricao() {
        return descricao;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getTempoDeEntregaEmDias() {
        return tempoDeEntregaEmDias;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public ArrayList<String> getFotosDoProduto() {
        return fotosDoProduto;
    }

    public String getIdReferenciaForumComentarios() {
        return idReferenciaForumComentarios;
    }

    public String getPathVideoPrincipal() {
        return pathVideoPrincipal;
    }
}
