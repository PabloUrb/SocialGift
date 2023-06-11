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
import com.example.socialgift.controller.MyWishlistController;
import com.example.socialgift.controller.WishlistController;
import com.example.socialgift.datamanager.DataManagerAPI;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;
import com.example.socialgift.view.myuser.MyWishlistAdapter;

import java.util.List;


public class WishlistActivity extends AppCompatActivity implements DataManagerCallbacks {

    private RecyclerView recyclerView;
    private MyWishlistAdapter wishlistAdapter;
    private WishlistController wishlistController;
    private Button createNewWishlits;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whishlist);

        createNewWishlits= findViewById(R.id.createWishlistButton);

        wishlistController = new WishlistController(this, this);

        recyclerView = findViewById(R.id.recyclerViewWishlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        wishlistAdapter = new MyWishlistAdapter(wishlistController);
        wishlistAdapter.setOnItemClickListener(this::onItemClick);
        recyclerView.setAdapter(wishlistAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        wishlistController.cargarWishlist();

        createNewWishlits.setOnClickListener(view -> {
            DataManagerAPI.createWishlist();
        });
    }

    public void showWishlists(List<Wishlist> wishlists) {
        wishlistAdapter.setWishlists(wishlists);
        wishlistAdapter.notifyDataSetChanged();
    }

    public void onItemClick(Wishlist wishlist) {
        Log.d("WishlistActivity", "ID (wishlist): " + wishlist.getId());
       /* // Abrir la nueva actividad con el ID de la wishlist
        Intent intent = new Intent(this, WishlistDetailsActivity.class);
        intent.putExtra("wishlist_id", wishlist.getId());
        startActivity(intent);*/
    }

    public void onCreateClick(Wishlist wishlist, Button createNewWishlits) {
        Intent intent = new Intent(this, NewWishlistActivity.class);
        startActivity(intent);
    }

    /*Button createWishlistButton;
    MyWishlistController myWishlistController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whishlist);
        createWishlistButton = findViewById(R.id.);

        createWishlistButton.setOnClickListener(v -> {

            });
        DataManagerAPI.wishlistsUser(DataManagerAPI.getObjectUser().getId(), this, new DataManagerCallbackWishlists<Wishlist>() {
            @Override
            public void onSuccess(List<Wishlist> wishlists) {
                Log.d("MyWishlistController", "Wishlists: " + wishlists);
                myWishlistController.loadWishlists();
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("MyWishlistController", errorMessage);
            }
        });
    }*/

}