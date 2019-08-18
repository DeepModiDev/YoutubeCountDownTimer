package com.deepmodi.youtubecountdowntimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.deepmodi.youtubecountdowntimer.Model.Category;
import com.deepmodi.youtubecountdowntimer.ViewHolder.CategoryViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Category, CategoryViewHolder> adapter;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //firebase init
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Category");

        //recyclerView init
        recyclerView = findViewById(R.id.recyclerView);

        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);


        FirebaseRecyclerOptions<Category> options = new FirebaseRecyclerOptions.Builder<Category>()
                .setQuery(reference,Category.class)
                .build();

        adapter = new FirebaseRecyclerAdapter<Category, CategoryViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i, @NonNull Category category) {
                categoryViewHolder.holder_id.setText(category.getId());
                categoryViewHolder.holder_product.setText(category.getProduct());
                categoryViewHolder.holer_webView.loadData(category.getTime(),"text/html","UTF-8");
            }

            @NonNull
            @Override
            public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
                return new CategoryViewHolder(view);
            }
        };
        adapter.startListening();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }
}
