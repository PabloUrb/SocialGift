package com.example.socialgift.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.socialgift.R;
import com.example.socialgift.controller.WishlistController;
import com.example.socialgift.datamanager.DataManagerAPI;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;
import com.google.android.play.integrity.internal.t;

public class NewWishlistActivity extends AppCompatActivity {
    WishlistController wishlistController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_wishlist);


    }
}