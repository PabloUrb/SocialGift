package com.example.socialgift.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialgift.R;
import com.example.socialgift.controller.WishlistAdapter;
import com.example.socialgift.controller.WishlistController;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;
import com.example.socialgift.view.myuser.ShowMyUserActivity;

import java.util.List;


public class WishlistActivity extends AppCompatActivity implements DataManagerCallbacks {
    private Wishlist wishlist;
    private RecyclerView recyclerView;
    private WishlistAdapter wishlistAdapter;
    private WishlistController wishlistController;
    private Button createNewWishlits;
    private com.google.android.material.bottomnavigation.BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whishlist);

        bottomNavigationView = findViewById(R.id.bottom_navigationbar);
        bottomNavigationView.getMenu().clear();
        bottomNavigationView.inflateMenu(R.menu.menu);

        createNewWishlits= findViewById(R.id.createWishlistButton);

        wishlistController = new WishlistController(this, this);

        recyclerView = findViewById(R.id.recyclerViewWishlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wishlistAdapter = new WishlistAdapter(wishlistController);
        wishlistAdapter.setOnItemClickListener(this::onItemClick);
        recyclerView.setAdapter(wishlistAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        wishlistController.cargarWishlist();

        createNewWishlits.setOnClickListener(view -> {
            onCreateClick(wishlist, createNewWishlits);
        });

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.ic_home:
                    startActivity(new Intent(this, MainActivity.class));
                    break;
                case R.id.ic_user:
                    startActivity(new Intent(this, ShowMyUserActivity.class));
                    break;
                case R.id.ic_basket:
                    break;
                case R.id.ic_menu:
                    break;
            }
            return false;
        });
    }

    public void showWishlists(List<Wishlist> wishlists) {
        wishlistAdapter.setWishlists(wishlists);
        wishlistAdapter.notifyDataSetChanged();
    }

    public void onItemClick(Wishlist wishlist) {
        Log.d("WishlistActivity", "ID (wishlist): " + wishlist.getId());
    }

    public void onCreateClick(Wishlist wishlist, Button createNewWishlits) {
        Intent intent = new Intent(this, NewWishlistActivity.class);
        startActivity(intent);
    }

}