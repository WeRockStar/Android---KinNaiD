package cs.xml.kinnaid;

import org.w3c.dom.ls.LSInput;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SearchMap extends Activity {

	private GoogleMap map;
	static final LatLng KKU = new LatLng(16.465332, 102.820229);
	static final LatLng JobCake = new LatLng(16.486343, 102.816256);
	static final LatLng BeToSit = new LatLng(16.4849824, 102.8173547);
	static final LatLng TBone = new LatLng(16.4795695, 102.8072188);
	static final LatLng Cottage = new LatLng(16.4275067, 102.8280476);
	static final LatLng BanMo = new LatLng(16.4829239, 102.8191237);
	static final LatLng Adam = new LatLng(16.4575015, 102.8243915);
	static final LatLng Sri = new LatLng(16.4603986, 102.8275084);
	static final LatLng IAUN = new LatLng(16.4887543, 102.8154173);
	static final LatLng DerLa = new LatLng(16.4364049, 102.8302716);
	static final LatLng Peace = new LatLng(16.480829, 102.815236);
	static final LatLng Meme = new LatLng(16.4817856, 102.8163327);
	static final LatLng KaiRod = new LatLng(16.4577617, 102.8280187);
	static final LatLng Hear = new LatLng(16.4557411, 102.7846869);
	static final LatLng AmazonKKU = new LatLng(16.4796095, 102.8165292);
	static final LatLng SeeBear = new LatLng(16.4798186, 102.8148726);
	static final LatLng Chidchol = new LatLng(16.4599575, 102.8290272);
	static final LatLng MooDang = new LatLng(16.4799842, 102.8154679);
	static final LatLng Complex = new LatLng(16.477664, 102.823046);
	static final LatLng Follow = new LatLng(16.4854654, 102.8171189);
	static final LatLng YiWha = new LatLng(16.4851955, 102.8170178);

	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

		MapFragment mapFragment = (MapFragment) getFragmentManager()
				.findFragmentById(R.id.map);
		map = mapFragment.getMap();

		Intent i = getIntent();
		String list = i.getStringExtra("list");

		CameraPos(list);
	}

	void CameraPos(String list) {
		CameraPosition camera = new CameraPosition.Builder().target(KKU)
				.zoom(15).bearing(0).tilt(0).build();
		Marker mark;

		Marker markKKU = mark = map.addMarker(new MarkerOptions().position(KKU)
				.title("Khon Kaen University").snippet("Education"));
		markKKU.showInfoWindow();

		if (list.equals("0")) {
			camera = new CameraPosition.Builder().target(JobCake).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(JobCake)
					.title("Job Cake").snippet("Cake / Milk and coffee"));
			mark.showInfoWindow();
		} else if (list.equals("1")) {
			camera = new CameraPosition.Builder().target(BeToSit).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(BeToSit)
					.title("Be-To-Sit Pub And Restaurant")
					.snippet("Food and Drink"));
			mark.showInfoWindow();
		} else if (list.equals("2")) {
			camera = new CameraPosition.Builder().target(TBone).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(TBone)
					.title("T-Bone Steak").snippet("Steak and Food"));
			mark.showInfoWindow();
		} else if (list.equals("3")) {
			camera = new CameraPosition.Builder().target(Cottage).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Cottage)
					.title("The Cottage and Home gastro pub")
					.snippet("Food and Drink"));
			mark.showInfoWindow();
		} else if (list.equals("4")) {
			camera = new CameraPosition.Builder().target(BanMo).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(BanMo)
					.title("Ban more  Bakery and Coffee")
					.snippet("Food/Cake/Coffee/Milk"));
			mark.showInfoWindow();
		} else if (list.equals("5")) {
			camera = new CameraPosition.Builder().target(Adam).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Adam)
					.title("Adam and Eve Cafe").snippet("Coffee and Milk"));
			mark.showInfoWindow();
		} else if (list.equals("6")) {
			camera = new CameraPosition.Builder().target(Sri).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Sri)
					.title("Sri Brown Cafe' Khon Kaen")
					.snippet("Coffee and Milk"));
			mark.showInfoWindow();
		} else if (list.equals("7")) {
			camera = new CameraPosition.Builder().target(IAUN).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(IAUN)
					.title("Ban IAUN").snippet("Coffee and Milk"));
			mark.showInfoWindow();
		} else if (list.equals("8")) {
			camera = new CameraPosition.Builder().target(DerLa).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(DerLa)
					.title("Coffee Der La,").snippet("Coffee"));
			mark.showInfoWindow();
		} else if (list.equals("9")) {
			camera = new CameraPosition.Builder().target(Peace).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Peace)
					.title("Peace Time").snippet("Food/Coffee/Milk"));
			mark.showInfoWindow();
		} else if (list.equals("10")) {
			camera = new CameraPosition.Builder().target(Meme).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Meme)
					.title("Meme House").snippet("Coffee and Milk"));
			mark.showInfoWindow();
		} else if (list.equals("11")) {
			camera = new CameraPosition.Builder().target(KaiRod).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(KaiRod)
					.title("Kai rod tip").snippet("Coffee and Milk"));
			mark.showInfoWindow();
		} else if (list.equals("12")) {
			camera = new CameraPosition.Builder().target(Hear).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Hear)
					.title("Hear Heal").snippet("Food"));
			mark.showInfoWindow();
		} else if (list.equals("13")) {
			camera = new CameraPosition.Builder().target(AmazonKKU).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(AmazonKKU)
					.title("Cafe Amazon KKU").snippet("Coffee"));
			mark.showInfoWindow();
		} else if (list.equals("14")) {
			camera = new CameraPosition.Builder().target(SeeBear).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(SeeBear)
					.title("See Bear Cafe").snippet("Cake/Coffee/Milk"));
			mark.showInfoWindow();
		} else if (list.equals("15")) {
			camera = new CameraPosition.Builder().target(Chidchol).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Chidchol)
					.title("Chidchol").snippet("Food"));
			mark.showInfoWindow();
		} else if (list.equals("16")) {
			camera = new CameraPosition.Builder().target(MooDang).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(MooDang)
					.title("555 MooDang").snippet("Food"));
			mark.showInfoWindow();
		} else if (list.equals("17")) {
			camera = new CameraPosition.Builder().target(Complex).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Complex)
					.title("Complex KKU").snippet("Food and Service"));
			mark.showInfoWindow();
		} else if (list.equals("18")) {
			camera = new CameraPosition.Builder().target(Follow).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(Follow)
					.title("Follow Bar and Bistro").snippet("Food and Drink"));
			mark.showInfoWindow();
		} else if (list.equals("19")) {
			camera = new CameraPosition.Builder().target(YiWha).zoom(12)
					.bearing(0).tilt(0).build();
			map.moveCamera(CameraUpdateFactory.newCameraPosition(camera));

			mark = map.addMarker(new MarkerOptions().position(YiWha)
					.title("YiWha").snippet("Food and Drink"));
			mark.showInfoWindow();
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent i = new Intent(SearchMap.this, FoodList.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.shortView:
			i = new Intent(SearchMap.this , KinNaiD.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			finish();
			break;
		case R.id.popular:
			i = new Intent(SearchMap.this , Popular.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			finish();
			break;
			
		case R.id.search:
			i= new Intent(SearchMap.this , FoodList.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			break;
		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
		
	}
}
