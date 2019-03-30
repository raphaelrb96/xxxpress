package xxxpress.developer.produto;

import java.util.ArrayList;

public class ParametrosExtrasProdutos {

    public boolean existente;
    public String tituloParametro;
    public ArrayList<String> parametrosExtras;

    public ParametrosExtrasProdutos() {

    }

    public ParametrosExtrasProdutos(boolean existente, String tituloParametro, ArrayList<String> parametrosExtras) {
        this.existente = existente;
        this.tituloParametro = tituloParametro;
        this.parametrosExtras = parametrosExtras;
    }

    public boolean isExistente() {
        return existente;
    }

    public String getTituloParametro() {
        return tituloParametro;
    }

    public ArrayList<String> getParametrosExtras() {
        return parametrosExtras;
    }
}
