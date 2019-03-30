package xxxpress.developer.mensagem;

import xxxpress.developer.usuario.Usuario;

public class Mensagem {

    public String textoMensagem;
    public long datahoraDeEnvio;
    public String idMensagem;
    public Usuario usuario;


    public Mensagem() {

    }

    public Mensagem(String textoMensagem, long datahoraDeEnvio, String idMensagem, Usuario usuario) {
        this.textoMensagem = textoMensagem;
        this.datahoraDeEnvio = datahoraDeEnvio;
        this.idMensagem = idMensagem;
        this.usuario = usuario;
    }

    public String getTextoMensagem() {
        return textoMensagem;
    }

    public long getDatahoraDeEnvio() {
        return datahoraDeEnvio;
    }

    public String getIdMensagem() {
        return idMensagem;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
