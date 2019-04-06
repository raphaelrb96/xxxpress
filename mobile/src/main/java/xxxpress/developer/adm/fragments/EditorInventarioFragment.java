package xxxpress.developer.adm.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import xxxpress.developer.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class EditorInventarioFragment extends Fragment implements View.OnTouchListener, View.OnClickListener {

    public static final int PICK_IMAGEM = 1234;

    private LinearLayout ll_bt_add_fotos_editor_inventario, box_add_cor_editor_invntario, box_add_tamanho_editor_inventario,
            box_add_extra1_editor_inventario, box_extra2_add_variante_editor_inventario;

    private ImageView img1_produto_inventario_editor, img2_produto_inventario_editor, img3_produto_inventario_editor, img4_produto_inventario_editor, img5_produto_inventario_editor;

    private CardView bt_salvar_editor_inventario;

    private FloatingActionButton fab_delete_edior_invenario;

    private EditText nome_editor_inventario, frete_editor_inventario,
            preco_original_editor_inventario, preco_antigo_editor_inevntario,
            preco_novo_editor_inventario, et_cor_add_editor_inventario,
            et_tamanho_add_editor_inventario, et_nome_extra1_editor_inventario,
            et_add_extra1_variante_editor_inventario, et_extra2_nome_editor_inventario,
            et_extra2_add_variante_editor_inventario, et_descricao_frase_destaque,
            et_descricao_add_especificacos, et_descricao_observacoes,
            et_add_tags_edior_inventario, et_tempo_entrega_editor_inventario, et_quantidade_editor_inventario;

    private CheckBox cb_cor_editor_inventario, cb_tamanho_editor_inventario, cb_extra1_editor_inventario,
            cb_extra2_editor_inventario;

    private View bt_add_cor_editor_inventario, bt_add_tamanho_editor_inventario, bt_add_nome_extra1_edior_inventario,
            bt_add_variante_extra1_editor_inventario, bt_add_nome_extra2_editor_inventario,
            bt_extra2_add_variante_editor_inventario, bt_descricao_frase_destaqueet_descricao_add_especificacoes,
            bt_add_tags_edior_inventario;

    private Spinner spinner_categorias_editor_inventario;

    private ArrayList<Uri> mUriFotoList;
    private int numeroDeFotos = 0;
    private String mNome, mTituloExtra1, mTituloExtra2, mObservacao, mFraseDestaque;
    private ArrayList<String> mTags, mParametrosExtra1, mParametroExtra2, mCores, mTamanhos, mEspecificacoesDescricaoList;
    private double mFrete, mPrecoOriginal, mPrecoAntigo, mPrecoNovo;
    private boolean mExtra1Existe, mExtra2Existe, mVarianteCorExiste, mVarianteTamanhoExiste;
    private int mCategoria, mTempoEntrega, mQuantidade;


    public EditorInventarioFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_editor_inventario, container, false);

        ll_bt_add_fotos_editor_inventario = (LinearLayout) view.findViewById(R.id.ll_bt_add_fotos_editor_inventario);
        box_add_cor_editor_invntario = (LinearLayout) view.findViewById(R.id.box_add_cor_editor_invntario);
        box_add_tamanho_editor_inventario = (LinearLayout) view.findViewById(R.id.box_add_tamanho_editor_inventario);
        box_add_extra1_editor_inventario = (LinearLayout) view.findViewById(R.id.box_add_extra1_editor_inventario);
        box_extra2_add_variante_editor_inventario = (LinearLayout) view.findViewById(R.id.box_extra2_add_variante_editor_inventario);

        img1_produto_inventario_editor = (ImageView) view.findViewById(R.id.img1_produto_inventario_editor);
        img2_produto_inventario_editor = (ImageView) view.findViewById(R.id.img2_produto_inventario_editor);
        img3_produto_inventario_editor = (ImageView) view.findViewById(R.id.img3_produto_inventario_editor);
        img4_produto_inventario_editor = (ImageView) view.findViewById(R.id.img4_produto_inventario_editor);
        img5_produto_inventario_editor = (ImageView) view.findViewById(R.id.img5_produto_inventario_editor);

        fab_delete_edior_invenario = (FloatingActionButton) view.findViewById(R.id.fab_delete_edior_invenario);

        spinner_categorias_editor_inventario = (Spinner) view.findViewById(R.id.spinner_categorias_editor_inventario);

        bt_salvar_editor_inventario = (CardView) view.findViewById(R.id.bt_salvar_editor_inventario);

        bt_add_cor_editor_inventario = (View) view.findViewById(R.id.bt_add_cor_editor_inventario);
        bt_add_tamanho_editor_inventario = (View) view.findViewById(R.id.bt_add_tamanho_editor_inventario);
        bt_add_nome_extra1_edior_inventario = (View) view.findViewById(R.id.bt_add_nome_extra1_edior_inventario);
        bt_add_variante_extra1_editor_inventario = (View) view.findViewById(R.id.bt_add_variante_extra1_editor_inventario);
        bt_add_nome_extra2_editor_inventario = (View) view.findViewById(R.id.bt_add_nome_extra2_editor_inventario);
        bt_extra2_add_variante_editor_inventario = (View) view.findViewById(R.id.bt_extra2_add_variante_editor_inventario);
        bt_descricao_frase_destaqueet_descricao_add_especificacoes = (View) view.findViewById(R.id.bt_descricao_frase_destaqueet_descricao_add_especificacoes);
        bt_add_tags_edior_inventario = (View) view.findViewById(R.id.bt_add_tags_edior_inventario);

        nome_editor_inventario = (EditText) view.findViewById(R.id.nome_editor_inventario);
        frete_editor_inventario = (EditText) view.findViewById(R.id.frete_editor_inventario);
        preco_original_editor_inventario = (EditText) view.findViewById(R.id.preco_original_editor_inventario);
        preco_antigo_editor_inevntario = (EditText) view.findViewById(R.id.preco_antigo_editor_inevntario);
        preco_novo_editor_inventario = (EditText) view.findViewById(R.id.preco_novo_editor_inventario);
        et_cor_add_editor_inventario = (EditText) view.findViewById(R.id.et_cor_add_editor_inventario);
        et_tamanho_add_editor_inventario = (EditText) view.findViewById(R.id.et_tamanho_add_editor_inventario);
        et_nome_extra1_editor_inventario = (EditText) view.findViewById(R.id.et_nome_extra1_editor_inventario);
        et_add_extra1_variante_editor_inventario = (EditText) view.findViewById(R.id.et_add_extra1_variante_editor_inventario);
        et_extra2_nome_editor_inventario = (EditText) view.findViewById(R.id.et_extra2_nome_editor_inventario);
        et_extra2_add_variante_editor_inventario = (EditText) view.findViewById(R.id.et_extra2_add_variante_editor_inventario);
        et_descricao_frase_destaque = (EditText) view.findViewById(R.id.et_descricao_frase_destaque);
        et_descricao_observacoes = (EditText) view.findViewById(R.id.et_descricao_observacoes);
        et_descricao_add_especificacos = (EditText) view.findViewById(R.id.et_descricao_add_especificacos);
        et_add_tags_edior_inventario = (EditText) view.findViewById(R.id.et_add_tags_edior_inventario);
        et_tempo_entrega_editor_inventario = (EditText) view.findViewById(R.id.et_tempo_entrega_editor_inventario);
        et_quantidade_editor_inventario = (EditText) view.findViewById(R.id.et_quantidade_editor_inventario);

        cb_cor_editor_inventario = (CheckBox) view.findViewById(R.id.cb_cor_editor_inventario);
        cb_tamanho_editor_inventario = (CheckBox) view.findViewById(R.id.cb_tamanho_editor_inventario);
        cb_extra1_editor_inventario = (CheckBox) view.findViewById(R.id.cb_extra1_editor_inventario);
        cb_extra2_editor_inventario = (CheckBox) view.findViewById(R.id.cb_extra2_editor_inventario);

        anexarListeners();

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGEM) {
            if (resultCode != Activity.RESULT_CANCELED) {
                // sucesso
                Uri uri = data.getData();
                fotoRecebidaComSucesso(uri);
            } else {
                // Erro
                toast("Erro ao adicionar foto");
            }
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(v instanceof EditText) {
            if (!v.isFocusable()) {
                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
            }
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_bt_add_fotos_editor_inventario:
                intentAdicionarFoto();
                break;
            case R.id.cb_cor_editor_inventario:
                if (mCores == null) {
                    mCores = new ArrayList<>();
                }
                toggleBox(box_add_cor_editor_invntario);
                break;
            case R.id.cb_tamanho_editor_inventario:
                if (mTamanhos == null) {
                    mTamanhos = new ArrayList<>();
                }
                toggleBox(box_add_tamanho_editor_inventario);
                break;
            case R.id.cb_extra1_editor_inventario:
                if (mParametrosExtra1 == null) {
                    mParametrosExtra1 = new ArrayList<>();
                }
                toggleBox(box_add_extra1_editor_inventario);
                break;
            case R.id.cb_extra2_editor_inventario:
                if (mParametroExtra2 == null) {
                    mParametroExtra2 = new ArrayList<>();
                }
                toggleBox(box_extra2_add_variante_editor_inventario);
                break;
            case R.id.bt_add_cor_editor_inventario:
                coletarTexto(et_cor_add_editor_inventario, mCores);
                break;
            case R.id.bt_add_tamanho_editor_inventario:
                coletarTexto(et_tamanho_add_editor_inventario, mTamanhos);
                break;
            case R.id.bt_add_variante_extra1_editor_inventario:
                coletarTexto(et_add_extra1_variante_editor_inventario, mParametrosExtra1);
                break;
            case R.id.bt_extra2_add_variante_editor_inventario:
                coletarTexto(et_extra2_add_variante_editor_inventario, mParametroExtra2);
                break;
            case R.id.bt_add_tags_edior_inventario:
                coletarTexto(et_add_tags_edior_inventario, mTags);
                break;
            case R.id.bt_descricao_frase_destaqueet_descricao_add_especificacoes:
                coletarTexto(et_descricao_add_especificacos, mEspecificacoesDescricaoList);
                break;
            default:

                break;
        }
    }

    private void coletarTexto(EditText et, ArrayList<String> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        String texto = et.getText().toString();
        if (texto.length() > 0 && !texto.equals("")) {
            list.add(texto);
            et.setText("");
            et.clearFocus();
        }
    }

    private void toggleBox(LinearLayout box) {
        if (box.getVisibility() == View.VISIBLE) {
            box.setVisibility(View.INVISIBLE);
        } else {
            box.setVisibility(View.GONE);
        }
    }

    private void intentAdicionarFoto() {
        if (mUriFotoList == null) {
            mUriFotoList = new ArrayList<>();
        }
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(intent, "Selecione uma imagem"), PICK_IMAGEM);
    }

    private void fotoRecebidaComSucesso(Uri uriFoto) {
        if (uriFoto == null) {
            toast("Erro ao adicionar foto");
        } else {
            inserirImagem(uriFoto);
        }
    }

    private void toast(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
    }

    private void inserirImagem(Uri uriFoto) {
        //duplo click torna a principal
        //long press exxclui
        switch (numeroDeFotos) {
            default:
                toast("Limite de fotos Esgotado");
                break;
            case 0:
                img1_produto_inventario_editor.setImageURI(uriFoto);
                break;
            case 1:
                img2_produto_inventario_editor.setImageURI(uriFoto);
                break;
            case 2:
                img3_produto_inventario_editor.setImageURI(uriFoto);
                break;
            case 3:
                img4_produto_inventario_editor.setImageURI(uriFoto);
                break;
            case 4:
                img5_produto_inventario_editor.setImageURI(uriFoto);
                break;
        }
        mUriFotoList.add(uriFoto);
        numeroDeFotos++;
    }

    private void anexarListeners() {

        cb_cor_editor_inventario.setOnClickListener(this);
        cb_tamanho_editor_inventario.setOnClickListener(this);
        cb_extra1_editor_inventario.setOnClickListener(this);
        cb_extra2_editor_inventario.setOnClickListener(this);

        ll_bt_add_fotos_editor_inventario.setOnClickListener(this);

        bt_add_cor_editor_inventario.setOnClickListener(this);
        bt_add_tamanho_editor_inventario.setOnClickListener(this);
        bt_add_variante_extra1_editor_inventario.setOnClickListener(this);
        bt_extra2_add_variante_editor_inventario.setOnClickListener(this);
        bt_add_tags_edior_inventario.setOnClickListener(this);
        bt_descricao_frase_destaqueet_descricao_add_especificacoes.setOnClickListener(this);

        nome_editor_inventario.setOnTouchListener(this);
        frete_editor_inventario.setOnTouchListener(this);
        preco_original_editor_inventario.setOnTouchListener(this);
        preco_antigo_editor_inevntario.setOnTouchListener(this);
        preco_novo_editor_inventario.setOnTouchListener(this);
        et_cor_add_editor_inventario.setOnTouchListener(this);
        et_tamanho_add_editor_inventario.setOnTouchListener(this);
        et_nome_extra1_editor_inventario.setOnTouchListener(this);
        et_add_extra1_variante_editor_inventario.setOnTouchListener(this);
        et_extra2_nome_editor_inventario.setOnTouchListener(this);
        et_extra2_add_variante_editor_inventario.setOnTouchListener(this);
        et_descricao_frase_destaque.setOnTouchListener(this);
        et_descricao_add_especificacos.setOnTouchListener(this);
        et_descricao_observacoes.setOnTouchListener(this);
        et_add_tags_edior_inventario.setOnTouchListener(this);
        et_tempo_entrega_editor_inventario.setOnTouchListener(this);
        et_quantidade_editor_inventario.setOnTouchListener(this);
    }

}
