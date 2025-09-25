package com.example.mahasiswa_novianty.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;

import com.example.mahasiswa_novianty.R;
import com.example.mahasiswa_novianty.adapter.MahasiswaAdapter;
import com.example.mahasiswa_novianty.db.DbHelper;

import java.util.ArrayList;

public class  ListMahasiswaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> studentsArrayList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);

        recyclerView = findViewById(R.id.rview);
        adapter = new MahasiswaAdapter(this);
        dbHelper = new DbHelper(this);

        studentsArrayList = dbHelper.getAllMahasiswa();
        adapter.setListStudents(studentsArrayList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentsArrayList = dbHelper.getAllMahasiswa();
        adapter.setListStudents(studentsArrayList);
        adapter.notifyDataSetChanged();
    }
}
