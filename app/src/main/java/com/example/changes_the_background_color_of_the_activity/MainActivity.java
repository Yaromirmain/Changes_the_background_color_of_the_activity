package com.example.changes_the_background_color_of_the_activity;

import static com.example.changes_the_background_color_of_the_activity.R.id.change_background_button;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Random random = new Random(); // Объект для генерации случайных чисел

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Применяем отступы окна
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Находим кнопку и устанавливаем ей обработчик
        Button changeBackgroundButton = findViewById(change_background_button);
        changeBackgroundButton.setOnClickListener(this::changeBackground);
    }

    // Метод для изменения фона
    public void changeBackground(View v) {
        View mainLayout = findViewById(R.id.main);
        // Получаем случайный цвет
        int randomColor = getRandomColor();
        mainLayout.setBackgroundColor(randomColor); // Устанавливаем случайный цвет фона
    }

    // Метод для получения случайного цвета
    private int getRandomColor() {
        // Генерируем случайный цвет в формате ARGB
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
}
