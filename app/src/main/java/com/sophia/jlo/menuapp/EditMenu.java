package com.sophia.jlo.menuapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class EditMenu extends AppCompatActivity {
    private EditText mFoodname;
    private EditText mFoodPrice;
    private Button mButton;
    private String mfood;
    private double mprice;
    private MenuDao mMenuDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_menu);
        getDatabase();
        mButton = findViewById(R.id.submiteBtn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFoodname = findViewById(R.id.editTextName);
                mFoodPrice = findViewById(R.id.EditTextPrice);
                mfood = mFoodname.getText().toString();
                mprice = Double.parseDouble(mFoodPrice.getText().toString());
                if(checkFood(mfood)){
                    Menu menu = new Menu(mfood, mprice);
                    mMenuDao.insert(menu);
                }else{
                    Toast.makeText(getApplicationContext(), "Esta en la list", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean checkFood(String food){
        List<Menu> menuList = mMenuDao.getAllMenu();
        for(Menu menu: menuList){
            if(food.trim().equals(menu.getName())){
                return true;
            }
        }
        return false;
    }


    public void getDatabase(){
        mMenuDao = Room.databaseBuilder(this, MenuDatabase.class, MenuDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build().getMenuDao();
    }
}