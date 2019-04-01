package xxxpress.developer.adm.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import xxxpress.developer.R;

public class CentralAdmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central_adm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_cenrtal_adm);
        setSupportActionBar(toolbar);

    }
}
