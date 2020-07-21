package com.thoughtworks.fragmentpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AndroidFragment androidFragment = new AndroidFragment();
        final JavaFragment javaFragment = new JavaFragment();
        showFragment(androidFragment);
        final View androidBtn = findViewById(R.id.android);
        final View javaBtn = findViewById(R.id.java);
        changeButtonStyle(androidBtn, javaBtn);
        androidBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(androidFragment);
                changeButtonStyle(androidBtn, javaBtn);
            }
        });
        javaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFragment(javaFragment);
                changeButtonStyle(javaBtn, androidBtn);
            }
        });
    }

    public void showFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            fragmentTransaction.replace(R.id.frame_layout, fragment)
                    .commit();
        }
    }

    private void changeButtonStyle(View clickedButton, View unClickButton) {
        clickedButton.setBackgroundResource(R.drawable.button_clicked_style);
        unClickButton.setBackgroundResource(R.drawable.button_unclick_style);

    }
}