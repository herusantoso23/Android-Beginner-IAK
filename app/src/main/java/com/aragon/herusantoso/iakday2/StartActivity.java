package com.aragon.herusantoso.iakday2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {
    ImageView arrowImage;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        arrowImage = (ImageView) findViewById(R.id.arrowImage);
        nameEdit = (EditText) findViewById(R.id.name);

        arrowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameEdit.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Maaf, kamu belum memasukan nama kamu ?", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(getApplicationContext(), CartActivity.class);
                    i.putExtra("name", nameEdit.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}
