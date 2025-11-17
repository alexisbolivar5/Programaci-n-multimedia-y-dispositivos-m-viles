package com.example.multiventana2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class nuevoActivity extends AppCompatActivity {
    private Button bDesconectar;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.nuevo_activity);

    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nuevoActivity), (v, insets) -> {
        Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
        return insets;
    });

    setContentView(R.layout.nuevo_activity);
    bDesconectar = findViewById(R.id.bDesconectar);






        bDesconectar.setOnClickListener(view -> {

            Intent intent = new Intent(nuevoActivity.this, MainActivity.class);
            startActivity(intent);

        });

    }
}
