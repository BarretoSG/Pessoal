package com.example.valentinesday;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.Toast;
import android.app.AlertDialog;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static final String TARGET_DATE = "2016-09-23";
    private DatePicker datePicker;
    private Button loginButton;
    private TextView errorMessage;
    private ScrollView mainContent;
    private View loginContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();
        setupClickListeners();
    }

    private void initializeViews() {
        datePicker = findViewById(R.id.datePicker);
        loginButton = findViewById(R.id.loginButton);
        errorMessage = findViewById(R.id.errorMessage);
        mainContent = findViewById(R.id.mainContent);
        loginContainer = findViewById(R.id.loginContainer);
    }

    private void setupClickListeners() {
        loginButton.setOnClickListener(v -> checkDate());

        findViewById(R.id.valeJantar).setOnClickListener(v -> 
            showValeAlert("Vale 1 jantar romântico à luz de velas 🍷"));
        
        findViewById(R.id.valeCinema).setOnClickListener(v -> 
            showValeAlert("Vale uma maratona de filmes com pipoca 🎬"));
        
        findViewById(R.id.valeMassagem).setOnClickListener(v -> 
            showValeAlert("Vale uma massagem relaxante 💆‍♂️"));
    }

    private void checkDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth());
        
        String selectedDate = String.format("%d-%02d-%02d", 
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH));

        if (TARGET_DATE.equals(selectedDate)) {
            loginContainer.setVisibility(View.GONE);
            mainContent.setVisibility(View.VISIBLE);
        } else {
            errorMessage.setVisibility(View.VISIBLE);
            Toast.makeText(this, "Data incorreta. Tente novamente! ❤️", 
                Toast.LENGTH_SHORT).show();
        }
    }

    private void showValeAlert(String message) {
        new AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK", null)
            .show();
    }
}