package id.web.luqman.dev.interstitialads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd interstitialAd;
    private Button btnHello;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createInterstitial();

        btnHello = (Button) findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
            }
        });

    }

    public void createInterstitial() {
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("KODE INTERSTITIAL ADS"); // Ganti sesuai dengan kode interstitial ads anda     
        loadInterstitial();
    }

    public void loadInterstitial() {
        AdRequest interstitialRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(interstitialRequest);
    }

    public void showInterstitial() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                  // not call show interstitial ad from here
                }

                @Override
                public void onAdClosed() {
                    loadInterstitial();
                    
                    ////////////////////////////////
                    Intent inte = new Intent(MainActivity.this, Activity2.class);
                    startActivity(inte);
                    ////////////////////////////////
                }
            });
        } else {
            loadInterstitial();
            
            ////////////////////////////////
            Intent inte = new Intent(MainActivity.this, Activity2.class);
            startActivity(inte);
            ////////////////////////////////
        }
    }
}
