package xxxpress.developer.adm.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import xxxpress.developer.R;

public class CentralAdmActivity extends AppCompatActivity {

    private CardView btInventario, btSair;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_adm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cenrtal_adm);
        setSupportActionBar(toolbar);
        auth = FirebaseAuth.getInstance();
        btInventario = (CardView) findViewById(R.id.bt_adm_central_inventario);
        btSair = (CardView) findViewById(R.id.bt_adm_central_sair);
        Toast.makeText(this, auth.getUid(), Toast.LENGTH_SHORT).show();
        btInventario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CentralAdmActivity.this, InventarioActivity.class));

            }
        });

        btSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signOut();
            }
        });
    }
}
