package app.example.juancarlos.com.pruebaactivitys;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    Button btn;
    Button btn2;
    private MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnAdelnte);
        btn.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.btnSigue);
        btn2.setOnClickListener(this);
        mp = MediaPlayer.create(this, R.raw.pinpong);
        mp.start();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if(mp.isPlaying())
        {
            mp.stop();
            mp.release();
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mp.start();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mp.pause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnAdelnte:

                break;
            case R.id.btnSigue:
                Intent in = new Intent(MainActivity.this, activityP2.class);
                startActivity(in);
                break;

        }
    }
}
