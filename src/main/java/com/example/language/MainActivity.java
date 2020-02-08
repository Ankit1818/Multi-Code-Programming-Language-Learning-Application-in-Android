package com.example.language;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.myadapater2.Model;
import com.example.myadapater2.MyAdapter;
import com.example.openclass.Background;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    SliderLayout sliderLayout;
    HashMap<String,String>hashMap;
    Toolbar toolbar;
    RecyclerView recyclerView;
    ArrayList<Model> al;
    AdView adView;
    InterstitialAd mInterstitialAd;
    String text[]={"C","C++","JAVA","HTML","CSS","JAVA SCRIPT","PYTHON","R_LANGUAGE","SWIFT","PHP","CCS","RUBBY"};
    String image[]={

            "https://hirendudhat.000webhostapp.com/cardimage/c__1_.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/c.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/java.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/html_5.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/css_3.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/java_script.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/python.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/download.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/swift.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/php.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/0_wnnokyi4gwfnxxqp.jpg",
            "https://hirendudhat.000webhostapp.com/cardimage/ruby.jpg",};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderLayout = findViewById(R.id.s1);
        hashMap = new HashMap<>();
        toolbar=findViewById(R.id.tool);
        setSupportActionBar(toolbar);
        recyclerView=findViewById(R.id.recycler);
        al=new ArrayList<>();

        mInterstitialAd = new InterstitialAd(MainActivity.this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1933566840368745/6717996910");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener()

                                      {
                                          @Override
                                          public void onAdClosed() {
                                              super.onAdClosed();

                                              startActivity(new Intent());

                                          }
                                      }

        );

       MobileAds.initialize(this,"\n" + "ca-app-pub-1933566840368745~9015829529");
       adView = findViewById(R.id.adView);
       AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);

        hashMap.put("C++","https://hirendudhat.000webhostapp.com/image/c%20PROGRAMMING-min.jpg");
        hashMap.put("JAVA","https://hirendudhat.000webhostapp.com/image/java-min.jpg");
        hashMap.put("HTML","https://hirendudhat.000webhostapp.com/image/HTML-min.jpg");
        hashMap.put("C#","https://hirendudhat.000webhostapp.com/image/Css-min.jpg");
        hashMap.put("CSS","https://hirendudhat.000webhostapp.com/image/CSS-min.jpg");
        hashMap.put("JAVA SCRIPT","https://hirendudhat.000webhostapp.com/image/JAVASCRIPT-min.jpg");
        hashMap.put("PYTHON","https://hirendudhat.000webhostapp.com/image/python-min.jpg");
        hashMap.put("R programing","https://hirendudhat.000webhostapp.com/image/R-min.jpg");
        hashMap.put("RUBY","https://hirendudhat.000webhostapp.com/image/RUBY-min.jpg");
        hashMap.put("SWIFT","https://hirendudhat.000webhostapp.com/image/SWIFT-min.jpeg");

        for (String name:hashMap.keySet())
        {
            TextSliderView textSliderView = new TextSliderView(MainActivity.this);
            textSliderView
                    .description(name)

                    .image(hashMap.get(name));

            sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
            sliderLayout.addSlider(textSliderView);
            sliderLayout.setDuration(4000);
        }

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        for(int i = 0; i<image.length; i++)
        {
            Model m =new Model(image[i],text[i]);
            al.add(m);

            MyAdapter adapter=new MyAdapter(getApplicationContext(),al);
            recyclerView.setAdapter(adapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.i1:
                Toast.makeText(this, "Log out of your account", Toast.LENGTH_SHORT).show();
               Background bb=new Background(getApplicationContext());
               bb.removeuser();
               Intent intent=new Intent(MainActivity.this,Loginscreen.class);
               startActivity(intent);
               finishAffinity();
                break;

            case R.id.i2:
                Intent intent1=new Intent(MainActivity.this,compiler.class);
                startActivity(intent1);
                Toast.makeText(this, "compiler", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed()
    {
        if(mInterstitialAd.isLoaded())
        {
            mInterstitialAd.show();
            finishAffinity();
        }
        else
        {

        }
        super.onBackPressed();
    }

}
