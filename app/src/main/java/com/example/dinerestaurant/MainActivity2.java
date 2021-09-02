package com.example.dinerestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (item.getItemId() == R.id.settings){
            Toast.makeText(this,"Help Clicked.",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity2.this, help.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.logout){
            Toast.makeText(this,"Logged Out!",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(MainActivity2.this, MainActivity.class);
            startActivity(i);
        }
        else{   return super.onOptionsItemSelected(item);}
        return true;
    }
}