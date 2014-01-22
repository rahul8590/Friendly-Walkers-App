package com.example.walkerapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.io.OutputStream;
import edu.umass.cs.msocket.multicast.MSocketGroupWriter;


public class WriteActivity extends Activity {

	private Button send_msg_btn;
	private EditText etxtNum1;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.member_writer);
        etxtNum1 = (EditText)findViewById(R.id.editText1);
        send_msg_btn = (Button)findViewById(R.id.send_button);
        send_msg_btn.setOnClickListener(send_msg);
	}
	
    private OnClickListener send_msg = new OnClickListener(){
    	String writerName = "rahul8590";
		String attr = "dept";
		String value = "cs";
		
    	@Override
		public void onClick(View v) {
    		String msg = etxtNum1.getText().toString();
    		try {
    			MSocketGroupWriter groupWriter =  new MSocketGroupWriter(writerName);
    			groupWriter.connect("color:blue"); //Working 
    			OutputStream gout = groupWriter.getOutputStream();
    			for (int i=0; i<10 ; i++) {
    				gout.write(msg.getBytes());
    				Log.d("WriteActivity", "Message Sent");
    				Thread.sleep(2000);
    			}
    		} catch (Exception e) {
    			Log.d("WriteActivity", "MSocket Writer got Screwed");
    		}
    		
    	}
    };

	
	
}
