package com.task.app.binding;

import android.databinding.BindingAdapter;
import android.webkit.WebView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Rafiq Ahmed on 4/18/2018.
 */

public class CustomBindingAdapter {

    public CustomBindingAdapter() {}

    @BindingAdapter("app:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        url = url.trim();
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @BindingAdapter("app:htmlText")
    public static void loadHtml(WebView webView, String html) {
        webView.loadData(html, "text/html", "UTF-8");
    }

}
