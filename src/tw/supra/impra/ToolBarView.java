package tw.supra.impra;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

public class ToolBarView extends FrameLayout {

	public ToolBarView(Context context) {
		super(context);
		View.inflate(getContext(), R.layout.tool_bar, this);
	}
}
