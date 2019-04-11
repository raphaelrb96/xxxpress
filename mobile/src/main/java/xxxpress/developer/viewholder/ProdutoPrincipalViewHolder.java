package xxxpress.developer.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import xxxpress.developer.R;
import xxxpress.developer.produto.Produto;

public class ProdutoPrincipalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ImageView imageView;
    private TextView bottao, preco;

    private Context context;
    private ArrayList<Produto> produtos;

    public ProdutoPrincipalViewHolder(@NonNull View itemView, Context context, ArrayList<Produto> produtos) {
        super(itemView);
        this.context = context;
        this.produtos = produtos;

    }

    @Override
    public void onClick(View v) {

    }

    public void setPreco(String p) {
        preco.setText(p);
    }

    public void setImagem(String img) {
        Glide.with(context).load(img).into(imageView);
    }

    public void setTextBotao(String s) {
        bottao.setText(s);
    }

}
