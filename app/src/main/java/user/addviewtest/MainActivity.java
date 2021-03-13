package user.addviewtest;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar.LayoutParams;
import android.view.View.OnClickListener;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    Bitmap bmp;
    ImageView imgPhoto;
    //int[] imgId = { R.mipmap.img01, R.mipmap.img02, R.mipmap.img03,
           // R.mipmap.img04, R.mipmap.img05, R.mipmap.img06};
    //int count = imgId.length; // 共有多少張圖片


   //int btn_number=0;

    String[] Assfile = null;
    AssetManager assets = null;
    int AssfileSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearMain);
        imgPhoto = (ImageView) findViewById(R.id.imageView);


        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);


        //imgPhoto.setImageBitmap(getBitmapFromAssets("map/img02.jpg"));



        try {
            //獲取assets的物件
            assets = getAssets();
            Assfile = assets.list("map");
            AssfileSize = Assfile.length; //檔案數

            Toast.makeText(this, String.valueOf(AssfileSize) , Toast.LENGTH_SHORT).show();//2

        } catch (Exception e) {
            e.printStackTrace();
        }



        for(int j=1;j<=4;j++)
        {
            // Create LinearLayout
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            // Create TextView
            //TextView product = new TextView(this);
            //product.setText(" Product"+j+"  ");
            //ll.addView(product);



            // Create Button
            final Button btn = new Button(this);

            // Give button an ID
            btn.setId(j+1);
            btn.setText("第"+j+"樓");

            // set the layoutParams on the button
            btn.setLayoutParams(params);

            final int index = j;

            // Set click listener for button
            btn.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    Log.i("TAG", "index :" + index);
                    Toast.makeText(getApplicationContext(),
                            "Clicked Button Index :" + index,
                            Toast.LENGTH_LONG).show();
                    switch (index) {
                        case 1:
                             bmp = getImageFromAssetsFile("/assets/map/1F.jpg");
                            break;
                        case 2:
                            bmp = getImageFromAssetsFile("/assets/map/2F.jpg");
                            break;
                        case 3:
                            bmp = getImageFromAssetsFile("/assets/map/3F.jpg");
                            break;
                        case 4:
                            bmp = getImageFromAssetsFile("/assets/map/4F.jpg");
                            break;
                        case 5:
                            bmp = getImageFromAssetsFile("/assets/map/5F.jpg");
                            break;
                        case 6:
                            bmp = getImageFromAssetsFile("/assets/map/6F.jpg");
                            break;
                        //case .........
                    }


                    imgPhoto.setImageBitmap(bmp);
                }

            });

            //Add button to LinearLayout
            ll.addView(btn);

            //Add button to LinearLayout defined in XML
            lm.addView(ll);

        }



    }

    private Bitmap getImageFromAssetsFile(String fileName)
    {
        Bitmap image = null;
        try
        {
            InputStream is = getClass().getResourceAsStream(fileName);
            image = BitmapFactory.decodeStream(is);
            is.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return image;
    }
    //讀取Assets資料夾圖片，型態為Bitmap
    /*private Bitmap getBitmapFromAssets(String file)
    {
        try
        {
            AssetManager am = getAssets();
            InputStream is = am.open(file);
            return bitmap;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }*/
}
