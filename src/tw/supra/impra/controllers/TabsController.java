package tw.supra.impra.controllers;



import java.util.ArrayList;
import java.util.List;

import tw.supra.impra.BrowserActivity;
import tw.supra.impra.SuFragment;
import android.content.Context;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.ViewGroup;
import android.webkit.WebView;

	/**
	 * Controller managing tabs.
	 * Responsible for tabs creation, selection, deletion.
	 */
	public final class TabsController {
		
		public static final int TAB_CONTEXT_MENU_OPEN = Menu.FIRST + 10;
		public static final int TAB_CONTEXT_MENU_OPEN_IN_NEW_TAB = Menu.FIRST + 11;
		
		private List<SuFragment> mWebViewList;
		
		private BrowserActivity mMainActivity;
//		private ViewFlipper mWebViewsContainer;
		private ViewGroup mWebViewsContainer;
//		private OnTouchListener mTouchListener;
		private LayoutInflater mInflater = null;
		
//		private Method mWebViewSetEmbeddedTitleBar = null;
		
		private OnSharedPreferenceChangeListener mPreferenceChangeListener;
		
		/**
		 * Holder for singleton implementation.
		 */
		private static final class TabsControllerHolder {
			private static final TabsController INSTANCE = new TabsController();
			/**
			 * Private Constructor.
			 */
			private TabsControllerHolder() { }
		}
		
		/**
		 * Get the unique instance of the Controller.
		 * @return The instance of the Controller
		 */
		public static TabsController getInstance() {
			return TabsControllerHolder.INSTANCE;
		}	
		
		/**
		 * Private Constructor.
		 */
		private TabsController() {
			mWebViewList = new ArrayList<SuFragment>();		
		}
		
		/**
		 * Event when a preference has changed. Reinitialize all WebViews, to update them with new preferences.
		 */
//		private void onPreferencesChanged() {
//			for (SuFragment fragment : mWebViewList) {
//				fragment.getWebView().initializeOptions();
//			}
//		}
		
		/**
		 * Initialize the Controller.
		 * @param activity The main activity.
		 * @param touchListener The TouchListener to be set on each created WebView.
		 * @param webViewContainer The main ViewFlipper, containing all the WebView.
		 */
//		public void initialize(MainActivity activity, OnTouchListener touchListener, ViewFlipper webViewContainer) {
		public void initialize(BrowserActivity activity) {
			mMainActivity = activity;		
//			mWebViewsContainer = webViewContainer;
//			mTouchListener = touchListener;
			
			mInflater = (LayoutInflater) mMainActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			
//			mPreferenceChangeListener = new OnSharedPreferenceChangeListener() {

//				@Override
//				public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//					onPreferencesChanged();
//				}			
//			};
			
			PreferenceManager.getDefaultSharedPreferences(mMainActivity).registerOnSharedPreferenceChangeListener(mPreferenceChangeListener);
			
//			try {
//				
//				mWebViewSetEmbeddedTitleBar = WebView.class.getMethod("setEmbeddedTitleBar", new Class[] { View.class });
//				
//			} catch (SecurityException e) {
//				mWebViewSetEmbeddedTitleBar = null;
//				Log.e("TabsController: Unable to get setEmbeddedTitleBar method: SecurityException.", e.getMessage());
//				e.printStackTrace();
//			} catch (NoSuchMethodException e) {
//				mWebViewSetEmbeddedTitleBar = null;
//				Log.e("TabsController: Unable to get setEmbeddedTitleBar method: NoSuchMethodException.", e.getMessage());
//				e.printStackTrace();
//			}
		}
		
		/**
		 * Call the WebView method setEmbeddedTitleBar throught reflection.
		 * @param webView The WebView.
		 * @param view The method parameter.
		 */
//		private void callSetEmbeddedTitleBar(WebView webView, View view) {
//			try {
//				
//				mWebViewSetEmbeddedTitleBar.invoke(webView, view);
//				
//			} catch (IllegalArgumentException e) {
//				Log.e("TabsController: Unable to call setEmbeddedTitleBar method: IllegalArgumentException.", e.getMessage());
//				e.printStackTrace();
//			} catch (IllegalAccessException e) {
//				Log.e("TabsController: Unable to call setEmbeddedTitleBar method: IllegalAccessException.", e.getMessage());
//				e.printStackTrace();
//			} catch (InvocationTargetException e) {
//				Log.e("TabsController: Unable to call setEmbeddedTitleBar method: InvocationTargetException.", e.getMessage());
//				e.printStackTrace();
//			}
//		}
		
		/**
		 * Add a new tab at the given position, and navigate to the given url.
		 * @param position The position to insert the tab.
		 * @param url The url to navigate to.
		 * @return The new tab index.
		 */
		public int addTab(int position, String url) {
			
//			RelativeLayout view = (RelativeLayout) mInflater.inflate(R.layout.webview, mWebViewsContainer, false);
			SuFragment fragment = new SuFragment();
//			final SuWebView webView = (SuWebView) view.findViewById(R.id.webview);
			final WebView webView = fragment.getWebView();
//			View titleBar = mInflater.inflate(R.layout.title_bar, fragment.getView(), false);
//			callSetEmbeddedTitleBar(webView, titleBar);
			
//			final AutoCompleteTextView urlView = (AutoCompleteTextView) titleBar.findViewById(R.id.UrlText);
			
			int insertionIndex = addWebViewContainer(position, fragment);
			
			Bundle args = new Bundle();
			args.putString("url", url);
			fragment.setArguments(args);
			
//			webView.setWebChromeClient(new CustomWebChromeClient(mMainActivity, fragment));
//	        webView.setWebViewClient(new CustomWebViewClient(mMainActivity, fragment));        
//	        webView.setOnTouchListener(mTouchListener);
//	        webView.loadUrl("baidu.com");
	        
//	        webView.setOnCreateContextMenuListener(new OnCreateContextMenuListener() {
//				
//				@Override
//				public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
//					HitTestResult result = ((WebView) v).getHitTestResult();
//					
//					int resultType = result.getType();
//					if ((resultType == HitTestResult.ANCHOR_TYPE) ||
//							(resultType == HitTestResult.IMAGE_ANCHOR_TYPE) ||
//							(resultType == HitTestResult.SRC_ANCHOR_TYPE) ||
//							(resultType == HitTestResult.SRC_IMAGE_ANCHOR_TYPE)) {
//						
//						Intent i = new Intent();
//						i.putExtra(Constants.EXTRA_ID_URL, result.getExtra());
//						
//						MenuItem item = menu.add(0, TAB_CONTEXT_MENU_OPEN, 0, R.string.ContextMenu_Open);
//						item.setIntent(i);
//		
//						item = menu.add(0, TAB_CONTEXT_MENU_OPEN_IN_NEW_TAB, 0, R.string.ContextMenu_OpenInNewTab);					
//						item.setIntent(i);
//						
////						item = menu.add(0, CONTEXT_MENU_COPY, 0, R.string.Main_MenuCopyLinkUrl);					
////						item.setIntent(i);
////						
////						item = menu.add(0, CONTEXT_MENU_DOWNLOAD, 0, R.string.Main_MenuDownload);					
////						item.setIntent(i);										
//					
//						menu.setHeaderTitle(result.getExtra());					
//					}
//				}
//			});
	        
//	        urlView.setOnFocusChangeListener(new OnFocusChangeListener() {
//				
//				@Override
//				public void onFocusChange(View arg0, boolean hasFocus) {
//					// Select all when focus gained.
//	                if (hasFocus) {
//	                	urlView.setSelection(0, urlView.getText().length());
//	                }
//				}
//			});
	        
//	        urlView.setCompoundDrawablePadding(5);
	        
//	        String[] from = new String[] { Browser.BookmarkColumns.TITLE, Browser.BookmarkColumns.URL };
//	        int[] to = new int[] {R.id.AutocompleteTitle, R.id.AutocompleteUrl};
	        
//	        UrlSuggestionCursorAdapter suggestionAdapter = new UrlSuggestionCursorAdapter(mMainActivity, R.layout.url_autocomplete_line, null, from, to);
//	        suggestionAdapter.setCursorToStringConverter(new CursorToStringConverter() {
				
//				@Override
//				public CharSequence convertToString(Cursor cursor) {
//					String aColumnString = cursor.getString(cursor.getColumnIndex(Browser.BookmarkColumns.URL));
//	                return aColumnString;
//				}
//			});
	        
//	        suggestionAdapter.setFilterQueryProvider(new FilterQueryProvider() {
//				
//				@Override
//				public Cursor runQuery(CharSequence constraint) {
//					if ((constraint != null) &&
//							(constraint.length() > 0)) {
//						return BookmarksHistoryController.getInstance().getSuggestion(mMainActivity, constraint.toString());
//					}
//					return null;
//				}
//			});
	        
//	        urlView.setThreshold(1);
//	        urlView.setAdapter(suggestionAdapter);
	        
//	        ImageButton goBtn = (ImageButton) titleBar.findViewById(R.id.GoBtn);
//	        
//	        goBtn.setOnClickListener(new OnClickListener() {
//				
//				@Override
//				public void onClick(View v) {
//					webView.loadUrl(urlView.getText().toString());
//				}
//			});
//	        
//	        if ((url != null) &&
//	        		(url.length() > 0)) {
//	        	webView.loadUrl(url);
//	        }        
//	        
//	        if (position >= 0) {
//	        	mWebViewsContainer.addView(fragment, position);
//	        } else {
//	        	mWebViewsContainer.addView(fragment);
//	        }
	        
	        return insertionIndex;
		}
		
		/**
		 * Remove the tab at the given index.
		 * @param index The index of the tab to remove.
		 */
		public void removeTab(int index) {
			mWebViewList.remove(index);
			mWebViewsContainer.removeViewAt(index);
		}
		
		/**
		 * Get the list of WebViewContainer, e.g. the association of a WebView and its parent layout.
		 * @return The list of WebViewContainer.
		 * @see WebViewContainer
		 */
		public List<SuFragment> getWebViewContainers() {
			return mWebViewList;
		}
		
		/**
		 * Clear the form data on all existants WebView.
		 */
		public void clearFormData() {
			for (SuFragment view : mWebViewList) {
				view.getWebView().clearFormData();
			}
		}
		
		/**
		 * Clear the cache.
		 */
		public void clearCache() {
			if (!mWebViewList.isEmpty()) {
				// Clear cache only need to be done on one WebView. See http://developer.android.com/reference/android/webkit/WebView.html#clearCache%28boolean%29
				mWebViewList.get(0).getWebView().clearCache(true);
			}
		}

		/**
		 * Add the given WebViewContainer at the given position.
		 * @param position The insertion position. Can be < 0. If so, the insertion will be at the end of the list.
		 * @param webViewContainer The WebViewContainer to add.
		 * @return The index of the insertion.
		 * @see WebViewContainer
		 */
		private int addWebViewContainer(int position, SuFragment webViewContainer) {
//			if (position >= 0) {
////			if (position > 0) {
//				mWebViewList.add(position, webViewContainer);
//			} else {
				mWebViewList.add(webViewContainer);
//			}
			
			return mWebViewList.indexOf(webViewContainer);
		}
		
	
	
	
}


