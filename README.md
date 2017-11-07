# Membuat Aplikasi Pesan Minuman
## IAK Batch 3 Hari ke 2


##### 1. Buat project baru
1. Pada android studi buatlah sebuah project baru
2. Pada New Project, Lakukan konfigurasi project baru anda seperti Application Name, Company Domain dan Project Location
3. Pada Target Android Devices, pilih minimun sdk misal API 19: Android 4.4 (Kitkat)
4. Pada Add an Activity to Mobile, pilih Empty Layout
5. Pada Customize the Activity, rubah nama activity menjadi "StartActivity" dan nama layout menjadi <i>activity_start</i>
6. Finish

##### 2. Merancang tampilan halaman start
Pada halaman ini nantinya akan menyediakan sebuah view berupa EditText dan ImageView. Jadi nantinya user akan menuliskan nama pada EditText, ketika icon (ImageView) disentuh maka aplikasi akan melakukan proses validasi yaitu jika isian kosong maka akan menampilkan sebuah message berupa Toast tetapi jika sebalikya maka akan berpindah ke activity berikut nya.

Berikut adalah tampilannya :

<div align="center">
![Start Acrtivity](https://raw.githubusercontent.com/herusantoso23/AndroidBeginnerIAK/master/app/src/main/res/drawable/start.png)
</div>

Bagaimana cara membuatnya :

1. Tambahkan sebuah icon dari android studio, caranya pada package res klik kanan lalu pilih new/vector. Lalu pilih salah satu icon yang di inginkan, disini saya akan memilih icon drop down circle.
2. Pada package res/layout, Buka file xml yang bernama <i>activity_start.xml</i>
3. Edit file xml seperti berikut;

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.aragon.herusantoso.iakday2.StartActivity">

    <!-- Membuat view berupa ImageView-->
    <ImageView
        android:id="@+id/arrowImage"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:src="@drawable/ic_arrow_drop_down_circle_blue_24dp"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        />

    <!-- Membuat View berupa Edit Text-->
    <EditText
        android:id="@+id/name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_margin="20dp"
        android:textColor="@color/colorPrimary"
        android:gravity="center"
        android:layout_above="@id/arrowImage"
        android:hint="Tulis nama kamu disini ya ^_^"
        />
</RelativeLayout>

```

##### 2. Merancang tampilan halaman cart

Ketika halaman ini tampil, aplikasi akan menampilkan data yang dikirim dari activity sebelumnya dan aplikasi ini akan menampilkan beberapa menu minuman, disini user bisa memilih menu yang di inginkan, ketika user melakukan check list terhadap menu maka aplikasi akan menghitung secara langsung total harga dari semua pesanan. Dan selanjutnya ketika user melakukan klik tombol order maka akan menampilkan message berupa toast yang berisi konfirmasi jumlah harga.

Berikut adalah tampilannya :

<div align="center">
![](https://raw.githubusercontent.com/herusantoso23/AndroidBeginnerIAK/master/app/src/main/res/drawable/cart.png)
</div>

Bagaimana cara membuatnya :

1. Pada folder java, klik kanan lalu pilih new - activity - empty layout. lalu pada activity name berilah nama <i>CartActivity.java</i> dana pada layout name berilah nama <i>activity_cart.xml</i>
2. Pada package res/layout, Buka file xml yang bernama <i>activity_cart.xml</i>
3. Edit file tersebut seperti berikut;

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:layout_margin="20dp"
    tools:context="com.aragon.herusantoso.iakday2.CartActivity">

    <!--Membuat view berupa TextView,
    view ini nantinya akan menampilkan data yang dikirim dari activity sebelumnya  -->

    <TextView
        android:id="@+id/txt_nama"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hai namamu, Selamat berbelanja."
        android:textSize="18sp"
        />

    <TextView
        android:layout_marginTop="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Minuman"/>

    <!--Membuat 2 buah menu berupa checkbox-->
    <CheckBox
        android:id="@+id/ch_sop"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Sop Buah"
        />

    <CheckBox
        android:id="@+id/ch_jus"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Jus"
        />


    <TextView
        android:layout_marginTop="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Total Harga"
        />

    <!--Membuat view berupa TextView,
    view ini nantinya akan menampilkan jumlah harga dari menu yang dipesa -->
    <TextView
        android:id="@+id/txt_total"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="20dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:textSize="24sp"
        />

    <!--
    Membuat view berupa button,
    view ini nantinya akan menampilkan konfirmasi harga total
    pada saat button tersebut di klik / sentuh
    -->

    <Button
        android:id="@+id/btn_order"
        android:layout_marginTop="40dp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Order"
        android:layout_gravity="center"
        />

</LinearLayout>
```
##### 3. Berpindah dari activity start ke activity cart menggunakan Intent

Apa itu intent?

Intent merupakan suatu pesan yang digunakan untuk mengaktifkan tiga komponen dasar pada aplikasi Android yaitu Activity, Service, dan Broadcast Receiver. 

Bagaimana cara membuatnya ?

1). Pada package java, buka class StartActivity.java

