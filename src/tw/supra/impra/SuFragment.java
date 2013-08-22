package tw.supra.impra;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class SuFragment extends Fragment {

	private SuWebView mWebView;

	public SuFragment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	public static final String ARG_SECTION_NUMBER = "section_number";

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Context context = container.getContext();
		// View rootView = inflater.inflate(R.layout.fragment_main_dummy,
		// container, false);
		LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);
		ViewGroup rootContainer = new FrameLayout(context);
		rootContainer.setLayoutParams(lp);

		// TextView dummyTextView = (TextView) rootView
		// .findViewById(R.id.section_label);
		// dummyTextView.setText(Integer.toString(getArguments().getInt(
		// ARG_SECTION_NUMBER)));
		mWebView = new SuWebView(context);
		mWebView.setWebViewClient(new SuWebViewClient());
		mWebView.setLayoutParams(lp);
		rootContainer.addView(mWebView);
		return rootContainer;
	}

	public SuWebView getWebView() {
		return mWebView;
	}

	@Override
	public ViewGroup getView() {
		// TODO Auto-generated method stub
		return (ViewGroup)super.getView();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mWebView.loadUrl("http://sohu.com");
	}
}
