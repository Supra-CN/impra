package tw.supra.impra;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SuWebViewClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		// TODO Auto-generated method stub
		view.loadUrl(url);
		return true;
	}
}
