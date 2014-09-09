package com.example.jbautista.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ryx.notes.Settings;

public class ListEvents extends ActionBarActivity implements AdapterView.OnItemClickListener{
String[] events;
ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_events);
        events = new String[]{"Christmas", "New Year"};
        listView = (ListView)findViewById(R.id.listEventsListView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ListEvents.this, android.R.layout.simple_expandable_list_item_1, events);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(ListEvents.this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_events_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(ListEvents.this, Settings.class);
            startActivity(intent);
        }
        if (id == R.id.calendar) {
            Intent intent = new Intent(ListEvents.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(ListEvents.this, events[position], Toast.LENGTH_SHORT).show();
        Log.i("onItemClick", events[position]);
    }
}
