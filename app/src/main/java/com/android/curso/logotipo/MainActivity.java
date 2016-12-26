package com.android.curso.logotipo;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.android.curso.logotipo.adaptador.PageAdapter;
import com.android.curso.logotipo.pojo.Mascota;
import com.android.curso.logotipo.vista.MascotasFragment;
import com.android.curso.logotipo.vista.PerfilMascotaFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitleMarginStart(265);
        setSupportActionBar(miActionBar);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpviewPager();

        if( toolbar != null ){
            setSupportActionBar(toolbar);
        }

/*


*/

    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MascotasFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpviewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog_profile);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch( item.getItemId() )
        {
            case R.id.mRaiting:

                //Toast.makeText(this, "Diste click en el boton de Raiting", Toast.LENGTH_SHORT).show();

                EnlaceMascotas.clear();


                Collections.sort(MascotasFragment.mascotas, new Comparator<Mascota>() {
                    @Override
                    public int compare(Mascota m1, Mascota m2) {
                        return new Integer(m2.getVotos()).compareTo(new Integer(m1.getVotos()));
                    }
                });

                EnlaceMascotas.setMascotasAll(new ArrayList<Mascota>(MascotasFragment.mascotas.subList(0, 5)));

                Intent intent = new Intent(this, ActivityRaiting.class);
                startActivity(intent);

                break;

            case R.id.mContacto:
                //Toast.makeText(this, "Menu Contacto", Toast.LENGTH_SHORT).show();

                Intent ic = new Intent(this, ContactoActivity.class);
                startActivity(ic);

                break;

            case R.id.mAcercaDe:
                //Toast.makeText(this, "Menu Acerca de", Toast.LENGTH_SHORT).show();

                Intent ia = new Intent(this, AcercaDeActivity.class);
                startActivity(ia);








                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
