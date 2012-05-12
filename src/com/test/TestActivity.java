package com.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TestActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	private int x;
	private FORTUNE f;
	@Override
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        x=0;
      ImageButton button = (ImageButton)findViewById(R.id.btnRun);
        button.setOnClickListener(this);
        f=new FORTUNE();
    }

	public void onClick(View arg0) {
		if (arg0==findViewById(R.id.btnRun)){
		TextView text = (TextView)findViewById(R.id.txtOut);
		text.setText(f.get()+" : "+Integer.toString(x));
		x++;}
		
	}
}
