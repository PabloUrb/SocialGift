package com.example.socialgift.controller;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.socialgift.datamanager.DataManagerAPI;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;
import com.example.socialgift.view.EditWishlistActivity;
import com.example.socialgift.view.NewWishlistActivity;
import com.example.socialgift.view.WishlistActivity;
import com.google.android.play.core.integrity.v;

import java.util.ArrayList;
import java.util.List;

public class WishlistController {
    private WishlistActivity activity;
    private NewWishlistActivity newWishlistActivity;
    private EditWishlistActivity editWishlistActivity;
    private Context context;
    private int currentPage = 0;
    private List<Wishlist> loadedWishlist = new ArrayList<>();

    public WishlistController (Context context, WishlistActivity activity){
        this.activity = activity;
        this.context = context;
    }
    public WishlistController (NewWishlistActivity newWishlistActivity, Context context) {
        this.newWishlistActivity = newWishlistActivity;
        this.context = context;
    }
    public WishlistController (EditWishlistActivity editWishlistActivity, Context context){
        this.editWishlistActivity = editWishlistActivity;
        this.context = context;
    }
    public void cargarWishlist() {
        DataManagerAPI.wishlistsMyUser(context, new DataManagerCallbacks.DataManagerCallbackWishlists<Wishlist>() {
            @Override
            public void onSuccess(List<Wishlist> wishlists) {
                System.out.println("wishlists.size() :: "+wishlists.size());
                activity.showWishlists(wishlists);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("No hay wishlists", errorMessage);
            }
        });
    }

    public void NewWishlist(Wishlist wishlist) {
        DataManagerAPI.createWishlist(wishlist, context, new DataManagerCallbacks.DataManagerCallback() {
            @Override
            public void onSuccess() {
                Log.d("No hay wishlists", "Wishlist creada");
                Toast.makeText(context, "Tu wishlist ha sido creada",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("No hay wishlists", errorMessage);
            }
        });
    }

    public void editWishlist(Wishlist wishlist) {
        DataManagerAPI.editWishlist(wishlist, context, new DataManagerCallbacks.DataManagerCallback() {
            @Override
            public void onSuccess() {
                Log.d("No hay wishlists", "Wishlist editada");
                Toast.makeText(context, "Tu wishlist ha sido modificada",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, WishlistActivity.class);
                context.startActivity(intent);
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("No hay wishlists", errorMessage);
            }
        });
    }
    
    /*public void deleteWishlist(Wishlist wishlist) {
        DataManagerAPI.deleteWishlist(wishlist, context, new DataManagerCallbacks.DataManagerCallback() {
            @Override
            public void onSuccess() {
                Log.d("No hay wishlists", "Wishlist borrada");
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("No hay wishlists", errorMessage);
            }
        });
    }*/
}
