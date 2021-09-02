package com.example.dinerestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class food extends AppCompatActivity {
 private Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        order=findViewById(R.id.f);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(food.this,ordered.class);
                startActivity(intent);
            }
        });

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
            Intent i =new Intent(food.this, help.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.logout){
            Toast.makeText(this,"Logged Out!",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(food.this, MainActivity.class);
            startActivity(i);
        }
        else{   return super.onOptionsItemSelected(item);}
        return true;
    }
}