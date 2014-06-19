package com.example.co.codewizards.cloudstore.droid11;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class TestActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		doTest();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_test, container,
					false);
			return rootView;
		}
	}

	private void doTest() {
		// Before the secondary dex file can be processed by the DexClassLoader,
		// it has to be first copied from asset resource to a storage location.
		if (true)
			return;

		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		System.out.println(">>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<>>>>>>-----<<<<<<");
		
		
		final String traceFilePath = new File(getDir("trace", MODE_WORLD_READABLE), "trace").getAbsolutePath();
		System.out.println("TRACE: " + traceFilePath);
		Debug.startMethodTracing(traceFilePath);
		final ClassLoader defaultClassLoader = TestActivity.class.getClassLoader();
		
		final ClassLoader dataNucleusClassLoader = new AssetClassLoader(getApplicationContext(), new String[] {
			"co.codewizards.android.datanucleus.core.dex-4.0.0-m2.jar",
			"co.codewizards.android.datanucleus.rdbms.dex-4.0.0-m2.jar",
			"co.codewizards.android.datanucleus.jdo.dex-4.0.0-m2.jar"
		}, defaultClassLoader);

		Thread.currentThread().setContextClassLoader(dataNucleusClassLoader);

		final Properties persistenceProperties = new Properties();
		try {
			InputStream in = getAssets().open("test-persistence.properties");
			persistenceProperties.load(in);
			in.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		SQLiteDatabase db = getApplicationContext().openOrCreateDatabase("testDB", Context.MODE_PRIVATE, null);
		String databasePath = db.getPath();
		db.close();
		persistenceProperties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:sqldroid:" + databasePath);
//		persistenceProperties.setProperty("javax.jdo.option.ConnectionURL", "jdbc:sqlite:" + databasePath);

//		try {
//			Class<?> implClass = Class.forName("org.datanucleus.api.jdo.JDOPersistenceManagerFactory", true, Thread.currentThread().getContextClassLoader());
//            Method m = implClass.getMethod("getPersistenceManagerFactory", Map.class, Map.class);
//            PersistenceManagerFactory pmf = 
//                (PersistenceManagerFactory) m.invoke(
//                    null, new Object[]{new HashMap<>(), persistenceProperties});
//
//			System.out.println("*********************************************************************");
//			System.out.println(pmf);
//			System.out.println("*********************************************************************");
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}

		final PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory(persistenceProperties, Thread.currentThread().getContextClassLoader());
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");

//		Runtime.getRuntime().traceMethodCalls(true);
		
		final PersistenceManager pm = pmf.getPersistenceManager();
		System.out.println("*************************************************************************************");
//		pm.getExtent(LocalRepository.class);
		
		
		pm.close();
		pmf.close();
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
		System.out.println("*************************************************************************************");
	}

}
