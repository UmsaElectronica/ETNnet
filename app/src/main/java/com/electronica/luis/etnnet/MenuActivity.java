package com.electronica.luis.etnnet;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.electronica.luis.etnnet.R;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

public class MenuActivity extends AppCompatActivity {
    BottomBar mBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);
        final String sem=getIntent().getStringExtra("semestre");
        mBottomBar = BottomBar.attach(this,savedInstanceState);
        mBottomBar.setItemsFromMenu(R.menu.menu_first, new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                if(menuItemId==R.id.exam){
                    examen e=new examen();
                    Bundle args = new Bundle();
                    args.putString("semestre", sem);
                    e.setArguments(args);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,e).commit();
                }
                else if(menuItemId==R.id.clas){
                    clases e=new clases();
                    Bundle args = new Bundle();
                    args.putString("semestre", sem);
                    e.setArguments(args);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,e).commit();
                }
                else if(menuItemId== R.id.var){
                    varios e=new varios();
                    Bundle args = new Bundle();
                    args.putString("semestre", sem);
                    e.setArguments(args);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,e).commit();
                }
                else if(menuItemId==R.id.imagen){
                    imagenes e=new imagenes();
                    Bundle args = new Bundle();
                    args.putString("semestre", sem);
                    e.setArguments(args);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,e).commit();
                }
                else if(menuItemId==R.id.docu){
                    documentos e=new documentos();
                    Bundle args = new Bundle();
                    args.putString("semestre", sem);
                    e.setArguments(args);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,e).commit();
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {

            }
        });
        mBottomBar.mapColorForTab(0,"#0000aa");
        mBottomBar.mapColorForTab(1,"#00aa00");
        mBottomBar.mapColorForTab(2,"#ffaa00");
        mBottomBar.mapColorForTab(3,"#aa0000");
        mBottomBar.mapColorForTab(4,"#992277");



    }

}
