package xxxpress.developer.adm.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Debug;
import android.provider.MediaStore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.WriteBatch;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import androidx.fragment.app.Fragment;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import xxxpress.developer.R;
import xxxpress.developer.adm.ProdutoAdmin;
import xxxpress.developer.adm.activites.EditorInventarioActivity;
import xxxpress.developer.constantes.ConstantesBancoDeDadosFirebase;
import xxxpress.developer.produto.DescricaoProduto;
import xxxpress.developer.produto.ParametrosExtrasProdutos;
import xxxpress.developer.produto.Produto;

/**
 * A placeholder fragment containing a simple view.
 */
public class EditorInventarioFragment extends Fragment implements View.OnTouchListener, View.OnClickListener {

    public static final int PICK_IMAGEM = 1234;

    private ProdutoAdmin masterProdutoAdmin;

    private LinearLayout ll_bt_add_fotos_editor_inventario, box_add_cor_editor_invntario, box_add_tamanho_editor_inventario,
            box_add_extra1_editor_inventario, box_extra2_add_variante_editor_inventario;

    private ImageView img1_produto_inventario_editor, img2_produto_inventario_editor, img3_produto_inventario_editor, img4_produto_inventario_editor, img5_produto_inventario_editor;

    private FloatingActionButton fab_inventario_edt;

    private ProgressBar pb;

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
            bt_add_tags_edior_inventario, bt_bar_excluir_editor_inventario;

    private Spinner spinner_categorias_editor_inventario;

    private TextView tv_bar_excluir_editor_inventario;

    private ArrayList<Uri> mUriFotoList;
    private int numeroDeFotos = 0;
    private String mNome, mTituloExtra1, mTituloExtra2, mObservacao, mFraseDestaque;
    private ArrayList<String> mTags, mParametrosExtra1, mParametroExtra2, mCores, mTamanhos, mEspecificacoesDescricaoList, pathFotos;
    private double mFrete, mPrecoOriginal, mPrecoAntigo, mPrecoNovo;
    private boolean mExtra1Existe, mExtra2Existe, mVarianteCorExiste, mVarianteTamanhoExiste;
    private int mCategoria, mTempoEntrega, mQuantidade;


    private FirebaseAuth mAuth;
    private FirebaseFirestore mFirestore;
    private FirebaseStorage mStorage;
    private StorageReference mStorageReference;


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

        fab_inventario_edt = (FloatingActionButton) view.findViewById(R.id.fab_inventario_edt);

        pb = (ProgressBar) view.findViewById(R.id.pb_editor_inventario);

        spinner_categorias_editor_inventario = (Spinner) view.findViewById(R.id.spinner_categorias_editor_inventario);

        tv_bar_excluir_editor_inventario = (TextView) view.findViewById(R.id.tv_bar_excluir_editor_inventario);

//        bt_salvar_editor_inventario = (CardView) view.findViewById(R.id.bt_salvar_editor_inventario);

        bt_add_cor_editor_inventario = (View) view.findViewById(R.id.bt_add_cor_editor_inventario);
        bt_add_tamanho_editor_inventario = (View) view.findViewById(R.id.bt_add_tamanho_editor_inventario);
        bt_add_nome_extra1_edior_inventario = (View) view.findViewById(R.id.bt_add_nome_extra1_edior_inventario);
        bt_add_variante_extra1_editor_inventario = (View) view.findViewById(R.id.bt_add_variante_extra1_editor_inventario);
        bt_add_nome_extra2_editor_inventario = (View) view.findViewById(R.id.bt_add_nome_extra2_editor_inventario);
        bt_extra2_add_variante_editor_inventario = (View) view.findViewById(R.id.bt_extra2_add_variante_editor_inventario);
        bt_descricao_frase_destaqueet_descricao_add_especificacoes = (View) view.findViewById(R.id.bt_descricao_frase_destaqueet_descricao_add_especificacoes);
        bt_add_tags_edior_inventario = (View) view.findViewById(R.id.bt_add_tags_edior_inventario);
        bt_bar_excluir_editor_inventario = (View) view.findViewById(R.id.bt_bar_excluir_editor_inventario);

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

