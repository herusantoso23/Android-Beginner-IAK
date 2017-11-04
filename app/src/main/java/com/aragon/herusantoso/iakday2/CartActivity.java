package com.aragon.herusantoso.iakday2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class CartActivity extends AppCompatActivity {
    TextView txtNama;
    TextView txtTotal;
    CheckBox chSopBuah;
    CheckBox chJus;

    Button btnOrder;

    int hargaJus = 10000, hargaSop = 12000, jumlah = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtNama = (TextView) findViewById(R.id.txt_nama);
        txtTotal = (TextView) findViewById(R.id.txt_total);
        chSopBuah = (CheckBox) findViewById(R.id.ch_sop);
        chJus = (CheckBox) findViewById(R.id.ch_jus);
        btnOrder = (Button) findViewById(R.id.btn_order);

        String nama = getIntent().getStringExtra("name");

        txtNama.setText("Hai " + nama + ", Selamat berbelanja.");

        chSopBuah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chSopBuah.isChecked() == true){
                    jumlah = jumlah + hargaSop;
                    txtTotal.setText("Rp. " + jumlah);
                } else if (chSopBuah.isChecked() == false) {
                    jumlah = jumlah - hargaSop;
                    txtTotal.setText("Rp. " + jumlah);
                }
            }
        });

        chJus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chJus.isChecked() == true){
                    jumlah = jumlah + hargaJus;
                    txtTotal.setText("Rp. " + jumlah);
                } else if (chJus.isChecked() == false) {
                    jumlah = jumlah - hargaJus;
                    txtTotal.setText("Rp. " + jumlah);
                }
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Jumlah tagihan " + jumlah + ", Terimakasih telah membeli",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
