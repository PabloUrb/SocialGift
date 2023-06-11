package com.example.socialgift.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.socialgift.R;
import com.example.socialgift.controller.UsersController;
import com.example.socialgift.view.fragments.ShowReservedFragment;

public class ShowReservedActivity extends AppCompatActivity {
    private UsersController usersController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_reserved);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ShowReservedFragment showReservedFragment = new ShowReservedFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.show_reserved_fragment, showReservedFragment)
                .commit();
    }
    public boolean onOptionsItemSelected(MenuItem item){
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        int id = item.getItemId();

        if (id==android.R.id.home) {
            finish();
        }
        return true;
    }
}