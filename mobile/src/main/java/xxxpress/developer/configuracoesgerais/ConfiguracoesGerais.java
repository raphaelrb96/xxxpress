package xxxpress.developer.configuracoesgerais;

import java.util.ArrayList;

public class ConfiguracoesGerais {

    public int modoDeVenda;
    public String fraseModoProdutoGratis;
    public ArrayList<String> bannerPromocionais;

    public ConfiguracoesGerais() {

    }

    public ConfiguracoesGerais(int modoDeVenda, String fraseModoProdutoGratis, ArrayList<String> bannerPromocionais) {
        this.modoDeVenda = modoDeVenda;
        this.fraseModoProdutoGratis = fraseModoProdutoGratis;
        this.bannerPromocionais = bannerPromocionais;
    }

    public int getModoDeVenda() {
        return modoDeVenda;
    }

    public String getFraseModoProdutoGratis() {
        return fraseModoProdutoGratis;
    }

    public ArrayList<String> getBannerPromocionais() {
        return bannerPromocionais;
    }
}
