package jp.ac.chiba_fjb.a.test1011;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

//import java.nio.file.Paths;
import twitter4j.StatusUpdate;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Status;
import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tweetBtn = (Button) findViewById(R.id.button1);
        tweetBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"つぶやく内容");
                intent.setType("text/plain");
                startActivity(intent);
//                //投稿ボタンを押してキーがなければキー取得・ある場合投稿画面
//                if (!Twitter_Util.serchAccessToken()) {
//                    Log.v("MainActivity", "start oauth");
//                    Intent intent = new Intent(getActivity(),OauthActivity.class);
//                    startActivity(intent);
//                } else {
//                    send = new TwitterSend(getActivity());
//                    send.execute(cnt, shopName.getText().toString() + "\n"
//                            + twtext.getText().toString(), dir.getPath() + "/"
//                            + CameraFragment.PICPATH);
//                }

            }
        });



    }
}
