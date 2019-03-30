package xxxpress.developer.historicodebusca;

public class HistoricoDeBusca {

    public String textoDaBusca;
    public long quantidadeDePesquisa;
    public long datahoraDaUltimaBusca;

    public HistoricoDeBusca() {

    }

    public HistoricoDeBusca(String textoDaBusca, long quantidadeDePesquisa, long datahoraDaUltimaBusca) {
        this.textoDaBusca = textoDaBusca;
        this.quantidadeDePesquisa = quantidadeDePesquisa;
        this.datahoraDaUltimaBusca = datahoraDaUltimaBusca;
    }

    public String getTextoDaBusca() {
        return textoDaBusca;
    }

    public long getQuantidadeDePesquisa() {
        return quantidadeDePesquisa;
    }

    public long getDatahoraDaUltimaBusca() {
        return datahoraDaUltimaBusca;
    }
}
