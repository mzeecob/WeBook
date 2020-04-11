package com.example.bookapplr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.bookapplr.Adapter.TitleAdapter;
import com.example.bookapplr.Interface.TitleClickListener;
import com.example.bookapplr.Model.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Context mcontex;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mcontex = MainActivity.this;
        titleList = new ArrayList<>();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mcontex, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        TitleAdapter titleAdapter = new TitleAdapter(mcontex, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("titles", titleList.get(position));     // pass the book title on the next detail screen --- passed along data
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(titleAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_share) Toast.makeText(MainActivity.this, "share clicked", Toast.LENGTH_SHORT).show();
        if (id == R.id.menu_about) Toast.makeText(MainActivity.this, "about clicked", Toast.LENGTH_SHORT).show();
        if (id == R.id.menu_exit) finish();

        return super.onOptionsItemSelected(item);
    }
}
