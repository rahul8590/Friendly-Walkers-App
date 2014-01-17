package com.example.walkerapp;

import edu.umass.cs.gns.client.DesktopGnsClient;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ResultActivity extends Activity {

	public static final String BUNDLE_RESULT = "gnsid";
	private TextView txtAnswer;
	
	private float Answer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("ResultActivity","Result Activity Launched");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);

		txtAnswer = (TextView)findViewById(R.id.txtResult);
		Bundle myBundle = getIntent().getExtras();

		String accountId = myBundle.getString(ResultActivity.BUNDLE_RESULT);
		//String result = myBundle.getString("gnsid");
		//txtAnswer.setText(accountId);
		String host = "gns.name";
		int port = 8080;
		 
		DesktopGnsClient client = new DesktopGnsClient(host, port);
	    Log.d("Client connected to GNS at " + host + ":",host);
		
	    try {
	    	String guid = client.lookupGuid("rahul8590@gmail.com");
	    	txtAnswer.setText("Retrieved GUID for " + guid);
	    	 
	    }
	    catch (Exception e) {
	    	txtAnswer.setText("Unable to retrieve guid or account doesnt exist");
	    	Log.d("error" + e ,"error");
	    }
	   
	    
	    /*float number1 = myBundle.getInt("n1");
		float number2 = myBundle.getInt("n2");
		int operation = myBundle.getInt("opp");
		if(operation==1)
		Answer = (number1 + number2);
		else if(operation==2)
		Answer = (number1 - number2);
		else if(operation==3)
		Answer = (number1 * number2);
		else 
		Answer = (number1 / number2);
		*/
		//String answerStr = Float.toString(Answer);
	//	Log.d("AnswerCalculated","Answer: "+ answerStr);
	//			txtAnswer.setText(answerStr);
	//	Log.d("ResultActivity","Answer Printed to Screen");
		
	}
}
