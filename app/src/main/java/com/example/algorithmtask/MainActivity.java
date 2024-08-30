package com.example.algorithmtask;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int GRID_SIZE = 10;
    private final int[][] numbers = new int[GRID_SIZE][GRID_SIZE];
    private GridView gridView;
    private NumberAdapter adapter;

    private Button btnOdd, btnEven, btnPrime, btnFibonacci;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        btnOdd = findViewById(R.id.btnOdd);
        btnEven = findViewById(R.id.btnEven);
        btnPrime = findViewById(R.id.btnPrime);
        btnFibonacci = findViewById(R.id.btnFibonacci);
        btnOdd.setOnClickListener(this);
        btnEven.setOnClickListener(this);
        btnPrime.setOnClickListener(this);
        btnFibonacci.setOnClickListener(this);


        int count = 1;
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                numbers[i][j] = count++;
            }
        }

        adapter = new NumberAdapter(this, numbers);
        gridView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnOdd){
            adapter.highlightNumbers(NumberType.ODD);
        }
        if (v.getId() == R.id.btnEven){
            adapter.highlightNumbers(NumberType.EVEN);
        }
        if (v.getId() == R.id.btnPrime){
            adapter.highlightNumbers(NumberType.PRIME);
        }
        if (v.getId() == R.id.btnFibonacci){
            adapter.highlightNumbers(NumberType.FIBONACCI);
        }

    }
}