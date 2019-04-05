package xxxpress.developer.adm.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xxxpress.developer.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class InventarioFragment extends Fragment {

    private RecyclerView recyclerView;

    public InventarioFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inventario, container, false);

        return view;
    }
}
