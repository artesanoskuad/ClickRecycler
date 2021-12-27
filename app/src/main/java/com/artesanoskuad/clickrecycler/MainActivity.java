package com.artesanoskuad.clickrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ProductItemCallback {

    private List<Producto> productos;
    private ProductAdapter adapter;
    private RecyclerView rvProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDependencies();
        setupRecyclerView();
    }


    private void initDependencies() {
        productos = getFakeProducts();
        rvProductos = findViewById(R.id.rv_products);
        adapter = new ProductAdapter(productos, this);
    }

    private void setupRecyclerView() {
        rvProductos.setLayoutManager(new LinearLayoutManager(this));
        rvProductos.setAdapter(adapter);
    }

    private List<Producto> getFakeProducts() {
        List<Producto> productos = new ArrayList<>();

        productos.add(new Producto(false, "Producto Uno"));
        productos.add(new Producto(false, "Producto Dos"));
        productos.add(new Producto(false, "Producto Tres"));
        productos.add(new Producto(false, "Producto Cuatro"));

        return productos;
    }

    @SuppressLint("NotifyDataSetChanged")
    @Override
    public void onProductClick(Producto producto) {
        producto.isSelected = !producto.isSelected;

        // Acá sumamos y pintamos el resumen

        // Con esta instruccion se recrea el Recycler
        adapter.notifyDataSetChanged();
    }
}