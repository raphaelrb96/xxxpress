package xxxpress.developer.carrinhodecompras;

import java.util.ArrayList;

import xxxpress.developer.cupom.Cupom;
import xxxpress.developer.itemcarrinho.ItemCarrinho;
import xxxpress.developer.usuario.Usuario;

public class CarrinhoDeCompras {

    public Usuario usuario;
    public long datahoraDaUltimaView;
    public long datahoraDaUltimaEdicao;
    public ArrayList<ItemCarrinho> itens;
    public double total;
    public double somaDoFrete;
    public double somaProdutos;
    public long numeroDeViews;
    public long datahoraDaPrimeiraInsercao;
    public Cupom cupom;

    public CarrinhoDeCompras() {

    }

    public CarrinhoDeCompras(Usuario usuario, long datahoraDaUltimaView, long datahoraDaUltimaEdicao, ArrayList<ItemCarrinho> itens, double total, double somaDoFrete, double somaProdutos, long numeroDeViews, long datahoraDaPrimeiraInsercao, Cupom cupom) {
        this.usuario = usuario;
        this.datahoraDaUltimaView = datahoraDaUltimaView;
        this.datahoraDaUltimaEdicao = datahoraDaUltimaEdicao;
        this.itens = itens;
        this.total = total;
        this.somaDoFrete = somaDoFrete;
        this.somaProdutos = somaProdutos;
        this.numeroDeViews = numeroDeViews;
        this.datahoraDaPrimeiraInsercao = datahoraDaPrimeiraInsercao;
        this.cupom = cupom;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public long getDatahoraDaUltimaView() {
        return datahoraDaUltimaView;
    }

    public long getDatahoraDaUltimaEdicao() {
        return datahoraDaUltimaEdicao;
    }

    public ArrayList<ItemCarrinho> getItens() {
        return itens;
    }

    public double getTotal() {
        return total;
    }

    public double getSomaDoFrete() {
        return somaDoFrete;
    }

    public double getSomaProdutos() {
        return somaProdutos;
    }

    public long getNumeroDeViews() {
        return numeroDeViews;
    }

    public long getDatahoraDaPrimeiraInsercao() {
        return datahoraDaPrimeiraInsercao;
    }

    public Cupom getCupom() {
        return cupom;
    }
}
