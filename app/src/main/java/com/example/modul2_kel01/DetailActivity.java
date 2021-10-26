package com.example.modul2_kel01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.modul2_kel01.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    private TextView namalengkap;
    private TextView email;
    private ImageView foto;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutActivity();
            }
        });


        email = findViewById(R.id.tv_email);
        foto = findViewById(R.id.img_photo_user2);
        namalengkap = findViewById(R.id.tv_fullname);

        if (getIntent().hasExtra("name")) {

            String namaDepan = getIntent().getStringExtra("name");
            String namaBelakang = getIntent().getStringExtra("lastname");
            namalengkap.setText(namaDepan + " " + namaBelakang);
            String email1 = getIntent().getStringExtra("email");
            email.setText(email1);
            String gambar = getIntent().getStringExtra("foto");
            Glide.with(this).load(gambar).into(foto);
        }

    }
    public void openAboutActivity(){
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
}

