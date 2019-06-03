package com.example.homework2_list;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.homework2_list.items.ItemListContent;

public class AddItemActivity extends AppCompatActivity {

    private String itemPicPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        itemPicPath = "";
    }

    public void setImgPicPath (String val){
        itemPicPath = val;
    }

    public void PicTakenCancelled (){
        Intent data = new Intent();
        setResult(RESULT_CANCELED, data);
        finish();
    }

    public void addClick(View view) {
        Intent data = new Intent();

        EditText itemCarEditTxt = findViewById(R.id.ItemAddCar);
        EditText itemColorEditTxt = findViewById(R.id.ItemAddColor);
        EditText itemSpecificationEditTxt = findViewById(R.id.ItemAddSpecification);
        String itemCar = itemCarEditTxt.getText().toString();
        String itemColor = itemColorEditTxt.getText().toString();
        String itemSpecification = itemSpecificationEditTxt.getText().toString();

        //default values
        if(itemCar.isEmpty())
            itemCar =getString(R.string.car);
        if(itemColor.isEmpty())
            itemColor = getString(R.string.color);
        if(itemSpecification.isEmpty())
            itemSpecification = getString(R.string.specification);


        ItemListContent.addItem(new ItemListContent.Item("Item." + ItemListContent.ITEMS.size() +1,
                itemCar,
                itemColor,
                itemSpecification,
                itemPicPath));

        itemCarEditTxt.setText("");
        itemColorEditTxt.setText("");
        itemSpecificationEditTxt.setText("");

        //hide keyboard
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        setResult(RESULT_OK, data);
        finish();
    }
}
