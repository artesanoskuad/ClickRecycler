package com.artesanoskuad.clickrecycler;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private ProductItemCallback productItemCallback;
    private ImageView ivSelected;
    private TextView tvName;

    public ProductViewHolder(@NonNull View itemView, ProductItemCallback productItemCallback) {
        super(itemView);
        this.productItemCallback = productItemCallback;
        ivSelected = itemView.findViewById(R.id.iv_selected);
        tvName = itemView.findViewById(R.id.tv_producto);
    }

    public void bind(Producto producto) {
        setupClickItem(producto);
        if(producto.isSelected){
            ivSelected.setVisibility(View.VISIBLE);
        } else {
            ivSelected.setVisibility(View.GONE);
        }
        tvName.setText(producto.name);
    }

    private void setupClickItem(Producto producto) {
        itemView.setOnClickListener(v -> productItemCallback.onProductClick(producto));
    }

}

interface ProductItemCallback{
    void onProductClick(Producto producto);
}
