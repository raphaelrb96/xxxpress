package xxxpress.developer.intensoesdeprodutos;

import xxxpress.developer.produto.Produto;
import xxxpress.developer.usuario.Usuario;

public class IntensoesDeProduto {

    public long numeroDeViews;
    public Produto produto;
    public Usuario usuario;
    public long datahoraUltimaView;
    public String id;

    public IntensoesDeProduto() {

    }

    public IntensoesDeProduto(long numeroDeViews, Produto produto, Usuario usuario, long datahoraUltimaView, String id) {
        this.numeroDeViews = numeroDeViews;
        this.produto = produto;
        this.usuario = usuario;
        this.datahoraUltimaView = datahoraUltimaView;
        this.id = id;
    }

    public long getNumeroDeViews() {
        return numeroDeViews;
    }

    public Produto getProduto() {
        return produto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public long getDatahoraUltimaView() {
        return datahoraUltimaView;
    }

    public String getId() {
        return id;
    }
}
