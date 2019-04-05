package xxxpress.developer.adm.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import xxxpress.developer.R;
import xxxpress.developer.adm.ProdutoAdmin;

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.ItemInventario> {

    private ArrayList<ProdutoAdmin> produtos;
    private Context context;
    private InventarioClickListener inventarioClickListener;

    public InventarioAdapter(ArrayList<ProdutoAdmin> produtos, Context context, InventarioClickListener inventarioClickListener) {
        this.produtos = produtos;
        this.context = context;
        this.inventarioClickListener = inventarioClickListener;
    }

    public interface InventarioClickListener {
        void inventarioItemClick(ProdutoAdmin produto);
    }

    @Override
    public ItemInventario onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_inventario, parent, false);

        return new ItemInventario(view);
    }

    @Override
    public void onBindViewHolder(ItemInventario holder, int position) {
        ProdutoAdmin prod = produtos.get(position);
        holder.tvNomeProduto.setText(prod.getProduto().getNomeProduto());
        holder.tvPreco.setText(Double.toString(prod.produto.getPrecoNovo()));
        Glide.with(context).load(prod.getProduto().getFotosDoProduto().get(0));
    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    class ItemInventario extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imgProduto;
        public TextView tvNomeProduto;
        public TextView tvPreco;
        public View iconeEditar;

        public ItemInventario(View itemView) {
            super(itemView);
            imgProduto = (ImageView) itemView.findViewById(R.id.img_produto_inventario_list);
            tvNomeProduto = (TextView) itemView.findViewById(R.id.tv_nome_produto_inventario_list);
            tvPreco = (TextView) itemView.findViewById(R.id.preco_produto_inventario_list);
            iconeEditar = (View) itemView.findViewById(R.id.icone_edit_produto_inventario_list);
            iconeEditar.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
