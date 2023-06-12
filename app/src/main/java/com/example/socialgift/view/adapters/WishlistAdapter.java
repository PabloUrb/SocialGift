package com.example.socialgift.view.adapters;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.socialgift.R;
import com.example.socialgift.controller.WishlistController;
import com.example.socialgift.model.Wishlist;

import java.util.ArrayList;
import java.util.List;

public class WishlistAdapter extends RecyclerView.Adapter<WishlistAdapter.WishlistViewHolder> {
    private WishlistController wishlistController;
    private List<Wishlist> wishlists;
    private OnItemClickListener itemClickListener;

    public WishlistAdapter(WishlistController wishlistController) {
        this.wishlistController = wishlistController;
        this.wishlists = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public WishlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wishlist, parent, false);
        return new WishlistAdapter.WishlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WishlistViewHolder holder, int position) {
        Wishlist wishlist = wishlists.get(position);
        holder.bind(wishlist);
    }

    public int getItemCount() {
        return wishlists.size();
    }

    public void setWishlists(List<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    public interface OnItemClickListener {
        void onItemClick(Wishlist wishlist);
    }

    public class WishlistViewHolder extends ViewHolder implements View.OnClickListener {
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView endDateTextView;

        public WishlistViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.Nombre);
            descriptionTextView = itemView.findViewById(R.id.Descripcion);
            endDateTextView = itemView.findViewById(R.id.tvFecha);
            itemView.setOnClickListener(this);
        }

        //@SuppressLint("SetTextI18n")
        public void bind(Wishlist wishlist) {
            System.out.println("getId :: "+wishlist.getId());
            System.out.println("getName :: "+wishlist.getName());
            System.out.println("getEndDate :: "+wishlist.getEndDate());
            System.out.println("getDescription :: "+wishlist.getDescription());
            titleTextView.setText(wishlist.getName());
            descriptionTextView.setText("Descripción: "+wishlist.getDescription());

            if (wishlist.getEndDate() != null) {
                endDateTextView.setText(wishlist.getEndDate().toString());
            } else {
                endDateTextView.setText("");
            }
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != NO_POSITION) {
                Wishlist wishlist = wishlists.get(position);
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(wishlist);
                }
            }
        }
    }
}
