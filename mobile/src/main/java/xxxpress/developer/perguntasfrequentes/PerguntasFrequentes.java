package xxxpress.developer.perguntasfrequentes;

public class PerguntasFrequentes {

    public String textoPergunta;
    public String textoResposta;
    public long views;
    public String id;

    public PerguntasFrequentes(String textoPergunta, String textoResposta, long views, String id) {
        this.textoPergunta = textoPergunta;
        this.textoResposta = textoResposta;
        this.views = views;
        this.id = id;
    }

    public PerguntasFrequentes() {

    }

    public String getTextoPergunta() {
        return textoPergunta;
    }

    public String getTextoResposta() {
        return textoResposta;
    }

    public long getViews() {
        return views;
    }

    public String getId() {
        return id;
    }
}
