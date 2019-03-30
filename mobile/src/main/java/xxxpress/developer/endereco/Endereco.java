package xxxpress.developer.endereco;

public class Endereco {

    public String id;
    public boolean isMain;
    public String codigoPostalCEP;
    public String pais;
    public String estado;
    public String cidade;
    public String bairro;
    public String rua;
    public String numeroDaCasa;
    public String idUsuario;
    public String complemento;
    public double latitude;
    public double longitude;
    public String placeID;

    public Endereco() {

    }

    public Endereco(String id, boolean isMain, String codigoPostalCEP, String pais, String estado, String cidade, String bairro, String rua, String numeroDaCasa, String idUsuario, String complemento, double latitude, double longitude, String placeID) {
        this.id = id;
        this.isMain = isMain;
        this.codigoPostalCEP = codigoPostalCEP;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numeroDaCasa = numeroDaCasa;
        this.idUsuario = idUsuario;
        this.complemento = complemento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placeID = placeID;
    }

    public String getId() {
        return id;
    }

    public boolean isMain() {
        return isMain;
    }

    public String getCodigoPostalCEP() {
        return codigoPostalCEP;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getComplemento() {
        return complemento;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPlaceID() {
        return placeID;
    }
}
