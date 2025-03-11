package com.example.mealmate_demo;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recipeIntent=new Intent(getApplicationContext(),Add_recipe.class);
                startActivity(recipeIntent);
            }
        });


        navigationView=findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.home_menu:
                        Toast.makeText(MainActivity.this, "Click to Home Items", Toast.LENGTH_SHORT).show();
                        Intent homeIntent=new Intent(getApplicationContext(),Home.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.about_menu:
                        Toast.makeText(MainActivity.this, "Click to Home Items", Toast.LENGTH_SHORT).show();
                        Intent aboutIntent=new Intent(getApplicationContext(),About.class);
                        startActivity(aboutIntent);
                        break;
                    case R.id.week_menu:
                        Toast.makeText(MainActivity.this, "Click to Home Items", Toast.LENGTH_SHORT).show();
                        Intent weekIntent=new Intent(getApplicationContext(),Home.class);
                        startActivity(weekIntent);
                        break;
                    case R.id.recipe_menu:
                        Toast.makeText(MainActivity.this, "Click to Home Items", Toast.LENGTH_SHORT).show();
                        Intent recipeIntent=new Intent(getApplicationContext(),Home.class);
                        startActivity(recipeIntent);
                        break;
                }
                return false;
            }
        });
        final DrawerLayout drawerLayout=findViewById(R.id.main);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }
}