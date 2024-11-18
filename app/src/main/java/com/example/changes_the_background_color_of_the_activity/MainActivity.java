package com.example.changes_the_background_color_of_the_activity;
//MainActivity принадлежит пакету com.example.changes_the_background_color_of_the_activity

import static com.example.changes_the_background_color_of_the_activity.R.id.change_background_button;
//Эта строчка импортирует идентификатор кнопки change_background_button из файла ресурсов R
//Позволяет использовать без указания пути к кнопке
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//Импорт библиотек: Импортируются необходимые классы:
//        Color для работы с цветами.
//        Bundle для передачи данных между компонентами приложения.
//        View для работы с элементами пользовательского интерфейса (UI).
//        Button для создания кнопок.
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;
//импорт класс Random для случайных чисел
public class MainActivity extends AppCompatActivity {
    //Объявляется класс MainActivity, который наследует от AppCompatActivity

    private Random random = new Random(); // Объект для генерации случайных чисел

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // этот метод служит для иницилизации пользовательского интерфейса и других компонентов
        super.onCreate(savedInstanceState); //Вызов метода родителя
        EdgeToEdge.enable(this); //Включение режима "край в край"
        //включает режим отображения
        setContentView(R.layout.activity_main); //Установка макета активности из activity_main.xml

        // Применяем отступы окна
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            //чтобы корректно обрабатывать отступы
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            //Получение отступов системных панелей
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets; //Возврат импортированных отступов
        });

        // Находим кнопку и устанавливаем ей обработчик
        Button changeBackgroundButton = findViewById(change_background_button);
        //Поиск кнопки по идентификатору
        changeBackgroundButton.setOnClickListener(this::changeBackground);
        //Установка обработчика клика
        //Когда пользователь нажимает на кнопку, вызывается метод changeBackground
    }

    // Метод для изменения фона
    public void changeBackground(View v) { //Метод изменения фона
        View mainLayout = findViewById(R.id.main);
        //Поиск основного макета. Находит основной макет приложения.

        // Получаем случайный цвет
        int randomColor = getRandomColor();
        mainLayout.setBackgroundColor(randomColor); // Устанавливаем случайный цвет фона
    }

    // Метод для получения случайного цвета
    private int getRandomColor() {
        // Генерируем случайный цвет в формате ARGB
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        //ARGB() используется в выражениях для установки или оценки свойств цвета объекта
        //диаграммы, где цвет определяется красным r, зеленым g и синим b компонентами
        //с коэфф ициентом alpha (прозрачность) alpha. Значение прозрачности в диапазоне 0–255.
    }
}
