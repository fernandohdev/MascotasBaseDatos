package com.android.curso.logotipo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;

public class AcercaDeActivity extends AppCompatActivity {

    private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitleMarginStart(265);
        setSupportActionBar(miActionBar);


    }
}
