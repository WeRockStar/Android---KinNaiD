package cs.xml.kinnaid;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FoodList extends ListActivity {

	ArrayList<String> xmlList = new ArrayList<String>();

	Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);

		try {
			InputStream is = getResources().openRawResource(R.raw.restaurant);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(is, null);
			NodeList nodes = doc.getElementsByTagName("Restaurant");
			if (nodes != null && nodes.getLength() > 0) {
				xmlList.clear();
				int len = nodes.getLength();
				for (int i = 0; i < len; ++i) {
					// query value
					Node node = nodes.item(i);
					xmlList.add(node.getTextContent());
				}
			}
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, xmlList);
			setListAdapter(adapter);

		} catch (Throwable t) {
			Toast.makeText(this, "Exception :" + t.toString(),
					Toast.LENGTH_LONG).show();
		}
		i = new Intent(FoodList.this, SearchMap.class);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		i.putExtra("list", ""+position);

		startActivity(i);
		overridePendingTransition(android.R.anim.fade_in,
				android.R.anim.fade_out);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.shortView:
			Intent i = new Intent(FoodList.this, KinNaiD.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			finish();
			break;
		case R.id.popular:
			i = new Intent(FoodList.this , Popular.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in,
					android.R.anim.fade_out);
			finish();
			break;

		
		}
		return super.onOptionsItemSelected(item);
	}

}
