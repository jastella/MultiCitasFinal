package es.fabricaweb.www.multicitas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;

    private Button btnIniciar, btnRegistrarse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_contenedor);

        viewPager = (ViewPager) findViewById(R.id.inicio_contenedor);
        viewPager.setAdapter(new MainPageAdapter());

    }

    class MainPageAdapter extends PagerAdapter {

        private LinearLayout page1;
        private LinearLayout page2;
        private LinearLayout page3;
        private LinearLayout page4;


        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public Object instantiateItem(ViewGroup colletion, int position) {

            View page = null;

            switch (position){

                case 0:
                    if (page1 == null){
                        page1 = (LinearLayout) LayoutInflater.from(MainActivity.this).inflate(R.layout.inicio_presenta1,null);
                    }
                    page=page1;
                    break;

                case 1:
                    if (page2 == null){
                        page2 = (LinearLayout) LayoutInflater.from (MainActivity.this).inflate(R.layout.inicio_presenta2,null);
                    }
                    page=page2;
                    break;

                case 2:
                    if (page3 == null){
                        page3 = (LinearLayout) LayoutInflater.from (MainActivity.this).inflate(R.layout.inicio_login,null);
                        btnIniciar = (Button) page3.findViewById(R.id.button_login);
                        btnRegistrarse = (Button) page3.findViewById(R.id.button_register);

                        btnIniciar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //Toast.makeText(MainActivity.this, "LOGIN", Toast.LENGTH_SHORT).show();

                                Intent i = new Intent(MainActivity.this, ActividadPrincipal.class);
                                startActivity(i);

                            }
                        });
                        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(MainActivity.this, "REGISTER", Toast.LENGTH_SHORT).show();

                                //Intent i = new Intent()

                            }
                        });
                    }
                    page=page3;
                    break;

                default:
                    if (page4 == null){
                        page4 = (LinearLayout) LayoutInflater.from (MainActivity.this).inflate(R.layout.inicio_registro,null);
                    }
                    page=page4;
                    break;
            };

            ((ViewPager) colletion).addView(page,0);

            return page;

        }

        @Override
        public void destroyItem(View collection, int position, Object view) {

            ((ViewPager) collection).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }




}
