package ro.ase.ro.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("tag: onCreate","Am ajuns in onCreate()");
        Toast.makeText(this, "Am ajuns in onCreate", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("tag: on Resume","Am ajuns in onResume()");
        Toast.makeText(this, "Am pus pauza", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("tag: onStart","Am ajuns in onStart()");
        Toast.makeText(this, "Am portnit aplicatia", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("tag: onSTOP","Am ajuns in onSTOP()");
        Toast.makeText(this, "Am oprit aplicatia", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("tag: onSTOP","Am ajuns in onRestart()");
        Toast.makeText(this, "Am restartat aplicatia", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("tag: onPause","Am ajuns in pauza");
        Toast.makeText(this, "Am pus pauza aplicatiei", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("tag: onSTOP","Am ajuns in onDestroy");
        Toast.makeText(this, "Am distrus aplicatai", Toast.LENGTH_SHORT).show();
    }
}