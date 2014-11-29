package com.pdark007.incufidez;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;

public class SplashActivity extends Activity {
    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 3000; // 3 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Tenemos una plantilla llamada activity_splash.xml donde mostraremos la información que queramos (logotipo, etc.)
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable(){
            public void run(){
                // Cuando pasen los 3 segundos, pasamos a la actividad principal de la aplicación
                Intent intent = new Intent(SplashActivity.this, MyActivity.class);
                startActivity(intent);
                finish();
            };
        }, DURACION_SPLASH);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
