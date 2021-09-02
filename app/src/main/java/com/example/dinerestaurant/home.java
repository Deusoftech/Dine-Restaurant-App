package com.example.dinerestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {
    private ImageView gfood;
    private ImageView drink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        gfood = (ImageView) findViewById(R.id.Food);
        drink = findViewById(R.id.dri);

        drink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, drinks.class);
                startActivity(intent);
            }
        });
        gfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this, food.class);
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
            Intent i =new Intent(home.this, help.class);
            startActivity(i);
        }
        else if(item.getItemId() == R.id.logout){
            Toast.makeText(this,"Logged Out!",Toast.LENGTH_SHORT).show();
            Intent i =new Intent(home.this, MainActivity.class);
            startActivity(i);
        }
        else{   return super.onOptionsItemSelected(item);}
        return true;
    }
}