        instanciarFirebase();
        anexarListeners();
        iniciarArrays();

        mCategoria = -1;

        spinner_categorias_editor_inventario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mCategoria = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        et_extra2_nome_editor_inventario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    bt_add_nome_extra2_editor_inventario.setAlpha(1);
                else
                    bt_add_nome_extra2_editor_inventario.setAlpha((float) 0.3);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_nome_extra1_editor_inventario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count > 0)
                    bt_add_nome_extra1_edior_inventario.setAlpha(1);
                else
                    bt_add_nome_extra1_edior_inventario.setAlpha((float) 0.3);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return view;
    }

    private void instanciarFirebase() {
        mAuth = FirebaseAuth.getInstance();
        mStorage = FirebaseStorage.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        mStorageReference = mStorage.getReference();
    }

    private void iniciarArrays() {
        mUriFotoList = new ArrayList<>();
        mTags = new ArrayList<>();
        mEspecificacoesDescricaoList = new ArrayList<>();
        mParametroExtra2 = new ArrayList<>();
        mParametrosExtra1 = new ArrayList<>();
        mCores = new ArrayList<>();
        pathFotos = new ArrayList<>();
        mTamanhos = new ArrayList<>();
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
            case R.id.bt_bar_excluir_editor_inventario:
                excluir();
                break;
            case R.id.tv_bar_excluir_editor_inventario:
                excluir();
                break;
            case R.id.fab_inventario_edt:
                salvar();
                break;
            default:

                break;
        }
    }

    private void salvar() {
        if (dadosEstaoCompletos()) {
            pb.setVisibility(View.VISIBLE);
            DocumentReference docRef = mFirestore.collection(ConstantesBancoDeDadosFirebase.PRODUTOS).document();
            String prodId = docRef.getId();
            armazenarFotos(mUriFotoList, prodId);
            ParametrosExtrasProdutos p1 = new ParametrosExtrasProdutos(mExtra1Existe, mTituloExtra1, mParametrosExtra1);
            ParametrosExtrasProdutos p2 = new ParametrosExtrasProdutos(mExtra2Existe, mTituloExtra2, mParametroExtra2);
            DescricaoProduto d = new DescricaoProduto(mObservacao, mFraseDestaque, mEspecificacoesDescricaoList);
            Produto produto = new Produto(prodId, mNome, mFrete, mPrecoAntigo, mPrecoNovo, mTags, p1, p2, mCores, mTamanhos, d, mCategoria, mTempoEntrega, mQuantidade, pathFotos, prodId, null, false);
            masterProdutoAdmin = new ProdutoAdmin(produto, mPrecoOriginal);
            DocumentReference prodAdminRef = mFirestore.collection(ConstantesBancoDeDadosFirebase.PRODUTOS_ADMIN).document(prodId);
            WriteBatch batch = mFirestore.batch();
            batch.set(docRef, produto);
            batch.set(prodAdminRef, masterProdutoAdmin);
            batch.commit().addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(Exception e) {
                    salvar();
                }
            }).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    startActivity(new Intent(getActivity(), EditorInventarioActivity.class));
                    getActivity().finish();
                }
            });
        }

    }

    private void excluir() {
        toast("Excluir Produto");
    }

    private ArrayList<String> armazenarFotos(final ArrayList<Uri> uriList, final String id) {
        Uri uri = null;
        if (uriList.size() > 0) {
            uri = uriList.get(0);
            final StorageReference ref = mStorageReference.child("produtos").child(id).child(uri.getLastPathSegment());

            ref.putFile(uri).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()) {
                        throw task.getException();
                    }
                    return ref.getDownloadUrl();
                }
            }).addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri u) {
                    uriList.remove(0);
                    pathFotos.add(u.toString());
                    armazenarFotos(uriList, id);

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(Exception e) {
                    armazenarFotos(uriList, id);
                }
            });
        }

        return pathFotos;

    }

    private boolean dadosEstaoCompletos() {

        if (nome_editor_inventario.getText().length() > 0 && !nome_editor_inventario.getText().toString().equals("")) {
            //NOME DO PRODUTO INSERIDO
            mNome = nome_editor_inventario.getText().toString();

            if (mUriFotoList.size() > 0) {
                //FOTOS INSERIDAS

                if (frete_editor_inventario.getText().length() > 0 && !frete_editor_inventario.getText().toString().equals("")) {
                    //FRETE INSERIDO
                    mFrete = Double.valueOf(frete_editor_inventario.getText().toString());

                    if (preco_original_editor_inventario.getText().length() > 0 && !preco_original_editor_inventario.getText().toString().equals("")) {
                        //PRECO ORIGINAL INSERIDO
                        mPrecoOriginal = Double.valueOf(preco_original_editor_inventario.getText().toString());

                        if (preco_antigo_editor_inevntario.getText().length() > 0 && !preco_antigo_editor_inevntario.getText().toString().equals("")) {
                            //PREÇO ANTIGO INSERIDO
                                mPrecoAntigo = Double.valueOf(preco_antigo_editor_inevntario.getText().toString());

                                if (preco_novo_editor_inventario.getText().length() > 0 && !preco_novo_editor_inventario.getText().toString().equals("")) {
                                    //PREÇO NOVO INSERIDO
                                    mPrecoNovo = Double.valueOf(preco_novo_editor_inventario.getText().toString());

                                    if ((cb_cor_editor_inventario.isChecked() && mCores.size() > 0) || !cb_cor_editor_inventario.isChecked()) {
                                        //PRODUTO POSSUI MAIS DE UMA COR E AS FORAM INSERIDAS
                                        //OU
                                        //PRODUTO NÃO POSSUI CORES VARIAVEIS

                                        if ((cb_tamanho_editor_inventario.isChecked() && mTamanhos.size() > 0) || !cb_tamanho_editor_inventario.isChecked()) {
                                            //PRODUTO POSSUI MAIS DE UM TAMANHO E FORAM INSERIDAS
                                            //OU
                                            //PRODUTO NÃO POSSUI TAMANHOS VARIAVEIS

                                            if ((cb_extra1_editor_inventario.isChecked() && mParametrosExtra1.size() > 0 && et_nome_extra1_editor_inventario.getText().length() > 0) || !cb_extra1_editor_inventario.isChecked()) {
                                                //PRODUTO POSSUI UMA VARIANTE EXTRA, NOME E VARIAVEIS FORAM INSERIDAS
                                                //OU
                                                //PRODUTO NÃO POSSUI TAMANHOS VARIAVEIS
                                                mTituloExtra1 = et_nome_extra1_editor_inventario.getText().toString();
                                                mExtra1Existe = cb_extra1_editor_inventario.isChecked();

                                                if ((cb_extra2_editor_inventario.isChecked() && mParametroExtra2.size() > 0 && et_extra2_nome_editor_inventario.getText().length() > 0) || !cb_extra2_editor_inventario.isChecked()) {
                                                    //PRODUTO POSSUI UMA VARIANTE EXTRA, NOME E VARIAVEIS FORAM INSERIDAS
                                                    //OU
                                                    //PRODUTO NÃO POSSUI TAMANHOS VARIAVEIS
                                                    mTituloExtra2 = et_extra2_nome_editor_inventario.getText().toString();
                                                    mExtra2Existe = cb_extra2_editor_inventario.isChecked();

                                                    if (et_descricao_frase_destaque.getText().length() > 0 && !et_descricao_frase_destaque.getText().toString().equals("")) {
                                                        //FRASE DE DESTAQUE INSERIDA
                                                        mFraseDestaque = et_descricao_frase_destaque.getText().toString();

                                                        if (et_descricao_observacoes.getText().length() > 0 && !et_descricao_observacoes.getText().toString().equals("")) {
                                                            //OBSERVACAO INSERIDA
                                                            mObservacao = et_descricao_observacoes.getText().toString();

                                                            if (mEspecificacoesDescricaoList.size() >= 5) {
                                                                //FRASE DE DESTAQUE INSERIDA

                                                                if (mTags.size() >= 10) {

                                                                    if (mCategoria != -1) {

                                                                        mCategoria = spinner_categorias_editor_inventario.getSelectedItemPosition();

                                                                        if (et_tempo_entrega_editor_inventario.getText().length() > 0 && !et_tempo_entrega_editor_inventario.getText().toString().equals("")) {

                                                                            mTempoEntrega = Integer.valueOf(et_tempo_entrega_editor_inventario.getText().toString());

                                                                            if (et_quantidade_editor_inventario.getText().length() > 0 && !et_quantidade_editor_inventario.getText().toString().equals("")) {

                                                                                mQuantidade = Integer.valueOf(et_quantidade_editor_inventario.getText().toString());

                                                                                return true;

                                                                            } else {
                                                                                toast("Insira a quantidade");
                                                                                return false;
                                                                            }

                                                                        } else {
                                                                            toast("Insira o tempo de entrega");
                                                                            return false;
                                                                        }

                                                                    } else {
                                                                        toast("Escolha uma categoria");
                                                                        return false;
                                                                    }

                                                                } else {
                                                                    int n = 10 - mEspecificacoesDescricaoList.size();
                                                                    toast("TAGS: Insira mais " + String.valueOf(n));
                                                                    return false;
                                                                }

                                                            } else {
                                                                //FRASE DE DESTAQUE NÃO INSERIDA
                                                                int n = 5 - mEspecificacoesDescricaoList.size();
                                                                toast("Especificações: Insira mais " + String.valueOf(n));
                                                                return false;
                                                            }

                                                        } else {
                                                            //OBSERVACAO NÃO INSERIDA
                                                            toast("Insira a observação para descrição");
                                                            return false;
                                                        }

                                                    } else {
                                                        //FRASE DE DESTAQUE NÃO INSERIDA
                                                        toast("Insira a frase de destaque para descrição");
                                                        return false;
                                                    }

                                                } else  {
                                                    //NOME DA VARIANTE OU SUAS VARIAVEIS NÃO FORAM INSERIDAS
                                                    if (et_extra2_nome_editor_inventario.getText().length() == 0)
                                                        toast("Insira o nome da Variante extra2 do seu produto");
                                                    else
                                                        toast("Insira as variaveis extra2 do seu produto");
                                                    return false;
                                                }

                                            } else  {
                                                //NOME DA VARIANTE OU SUAS VARIAVEIS NÃO FORAM INSERIDAS
                                                if (et_nome_extra1_editor_inventario.getText().length() == 0)
                                                    toast("Insira o nome da Variante extra1 do seu produto");
                                                else
                                                    toast("Insira as variaveis extra1 do seu produto");
                                                return false;
                                            }

                                        } else  {
                                            //TAMANHOS NÃO INSERIDOS
                                            toast("Insira os tamanhos do seu produto");
                                            return false;
                                        }


                                    } else  {
                                        //CORES NÃO INSERIDAS
                                        toast("Insira as cores do seu produto");
                                        return false;
                                    }

                                } else {
                                    toast("Insira o preço novo");
                                    return false;
                                }

                        } else {
                            toast("Insira o preço antigo");
                            return false;
                        }

                    } else {
                        toast("Insira o preço original");
                        return false;
                    }

                } else {
                    toast("Insira o valor do Frete");
                    return false;
                }

            } else {
                toast("Insira fotos");
                return false;
            }

        } else {
            toast("Insira o nome do produto");
            return false;
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
        }
    }

    private void toggleBox(LinearLayout box) {
        if (box.getVisibility() == View.VISIBLE) {
            box.setVisibility(View.GONE);
        } else {
            box.setVisibility(View.VISIBLE);
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
                img2_produto_inventario_editor.setVisibility(View.VISIBLE);
                break;
            case 1:
                img2_produto_inventario_editor.setImageURI(uriFoto);
                img3_produto_inventario_editor.setVisibility(View.VISIBLE);
                break;
            case 2:
                img3_produto_inventario_editor.setImageURI(uriFoto);
                img4_produto_inventario_editor.setVisibility(View.VISIBLE);
                break;
            case 3:
                img4_produto_inventario_editor.setImageURI(uriFoto);
                img5_produto_inventario_editor.setVisibility(View.VISIBLE);
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

        fab_inventario_edt.setOnClickListener(this);
        tv_bar_excluir_editor_inventario.setOnClickListener(this);
        bt_bar_excluir_editor_inventario.setOnClickListener(this);
    }

}
