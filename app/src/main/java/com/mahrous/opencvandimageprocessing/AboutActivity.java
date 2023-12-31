package com.mahrous.opencvandimageprocessing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    private LinearLayout mFbImg, mEmImg, mLink;
    private TextView appVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        mFbImg = findViewById(R.id.mFb);
        mEmImg = findViewById(R.id.mEm);
        mLink  = findViewById(R.id.mLink);
        appVersion = findViewById(R.id.app_version);

        appVersion.setText("1.0");

        //Mouaz about set links
        mFbImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.facebook.com/MahrousElhawy"));
                    startActivity(i); } catch (Exception e){
                    Toast.makeText(getBaseContext(), "The link is broken", Toast.LENGTH_SHORT).show();                }
            }
        });

        mLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("https://www.linkedin.com/in/MahrousElhawy/"));
                    startActivity(i); } catch (Exception e){
                    Toast.makeText(getBaseContext(), "The link is broken", Toast.LENGTH_SHORT).show();                }
            }
        });

        mEmImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("message/rfc822");
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_EMAIL  , new String[]{"Mahrous.alhawy@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Namaz Vakitleri App Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, " ......... ");
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(Intent.createChooser(intent, "Send mail..."));
                }
            }
        });






    }
}