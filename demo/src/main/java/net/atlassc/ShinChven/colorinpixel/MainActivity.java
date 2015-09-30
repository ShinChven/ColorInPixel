package net.atlassc.ShinChven.colorinpixel;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
    public void onClick(View v) {
        final ProgressDialog progress = new ProgressDialog(this);
        progress.show();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Bitmap bitmap = BitmapFactory.decodeFile("/storage/emulated/0/Download/a.jpg");
                    int color = getResources().getColor(R.color.target);
                    int totalInRange = 0;
                    for (int i = 0; i < bitmap.getWidth(); i++) {
                        for (int j = 0; j < bitmap.getHeight(); j++) {
                            int pixel = bitmap.getPixel(i, j);
                            int alpha = Color.alpha(pixel);
                            int red = Color.red(pixel);
                            int green = Color.green(pixel);
                            int blue = Color.blue(pixel);
                            Log.i("range", "a:" + alpha + " r:" + red + " g:" + green + " b:" + blue);

                            if (isInRage(Color.red(color),red)&&isInRage(Color.green(color),green)&&isInRage(Color.blue
                                    (color),blue)) {
                                totalInRange++;
                            }

                        }
                    }

                    Log.i("range", "total in range: "+totalInRange);


                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    progress.dismiss();
                }


            }
        }).run();


    }


    public static final int RANGE = 30;

    public boolean isInRage(int target, int src) {
        return src <= target + RANGE && src >= target - RANGE;
    }
}
