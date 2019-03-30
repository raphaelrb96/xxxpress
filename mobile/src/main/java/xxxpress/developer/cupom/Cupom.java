package xxxpress.developer.cupom;

public class Cupom {

    public String idCupom;
    public boolean ativo;
    public long numDeVezesUsada;
    public long datahoraCriacao;
    public long datahoraUltimoUso;
    public int tipo;
    public double valorDesconto;
    public int porcentagemDesconto;

    public Cupom() {

    }

    public Cupom(String idCupom, boolean ativo, long numDeVezesUsada, long datahoraCriacao, long datahoraUltimoUso, int tipo, double valorDesconto, int porcentagemDesconto) {
        this.idCupom = idCupom;
        this.ativo = ativo;
        this.numDeVezesUsada = numDeVezesUsada;
        this.datahoraCriacao = datahoraCriacao;
        this.datahoraUltimoUso = datahoraUltimoUso;
        this.tipo = tipo;
        this.valorDesconto = valorDesconto;
        this.porcentagemDesconto = porcentagemDesconto;
    }

    public String getIdCupom() {
        return idCupom;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public long getNumDeVezesUsada() {
        return numDeVezesUsada;
    }

    public long getDatahoraCriacao() {
        return datahoraCriacao;
    }

    public long getDatahoraUltimoUso() {
        return datahoraUltimoUso;
    }

    public int getTipo() {
        return tipo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public int getPorcentagemDesconto() {
        return porcentagemDesconto;
    }
}
