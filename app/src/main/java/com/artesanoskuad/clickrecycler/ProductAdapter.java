package com.artesanoskuad.clickrecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private ProductItemCallback productItemCallback;
    private List<Producto> productos;

    public ProductAdapter(List<Producto> productos, ProductItemCallback productItemCallback) {
        this.productItemCallback = productItemCallback;
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_item, parent, false);
        return new ProductViewHolder(view, productItemCallback);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.bind(productos.get(position));
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }
}
