package com.example.cardview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] title = {"Vada Pav",
                "Aloo gobi",
                "Aloo tikki",
                "Aloo matar",
                "Aloo methi",
                "Aloo shimla mirch"
        };
        String[] text = {"Vada pav, alternatively spelt vada pao, wada pav, or wada pao, is a vegetarian fast food dish native to the state of Maharashtra.",
                "Cauliflower with potatoes sautéed with garam masala, turmeric, sometimes kalonji and curry leaves.",
                "Patties of potato mixed with some vegetables fried",
                "Potatoes and peas in curry",
                "Potato with fresh Methi leaves.",
                "Green capsicum with potatoes sautéed with cumin seeds, onions, tomatoes, ginger-garlic paste, turmeric, red chilli powder and garam masala"
        };
        String[] uri = {"https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Aloo_gobi.jpg/180px-Aloo_gobi.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Aloo_gobi.jpg/180px-Aloo_gobi.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d1/Aloo_Tikki_served_with_chutneys.jpg/180px-Aloo_Tikki_served_with_chutneys.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4f/Aloo_Mattar.jpg/180px-Aloo_Mattar.jpg",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Aloo_Methi_%28Aaloo_Methi%29.JPG/180px-Aloo_Methi_%28Aaloo_Methi%29.JPG",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Spicy_alloo_with_tadka_mirchi.jpg/180px-Spicy_alloo_with_tadka_mirchi.jpg"
        };
        RecyclerView r=(RecyclerView)findViewById(R.id.Recycler);
        r.setAdapter(new Recycler(title,text,getApplicationContext(),uri));
        r.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}