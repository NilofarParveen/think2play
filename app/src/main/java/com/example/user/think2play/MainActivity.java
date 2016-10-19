package com.example.user.think2play;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    public String mytag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        final String[] mobileArray = {"AudioPlayer","Bluetooth","grapes","Papaya"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, mobileArray);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String classname = mobileArray[position];

                        if(position == 0)
                    try{

                        Log.e(mytag, "try");

                        Class ourClass = Class.forName("com.example.user.think2play."+classname);
                        Intent go= new Intent(MainActivity.this,ourClass);
                        startActivity(go);
                    }
                    catch (ClassNotFoundException e)
                    {
                        e.printStackTrace();
                        Log.e(mytag,"exaception");
                    }                if(position == 1)
                    Toast.makeText(getApplicationContext(),"you clicked Orange",Toast.LENGTH_SHORT).show();
                if(position == 2)
                    Toast.makeText(getApplicationContext(),"you clicked Grapes",Toast.LENGTH_SHORT).show();
                if(position == 3)
                    Toast.makeText(getApplicationContext(),"you clicked Papaya",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
