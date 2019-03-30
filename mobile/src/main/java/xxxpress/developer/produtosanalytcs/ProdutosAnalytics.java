package xxxpress.developer.produtosanalytcs;

import xxxpress.developer.produto.Produto;

public class ProdutosAnalytics {

    public long views;
    public long numeroDeVendas;
    public long totalEmVendas;
    public Produto produto;
    public String idProduto;
    public long datahoraDaUltimaVenda;
    public long datahoraDaUltimaView;
    public long datahoraDaUltimaVezQueEntrouNumCarrinho;
    public long numeroDeVezesQueEntrouNumCarrinho;
    public double lucroTotalDesseProduto;

    public ProdutosAnalytics() {

    }

    public ProdutosAnalytics(long views, long numeroDeVendas, long totalEmVendas, Produto produto, String idProduto, long datahoraDaUltimaVenda, long datahoraDaUltimaView, long datahoraDaUltimaVezQueEntrouNumCarrinho, long numeroDeVezesQueEntrouNumCarrinho, double lucroTotalDesseProduto) {
        this.views = views;
        this.numeroDeVendas = numeroDeVendas;
        this.totalEmVendas = totalEmVendas;
        this.produto = produto;
        this.idProduto = idProduto;
        this.datahoraDaUltimaVenda = datahoraDaUltimaVenda;
        this.datahoraDaUltimaView = datahoraDaUltimaView;
        this.datahoraDaUltimaVezQueEntrouNumCarrinho = datahoraDaUltimaVezQueEntrouNumCarrinho;
        this.numeroDeVezesQueEntrouNumCarrinho = numeroDeVezesQueEntrouNumCarrinho;
        this.lucroTotalDesseProduto = lucroTotalDesseProduto;
    }

    public long getViews() {
        return views;
    }

    public long getNumeroDeVendas() {
        return numeroDeVendas;
    }

    public long getTotalEmVendas() {
        return totalEmVendas;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public long getDatahoraDaUltimaVenda() {
        return datahoraDaUltimaVenda;
    }

    public long getDatahoraDaUltimaView() {
        return datahoraDaUltimaView;
    }

    public long getDatahoraDaUltimaVezQueEntrouNumCarrinho() {
        return datahoraDaUltimaVezQueEntrouNumCarrinho;
    }

    public long getNumeroDeVezesQueEntrouNumCarrinho() {
        return numeroDeVezesQueEntrouNumCarrinho;
    }

    public double getLucroTotalDesseProduto() {
        return lucroTotalDesseProduto;
    }
}
