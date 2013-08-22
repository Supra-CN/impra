package tw.supra.impra;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class ActionBarCustomView extends FrameLayout {

	public ActionBarCustomView(Context context) {
		super(context);
		View.inflate(getContext(), R.layout.title_bar, this);
	}
}
