package xxxpress.developer.adm.objetos;

import android.os.Parcel;
import android.os.Parcelable;

import xxxpress.developer.produto.Produto;

public class ProdutoAdminParcelable extends ProdutoAdmin implements Parcelable {

    public ProdutoAdminParcelable() {

    }

    public ProdutoAdminParcelable(Produto produto, double valorDeCompra) {
        super(produto, valorDeCompra);
    }

    protected ProdutoAdminParcelable(Parcel in) {

    }

    public static final Creator<ProdutoAdminParcelable> CREATOR = new Creator<ProdutoAdminParcelable>() {
        @Override
        public ProdutoAdminParcelable createFromParcel(Parcel in) {
            return new ProdutoAdminParcelable(in);
        }

        @Override
        public ProdutoAdminParcelable[] newArray(int size) {
            return new ProdutoAdminParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
