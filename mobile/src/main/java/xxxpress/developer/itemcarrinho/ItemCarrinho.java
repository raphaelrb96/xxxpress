package xxxpress.developer.itemcarrinho;

import xxxpress.developer.produto.Produto;

public class ItemCarrinho {

    public String idProduto;
    public int quantidad;
    public double somaFrete;
    public double somaProduto;
    public long datahoraInsercao;
    public Produto produto;

    public ItemCarrinho() {

    }

    public ItemCarrinho(String idProduto, int quantidad, double somaFrete, double somaProduto, long datahoraInsercao, Produto produto) {
        this.idProduto = idProduto;
        this.quantidad = quantidad;
        this.somaFrete = somaFrete;
        this.somaProduto = somaProduto;
        this.datahoraInsercao = datahoraInsercao;
        this.produto = produto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public int getQuantidad() {
        return quantidad;
    }

    public double getSomaFrete() {
        return somaFrete;
    }

    public double getSomaProduto() {
        return somaProduto;
    }

    public long getDatahoraInsercao() {
        return datahoraInsercao;
    }

    public Produto getProduto() {
        return produto;
    }
}
