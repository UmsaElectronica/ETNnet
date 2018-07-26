package com.electronica.luis.etnnet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.electronica.luis.etnnet.R;

public class HomeActivity extends Activity {
    private ImageButton ibtn1,ibtn2,ibtn3,ibtn4,ibtn5,ibtn6;
    private ImageButton ibtn7,ibtn8,ibtn9,ibtn10,ibtn11,ibtn12;
    private ImageButton ibtntodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        ibtn1=(ImageButton)findViewById(R.id.imageButton1);
        ibtn2=(ImageButton)findViewById(R.id.imageButton2);
        ibtn3=(ImageButton)findViewById(R.id.imageButton3);
        ibtn4=(ImageButton)findViewById(R.id.imageButton4);
        ibtn5=(ImageButton)findViewById(R.id.imageButton5);
        ibtn6=(ImageButton)findViewById(R.id.imageButton6);
        ibtn7=(ImageButton)findViewById(R.id.imageButton7);
        ibtn8=(ImageButton)findViewById(R.id.imageButton8);
        ibtn9=(ImageButton)findViewById(R.id.imageButton9);
        ibtn10=(ImageButton)findViewById(R.id.imageButton10);
        ibtn11=(ImageButton)findViewById(R.id.imageButton11);
        ibtn12=(ImageButton)findViewById(R.id.imageButton12);
        ibtntodos=(ImageButton)findViewById(R.id.ibtntodos);


        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","1");
                startActivity(a);

            }
        });
        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","2");
                startActivity(a);

            }
        });
        ibtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","3");
                startActivity(a);

            }
        });
        ibtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","4");
                startActivity(a);

            }
        });
        ibtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","5");
                startActivity(a);

            }
        });
        ibtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","6");
                startActivity(a);

            }
        });
        ibtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","7");
                startActivity(a);

            }
        });
        ibtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","8");
                startActivity(a);

            }
        });
        ibtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","9");
                startActivity(a);

            }
        });
        ibtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","10");
                startActivity(a);

            }
        });
        ibtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","11");
                startActivity(a);

            }
        });
        ibtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","12");
                startActivity(a);

            }
        });
        ibtntodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(HomeActivity.this,MenuActivity.class);
                a.putExtra("semestre","a");
                startActivity(a);

            }
        });
    }
}
