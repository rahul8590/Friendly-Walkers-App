package com.example.walkerapp;

//import edu.umass.cs.gns.client.DesktopGnsClient;
import edu.umass.cs.gns.client.android.AndroidGnsClient;
import edu.umass.cs.gns.geodesy.GlobalPosition;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;


class MyLocationListener implements LocationListener {  
	  
    public static double latitude;  
    public static double longitude;  
  
    @Override  
    public void onLocationChanged(Location loc)  
    {  
        loc.getLatitude();  
        loc.getLongitude();  
        latitude=loc.getLatitude();  
        longitude=loc.getLongitude();  
    }  
  
    @Override  
    public void onProviderDisabled(String provider)  
    {  
        //print "Currently GPS is Disabled";  
    }  
    @Override  
    public void onProviderEnabled(String provider)  
    {  
        //print "GPS got Enabled";  
    }  
    @Override  
    public void onStatusChanged(String provider, int status, Bundle extras)  
    {  
    }  
}










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
		String host = "ananas.cs.umass.edu";
		int port = 8080;
		String ftext ;
		
	    try {
//	    	String result = new loadguid().execute("rahul8590@gmail.com").get();
	    	AndroidGnsClient client = new AndroidGnsClient(host, port);
		    Log.d("Client connected to GNS at " + host + ":",host);
		    String guid = client.lookupGuid(accountId);
		    LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		    MyLocationListener mloc = new MyLocationListener();
		    
		    if(lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
		    	String provider = LocationManager.GPS_PROVIDER;
		    	lm.requestLocationUpdates(provider, 0, 0, mloc); 
		    	//Location loc = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		    	double lat = MyLocationListener.latitude;
		    	double log = MyLocationListener.longitude;
		    	ftext = String.valueOf(lat) + String.valueOf(log);
		    	
		    } else {
		    	// Alert to enable GPS in phone
		    	ftext = "GPS is disabled";
		    }
		    /* Get current location and set long and lat
		    client.setLocation(longitude, latitude, guid)
		    */
		    txtAnswer.setText(guid + ftext);
	    } catch (Exception e) {
	    	Log.d("asynch task is scrwed up", "unable to fetch data");
	    	txtAnswer.setText("bad account");
	    }	    	
	}
	
	/*public class loadguid extends AsyncTask <String, Integer, String> {
		@Override
		protected String doInBackground(String...paramas){
			try {
				return guid;
			} catch (Exception e) {
		    	//txtAnswer.setText("Unable to retrieve guid or account doesnt exist");
		    	Log.d("error" + e ,"error");
		    	return "Unable to fetch";
		    }
		}
	}*/
}
