package com.example.practicerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    ArrayList<Contact> contactArrayList;
    ContactAdapter contactAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        contactArrayList = Contact.getMockData();

        contactAdapter = new ContactAdapter(MainActivity.this, contactArrayList, MainActivity.this);

        recyclerView.setAdapter(contactAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    public void setOnUserCallClick(Contact contact) {
        Toast.makeText(MainActivity.this, "Welcome", Toast.LENGTH_SHORT).show();
    }
}