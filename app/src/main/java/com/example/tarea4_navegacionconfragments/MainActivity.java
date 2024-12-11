package com.example.tarea4_navegacionconfragments;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        BottomNavigationView bottomNavigationView= findViewById(R.id.navigationView);
        Menu menu = bottomNavigationView.getMenu();
        menu.add(Menu.NONE,1,Menu.NONE,"Rojo").setIcon(R.drawable.hogar);
        menu.add(Menu.NONE,2,Menu.NONE,"Azul").setIcon(android.R.drawable.ic_menu_my_calendar);
        menu.add(Menu.NONE,3,Menu.NONE,"Verde").setIcon(android.R.drawable.ic_menu_mylocation);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragmento = null;

                switch (item.getItemId()) {
                    case 1:
                        fragmento = new MiFragmento();
                        break;
                    case 2:
                        fragmento = new MiFragmento2();
                        break;
                    case 3:
                        fragmento = new MiFragmento3();
                        break;
                }

                if (fragmento != null) {
                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.fragmentContainerView, fragmento);
                    transaction.commit();
                }
                return true;
            }
        });


        bottomNavigationView.setSelectedItemId(1);
    }
}