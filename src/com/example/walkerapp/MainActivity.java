package com.example.walkerapp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import edu.umass.cs.gns.client.DesktopGnsClient;

public class MainActivity extends Activity {

	private EditText etxtNum1;
	//private EditText etxtNum2;
	//private TextView txtAnswer;
	private Button btnAddition;
	//private Button btnSubtraction;
	//private Button btnMultiplication;
	//private Button btnDivision;


	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        etxtNum1 = (EditText)findViewById(R.id.etxtNum1);
        //etxtNum2 = (EditText)findViewById(R.id.etxtNum2);
     //   txtAnswer = (TextView)findViewById(R.id.txtAnswer);
        btnAddition = (Button)findViewById(R.id.btnAddition);
        //btnSubtraction = (Button)findViewById(R.id.btnSubtraction);
        //btnMultiplication = (Button)findViewById(R.id.btnMultiplication);
        //btnDivision = (Button)findViewById(R.id.btnDivision);
        
        btnAddition.setOnClickListener(addition);
//        btnSubtraction.setOnClickListener(subtraction);
 //       btnDivision.setOnClickListener(division);
   //     btnMultiplication.setOnClickListener(multiplication);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private OnClickListener addition = new OnClickListener(){

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String gnsid = etxtNum1.getText().toString();
			Log.d("ResultActivity", "value");
			//String number2 = etxtNum2.getText().toString();
			
			 String host = "ananas.cs.umass.edu";
			 int port = 8080;

			DesktopGnsClient client = new DesktopGnsClient(host, port);
		    Log.d("Client connected to GNS at " + host + ":",host);

			//int n1 = Integer.parseInt(number1);
			//int n2 = Integer.parseInt(number2);
			
			//Integer answer = n1 + n2;
			
			//String answerStr = answer.toString();
			
			//txtAnswer.setText(answerStr);
			
			Intent myIntent = new Intent(getApplicationContext(),ResultActivity.class);
			Bundle myBundle = new Bundle();
			myBundle.putString("gnsid", gnsid);
			
			//myBundle.putInt("n2", n2);
			//myBundle.putString(ResultActivity.BUNDLE_RESULT,answerStr);
			//myBundle.putInt("opp", 1);
			myIntent.putExtras(myBundle);
			
			Log.d("MainActivity","Starting Result Activity");
			
			startActivity(myIntent);
		}
};

}
