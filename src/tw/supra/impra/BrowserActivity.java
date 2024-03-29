package tw.supra.impra;

import java.util.ArrayList;

import tw.supra.impra.controllers.TabsController;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.FrameLayout;

public class BrowserActivity extends FragmentActivity {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	ArrayList<String> urls = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TabsController.getInstance().initialize(this);
		setContentView(R.layout.activity_main);
		FrameLayout controlpanel = (FrameLayout) findViewById(R.id.control_panel);
		controlpanel.addView(new ToolBarView(this));
		// Create the adapter that will return a fragment for each of the three
		// primary sections of the app.
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		TabsController.getInstance().addTab(1, "baidu.com");
		mSectionsPagerAdapter.notifyDataSetChanged();
		getActionBar().hide();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
//			 getItem is called to instantiate the fragment for the given page.
//			 Return a DummySectionFragment (defined as a static inner class
//			 below) with the page number as its lone argument.
			 return TabsController.getInstance().getWebViewContainers().get(position);
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return TabsController.getInstance().getWebViewContainers().size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
//			Locale l = Locale.getDefault();
//			switch (position) {
//			case 0:
//				return getString(R.string.title_section1).toUpperCase(l);
//			case 1:
//				return getString(R.string.title_section2).toUpperCase(l);
//			case 2:
//				return getString(R.string.title_section3).toUpperCase(l);
//			}
			return (getString(R.string.title_section) + position);
		}
	}
	
@Override
protected void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	
}

}
