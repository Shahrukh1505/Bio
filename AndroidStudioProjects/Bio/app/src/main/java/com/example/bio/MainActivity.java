package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bio.data.Bio;
import com.example.bio.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
private EditText enterHobbies;
private TextView hobbies;
private final Bio bio = new Bio();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        enterHobbies = findViewById(R.id.hobbies);
//        hobbies = findViewById(R.id.hobbiesText);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
   bio.setName("Shahrukh Ansari");

   binding.setBio(bio);
        binding.done.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           addHobbies(v);
       }
   });
    }

    public void addHobbies(View view) {
        bio.setHobbies("Hobbies: %s" + binding.hobbies.getText().toString().trim());
//        binding.hobbiesText.setText("Hobbies: %s" + binding.hobbies.getText().toString().trim());
//binding.hobbies.setVisibility(View.VISIBLE);
binding.invalidateAll();
//        hobbies.setText("Hobbies: %s" + enterHobbies.getText().toString().trim());
//hobbies.setVisibility(View.VISIBLE);

//hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(),0);
    }
}