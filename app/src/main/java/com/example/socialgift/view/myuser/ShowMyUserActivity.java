package com.example.socialgift.view.myuser;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.socialgift.R;
import com.example.socialgift.view.MainActivity;
import com.example.socialgift.view.WishlistActivity;
import com.example.socialgift.view.myuser.fragments.ShowMyUserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ShowMyUserActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_user);

        bottomNavigationView = findViewById(R.id.navigationbar);
        bottomNavigationView.getMenu().clear();
        bottomNavigationView.inflateMenu(R.menu.menu);
        bottomNavigationView.setSelectedItemId(R.id.ic_user);


        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.ic_home:
                    startActivity(new Intent(this, MainActivity.class));
                    break;
                case R.id.ic_user:
                    startActivity(new Intent(this, ShowMyUserActivity.class));
                    break;
                case R.id.ic_basket:
                    startActivity(new Intent(this, WishlistActivity.class));
                    break;
            }
            return false;
        });


 /*       */

        // Agregar el fragmento del encabezado
        /*HeaderFragment headerFragment = new HeaderFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.header_container, headerFragment)
                .commit();*/

        // Crea una instancia del fragment ShowMyUserFragment
        ShowMyUserFragment showMyUserFragment = new ShowMyUserFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.show_my_user_container, showMyUserFragment)
                .commit();

        // Agregar el fragmento del pie de página
       /* FooterFragment footerFragment = new FooterFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.footer_container, footerFragment)
                .commit();*/
    }

    public void replaceWithShowMyUserFragment() {
        ShowMyUserFragment showMyUserFragment = new ShowMyUserFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.show_my_user_container, showMyUserFragment)
                .commit();
    }
}
