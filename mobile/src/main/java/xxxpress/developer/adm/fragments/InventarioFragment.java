package xxxpress.developer.adm.fragments;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import xxxpress.developer.R;
import xxxpress.developer.adm.objetos.ProdutoAdmin;
import xxxpress.developer.adm.activites.EditorInventarioActivity;
import xxxpress.developer.adm.adapter.InventarioAdapter;
import xxxpress.developer.adm.objetos.ProdutoAdminParcelable;
import xxxpress.developer.constantes.ConstantesBancoDeDadosFirebase;

/**
 * A placeholder fragment containing a simple view.
 */
public class InventarioFragment extends Fragment implements InventarioAdapter.InventarioClickListener {

    private RecyclerView recyclerView;
    private InventarioAdapter adapter;
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private ArrayList<ProdutoAdmin> produtoAdminArrayList;

    public InventarioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);
        firestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_inventario);
        produtoAdminArrayList = new ArrayList<>();
        obterProdutos();
        return view;
    }

    private void obterProdutos() {
        firestore.collection(ConstantesBancoDeDadosFirebase.PRODUTOS_ADMIN).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (queryDocumentSnapshots.getDocuments().size() > 0 && !queryDocumentSnapshots.isEmpty()) {
                    for (int i = 0; i < queryDocumentSnapshots.getDocuments().size(); i++) {
                        ProdutoAdmin p = queryDocumentSnapshots.getDocuments().get(i).toObject(ProdutoAdmin.class);
                        produtoAdminArrayList.add(p);
                    }
                    preencherInterface();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception e) {
                obterProdutos();
            }
        });
    }

    private void preencherInterface() {
        adapter = new InventarioAdapter(produtoAdminArrayList, getActivity(), InventarioFragment.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    }

    @Override
    public void inventarioItemClick(ProdutoAdmin produto) {
//        ProdutoAdminParcelable parcelable = new ProdutoAdminParcelable(produto.getProduto(), produto.getValorDeCompra());
//        Intent intent = new Intent(getActivity(), EditorInventarioActivity.class);
//        intent.putExtra("prod", parcelable);
//        startActivity(intent);

    }
}
