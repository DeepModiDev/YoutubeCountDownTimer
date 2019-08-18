package com.deepmodi.youtubecountdowntimer.ViewHolder;

import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deepmodi.youtubecountdowntimer.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView holder_id;
    public TextView holder_product;
    public WebView holer_webView;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        holder_id = itemView.findViewById(R.id.id_textView);
        holder_product = itemView.findViewById(R.id.product_textView);
        holer_webView = itemView.findViewById(R.id.webView);
        holer_webView.requestFocus();
        holer_webView.getSettings().setJavaScriptEnabled(true);
        holer_webView.getSettings().setGeolocationEnabled(true);

    }
}
