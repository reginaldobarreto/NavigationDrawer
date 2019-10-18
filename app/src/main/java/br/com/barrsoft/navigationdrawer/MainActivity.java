package br.com.barrsoft.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;
    @BindView(R.id.navigationView)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){

                    case R.id.menu_inbox:
                        Toast.makeText(getApplicationContext(), R.string.inbox, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_sent:
                        Toast.makeText(getApplicationContext(), R.string.sent, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_spam:
                        Toast.makeText(getApplicationContext(), R.string.spam, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_trash:
                        Toast.makeText(getApplicationContext(), R.string.trash, Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_favorite:
                        Toast.makeText(getApplicationContext(), R.string.favorites, Toast.LENGTH_LONG).show();
                        break;
                    default:
                        return false;

                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }


    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }
}
