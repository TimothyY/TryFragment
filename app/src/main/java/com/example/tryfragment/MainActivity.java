package com.example.tryfragment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
implements UpperFragment.OnUpperFragmentInteractionListener{

    UpperFragment upperFragment;
    LowerFragment lowerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this, ThirdActivity.class));

        //cek apakah masing2 container sudah terisi
        if(findViewById(R.id.upperContainer)!=null){

            // kalau di restore dari state sebelumnya
            // jangan lakukan apapun untuk menghindari
            // overlapping fragment
            if(savedInstanceState!=null){
                return;
            }

            //buat fragment yang mau dipasang
            upperFragment = new UpperFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.upperContainer,upperFragment)
                    .commit();

        }

        if(findViewById(R.id.lowerContainer)!=null){
            if(savedInstanceState!=null)return;

            lowerFragment = new LowerFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.lowerContainer,lowerFragment).commit();
        }

    }


    @Override
    public void onUpperFragmentInteraction(String result) {
        if(lowerFragment!=null)
            lowerFragment.updateResult(result);
    }
}
