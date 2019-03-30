package xxxpress.developer.venda;

import xxxpress.developer.carrinhodecompras.CarrinhoDeCompras;
import xxxpress.developer.endereco.Endereco;

public class Venda {

    public String idVenda;
    public long datahoraVenda;
    public Endereco enderecoDeEntrega;
    public int formaDePagamento;
    public String descricaoDePagamento;
    public int statusDaVenda;
    public CarrinhoDeCompras carrinho;

    public Venda() {

    }

    public Venda(String idVenda, long datahoraVenda, Endereco enderecoDeEntrega, int formaDePagamento, String descricaoDePagamento, int statusDaVenda, CarrinhoDeCompras carrinho) {
        this.idVenda = idVenda;
        this.datahoraVenda = datahoraVenda;
        this.enderecoDeEntrega = enderecoDeEntrega;
        this.formaDePagamento = formaDePagamento;
        this.descricaoDePagamento = descricaoDePagamento;
        this.statusDaVenda = statusDaVenda;
        this.carrinho = carrinho;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public long getDatahoraVenda() {
        return datahoraVenda;
    }

    public Endereco getEnderecoDeEntrega() {
        return enderecoDeEntrega;
    }

    public int getFormaDePagamento() {
        return formaDePagamento;
    }

    public String getDescricaoDePagamento() {
        return descricaoDePagamento;
    }

    public int getStatusDaVenda() {
        return statusDaVenda;
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }
}
