package com.sophia.jlo.menuapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ViewMenu extends AppCompatActivity {
    private List<Menu> menuList;
    private TextView textViewResult;
    private MenuDatabase mMenuDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_menu);
        menuList = mMenuDB.getMenuDao().getAllMenu();
        textViewResult = findViewById(R.id.textView);

        int i=1;
        for(Menu menu: menuList){
            textViewResult.append(String.valueOf(i));
            textViewResult.append("\n\n");
            textViewResult.append(menu.toString());
            i++;
        }


    }
}