2). Dalam class tersebut deklarisakan 2 buah object berupa EditText dan ImageView.

```java
package com.aragon.herusantoso.iakday2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {
    ImageView arrowImage;
    EditText nameEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

    }
}

```
3). Pada methode onCreate, tambahkan beberpa code seperti berikut untuk merelasikan antara object view pada java dengan xml.

```java
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        arrowImage = (ImageView) findViewById(R.id.arrowImage);
        nameEdit = (EditText) findViewById(R.id.name);

    }
```
4). Berilah sebuah event click, event ini berjalan pada saat user menekan icon/image arrow, berikut code nya :
```java
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        arrowImage = (ImageView) findViewById(R.id.arrowImage);
        nameEdit = (EditText) findViewById(R.id.name);

        arrowImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
```

5). Membuat validasi dengan kondisi jika isi dari EditText kosong maka akan menampilkan sebuah message berupa toast, maka selain itu aplikasi akan berpindah ke activity selanjutnya yaitu Cart Activity

```java
arrowImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (nameEdit.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), 
                    "Maaf, kamu belum memasukan nama kamu ?", 
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(getApplicationContext(), CartActivity.class);
            startActivity(i);
        }
    }
});
```

##### 4. Kirim data dari activity start ke activity cart menggunakan Intent



1). Pada package java, buka class StartActivity.java

2). Tambahkan code berikut untuk melakukan kirim data ke activity selanjutnya.

```java
arrowImage.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (nameEdit.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(),
                    "Maaf, kamu belum memasukan nama kamu ?",
                    Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(getApplicationContext(), CartActivity.class);
            //kirim data
            i.putExtra("name", nameEdit.getText().toString());
            startActivity(i);
        }
    }
});

```

##### 5. Menampilkan data yang diterima dari activity sebelumnya
1). Pada package java, buka class CartActivity.java

2). Deklarasikan terlebih dahulu object view berupa TextView seperti biasa

3). Buatlah satu buah variabel String yang nantinya akan menampung data yang terima 
dari activity sebelumnya. berikut code nya :

```java
package com.aragon.herusantoso.iakday2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtName = (TextView) findViewById(R.id.txt_nama);

		//variabel untuk menampung data yang diterima
		String nama = getIntent().getStringExtra("name");
    }
}
```

4). Menampilkan data tersebut di komponen TextView.

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtName = (TextView) findViewById(R.id.txt_nama);

        //variabel untuk menampung data yang diterima
        String nama = getIntent().getStringExtra("name");

        //melakukan set value TextView
        txtName.setText("Hai " + nama + ", Selamat berbelanja.");
    }
```

##### 6. Membuat perhitungan sederhana
Pada proses ini nantinya setiap menu memiliki harga, dan ketika checkbox menu di pilih, maka akan melakukan jumlah harga









