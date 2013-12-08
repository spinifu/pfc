package com.example.androidtestproject;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {
	
	private transient Document document;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 final byte[] buffer = new byte[11];
	        try {
	            final ByteArrayInputStream stream =
	                new ByteArrayInputStream(buffer);
	            final InputSource source = new InputSource(stream);

		final DocumentBuilderFactory factory =
		                DocumentBuilderFactory.newInstance();
		        factory.setNamespaceAware(true);

		        // Configure the factory to ignore comments
		        factory.setIgnoringComments(true);
		        final DocumentBuilder builder = factory.newDocumentBuilder();
		        final EntityResolver resolver = new IgnoringEntityResolver();
		        boolean resolveEntities =
		            Boolean.getBoolean("org.jvoicexml.xml.resolveEntities");
		        if (!resolveEntities) {
		            builder.setEntityResolver(resolver);
		        }
		        document = builder.parse(source);
	        } catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        finally
	        {
	        	Log.e("asdf","i did it");
	        }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
