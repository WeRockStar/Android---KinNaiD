package cs.xml.kinnaid;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.google.android.gms.internal.ka;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class Popular extends ListActivity {
	ArrayList<String> xmlList = new ArrayList<String>();

	Intent i;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		

		try {
			InputStream is = getResources().openRawResource(R.raw.popular);
			DocumentBuilder builder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = builder.parse(is, null);
			NodeList nodes = doc.getElementsByTagName("Restaurant");
			if (nodes != null && nodes.getLength() > 0) {
				xmlList.clear();
				int len = nodes.getLength();
				for (int i = 0; i < len; ++i) {
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
			i = new Intent(Popular.this , KinNaiD.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			finish();
			break;
		case R.id.search:
			i = new Intent(Popular.this , FoodList.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			finish();
			break;

		default:
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
