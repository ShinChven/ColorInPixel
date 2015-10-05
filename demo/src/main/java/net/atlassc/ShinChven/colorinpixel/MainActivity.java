package net.atlassc.ShinChven.colorinpixel;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import net.atlassc.ShinChven.colorinpixel.util.BitmapTool;
import net.atlassc.ShinChven.colorinpixel.util.ToastUtil;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements OnClickListener {


    private static final int SELECT_IMAGE = 92;
    private ImageView mPreview;
    private TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPreview = (ImageView) findViewById(R.id.preview);

        mResult = ((TextView) findViewById(R.id.result));

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
        if (id == R.id.action_readme) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("说明");
            builder.setMessage(R.string.action_readme_text);
            builder.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            builder.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.select_image) {
            Intent intt = new Intent(Intent.ACTION_GET_CONTENT);
            intt.setType("image/*");
            startActivityForResult(Intent.createChooser(intt, "Select your image from..."), SELECT_IMAGE);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE) {
            if (resultCode == RESULT_OK) {
                Uri uri;
                try {
                    uri = data.getData();
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastUtil.toastShortly(this, "没得选择任何图片。");
                    return;
                }
                if (data != null && uri != null) {
                    try {
                        Bitmap resized = BitmapTool.resize(this, uri, 1000, 1000);
                        mPreview.setImageBitmap(resized);
                        new PixelCheckTask().execute(resized);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }

    public class PixelCheckTask extends AsyncTask {

        private ProgressDialog mProgress;
        int totalInRange = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgress = new ProgressDialog(MainActivity.this);
            mProgress.setMessage("正在检查图片……");
            mProgress.setCancelable(false);
            mProgress.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            Bitmap image = (Bitmap) params[0];
            int color = getResources().getColor(R.color.target);

            for (int i = 0; i < image.getWidth(); ) {
                for (int j = 0; j < image.getHeight(); ) {
                    try {
                        int pixel = image.getPixel(i, j);
                        int alpha = Color.alpha(pixel);
                        int red = Color.red(pixel);
                        int green = Color.green(pixel);
                        int blue = Color.blue(pixel);
                        Log.i("range", "a:" + alpha + " r:" + red + " g:" + green + " b:" + blue);

                        if (isInRage(Color.red(color), red) && isInRage(Color.green(color), green) && isInRage(Color.blue
                                (color), blue)) {
                            totalInRange++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    j += 2;

                }
                i += 2;
            }

            Log.i("range", "total in range: " + totalInRange);

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            try {
                mProgress.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mResult.setText("一共找到：" + totalInRange + "个像素");

            super.onPostExecute(o);
        }
    }


    public static final int RANGE = 30;

    public boolean isInRage(int target, int src) {
        return src <= target + RANGE && src >= target - RANGE;
    }
}
