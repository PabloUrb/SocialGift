package com.example.socialgift.controller;

import android.content.Context;
import android.util.Log;

import com.example.socialgift.datamanager.DataManagerAPI;
import com.example.socialgift.datamanager.DataManagerCallbacks;
import com.example.socialgift.model.Wishlist;
import com.example.socialgift.view.WishlistActivity;

import java.util.ArrayList;
import java.util.List;

public class WishlistController {
    private WishlistActivity activity;
    private Context context;
    private int currentPage = 0;
    private List<Wishlist> loadedWishlist = new ArrayList<>();

    public WishlistController (Context context, WishlistActivity activity){
        this.activity = activity;
        this.context = context;
    }

    public void cargarWishlist() {
        DataManagerAPI.wishlistsMyUser(activity, new DataManagerCallbacks.DataManagerCallbackWishlists<Wishlist>() {
            @Override
            public void onSuccess(List<Wishlist> wishlists) {
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
