package com.example.gproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;

public class nakigi_saying extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nakigi_saying);

        String[] str = {};
        readExcel(str);
        TextView saying = findViewById(R.id.saying);

        int r = (int)(Math.random()*61);
//        saying.setText(str[r]);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    public void readExcel(String[] str) {
        try{
            InputStream is = getBaseContext().getResources().getAssets().open("saying.xls");

            Workbook wb = Workbook.getWorkbook(is);

            if(wb!=null){
                Sheet sheet = wb.getSheet(0);
                if(sheet!=null){
                    int colTotal = sheet.getColumns();
                    int rowIndexStart = 1;
                    int rowTotal = sheet.getColumn(colTotal-1).length;

                    StringBuilder sb;
                    for(int row=rowIndexStart; row<rowTotal; row++){
                        sb=new StringBuilder();

                        for(int col=0; col<colTotal; col++)
                        {
                            String contents = sheet.getCell(col,row).getContents();

                            str[col]=contents;
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}