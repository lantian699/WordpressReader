package me.declangao.wordpressreader.app;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import me.declangao.wordpressreader.R;
import me.declangao.wordpressreader.util.Config;
import me.declangao.wordpressreader.util.MyWebViewClient;

public class CommentFragment extends Fragment {
    private static final String TAG = "CommentFragment";

    private WebView webViewComment;

    public CommentFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Disable Options Menu for this fragment
        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_comment, container, false);
        // Setup WebView
        webViewComment = (WebView) rootView.findViewById(R.id.webView_comment);

        //Bundle args = getArguments();
        //
        //if (args != null) {
        //    int id = args.getInt("id");
        //
        //    // Create disqusThreadId
        //    String disqusThreadId = id + " " + Config.BASE_URL + "?p=" + id;
        //    // Create Disqus URL for this specific post
        //    String url = Config.BASE_URL + "showcomments.php?disqus_id=" + disqusThreadId;
        //
        //    // Setup WebView
        //    WebView webViewComment = (WebView) v.findViewById(R.id.webView_comment);
        //    WebSettings webSettings = webViewComment.getSettings();
        //    // Enable JavaScript
        //    webSettings.setJavaScriptEnabled(true);
        //    // Let the WebView handle links in stead of opening links in external web browsers
        //    webViewComment.requestFocusFromTouch();
        //    // User a custom WebViewClient to solve Disqus login and logout issues on Android
        //    // See http://globeotter.com/blog/disqus-android-code/
        //    webViewComment.setWebViewClient(new MyWebViewClient(url));
        //    webViewComment.setWebChromeClient(new WebChromeClient());
        //
        //    // Lollipop only code
        //    // Required on Lollipop in order to save login state
        //    if (Build.VERSION.SDK_INT >= 21) {
        //        // Enable cookies
        //        CookieManager.getInstance().setAcceptThirdPartyCookies(webViewComment, true);
        //    }
        //
        //    // Load Disqus
        //    webViewComment.loadUrl(url);
        //    Log.d(TAG, "Disqus Thread Id: " + disqusThreadId);
        //}

        return rootView;
    }

    /**
     * Since we can't call setArguments() on an existing fragment, we make our own!
     *
     * @param args Bundle containing information about the new comments page
     */
    protected void setUIArguments(final Bundle args) {
        getActivity().runOnUiThread(new Runnable() {
            public void run() {
                int id = args.getInt("id");

                // Create disqusThreadId
                String disqusThreadId = id + " " + Config.BASE_URL + "?p=" + id;
                // Create Disqus URL for this specific post
                String url = Config.BASE_URL + "showcomments.php?disqus_id=" + disqusThreadId;


                WebSettings webSettings = webViewComment.getSettings();
                // Enable JavaScript
                webSettings.setJavaScriptEnabled(true);
                // Let the WebView handle links in stead of opening links in external web browsers
                webViewComment.requestFocusFromTouch();
                // User a custom WebViewClient to solve Disqus login and logout issues on Android
                // See http://globeotter.com/blog/disqus-android-code/
                webViewComment.setWebViewClient(new MyWebViewClient(url));
                webViewComment.setWebChromeClient(new WebChromeClient());

                // Lollipop only code
                // Required on Lollipop in order to save login state
                if (Build.VERSION.SDK_INT >= 21) {
                    // Enable cookies
                    CookieManager.getInstance().setAcceptThirdPartyCookies(webViewComment, true);
                }

                // Load Disqus
                webViewComment.loadUrl(url);
                Log.d(TAG, "Disqus Thread Id: " + disqusThreadId);
            }
        });
    }
}