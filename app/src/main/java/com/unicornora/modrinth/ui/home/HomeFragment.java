package com.unicornora.modrinth.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.unicornora.modrinth.R;
import com.unicornora.modrinth.WebViewController;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        WebView webView = root.findViewById(R.id.web_view_home);
        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.modrinth.com/");

        webView.setWebViewClient(new WebViewController(){
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return false;
        }
        });
        return root;
    }
}