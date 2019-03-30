package xxxpress.developer.adm;

import xxxpress.developer.produto.Produto;

public class ProdutoAdmin {

    public Produto produto;
    public double valorDeCompra;

    public ProdutoAdmin() {

    }

    public ProdutoAdmin(Produto produto, double valorDeCompra) {
        this.produto = produto;
        this.valorDeCompra = valorDeCompra;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public Produto getProduto() {
        return produto;
    }
}
