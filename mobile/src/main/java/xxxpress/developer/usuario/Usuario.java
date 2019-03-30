package xxxpress.developer.usuario;

import xxxpress.developer.endereco.Endereco;

public class Usuario {

    public String nome;
    public String email;
    public String celular;
    public String id;
    public String idEnderecoPrincipal;
    public double valorTotalEmCompras;
    public Endereco endereco;
    public long DataCadastro;
    public long numeroDeCompras;
    public String pathPhoto;

    public Usuario() {

    }

    public Usuario(String nome, String email, String celular, String id, String idEnderecoPrincipal, double valorTotalEmCompras, Endereco endereco, long dataCadastro, long numeroDeCompras, String pathPhoto) {
        this.nome = nome;
        this.email = email;
        this.celular = celular;
        this.id = id;
        this.idEnderecoPrincipal = idEnderecoPrincipal;
        this.valorTotalEmCompras = valorTotalEmCompras;
        this.endereco = endereco;
        DataCadastro = dataCadastro;
        this.numeroDeCompras = numeroDeCompras;
        this.pathPhoto = pathPhoto;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCelular() {
        return celular;
    }

    public String getId() {
        return id;
    }

    public String getIdEnderecoPrincipal() {
        return idEnderecoPrincipal;
    }

    public double getValorTotalEmCompras() {
        return valorTotalEmCompras;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public long getDataCadastro() {
        return DataCadastro;
    }

    public long getNumeroDeCompras() {
        return numeroDeCompras;
    }

    public String getPathPhoto() {
        return pathPhoto;
    }
}
