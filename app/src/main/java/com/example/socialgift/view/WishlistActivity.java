package com.example.socialgift.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.socialgift.R;
import com.example.socialgift.controller.MyWishlistController;
import com.example.socialgift.datamanager.DataManagerAPI;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;

import java.util.List;


public class WishlistActivity extends AppCompatActivity implements DataManagerCallbacks {

    Button createWishlistButton;
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
    }

}