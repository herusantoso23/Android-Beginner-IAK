# Membuat Aplikasi Pesan Minuman
## IAK Batch 3 Hari ke 2


##### 1. Buat project baru
1. Pada android studi buatlah sebuah project baru
2. Pada New Project, Lakukan konfigurasi project baru anda seperti Application Name, Company Domain dan Project Location
3. Pada Target Android Devices, pilih minimun sdk misal API 19: Android 4.4 (Kitkat)
4. Pada Add an Activity to Mobile, pilih Empty Layout
5. Pada Customize the Activity, rubah nama activity menjadi "StartActivity" dan nama layout menjadi <i>activity_start</i>
6. Finish

##### 2. Merancang layout untuk tampilan halaman start
Pada halaman ini nantinya akan menyediakan sebuah view berupa EditText dan ImageView. Jadi nantinya user akan menuliskan nama pada EditText jika isian kosong maka akan menampilkan sebuah message berupa Toast tetapi jika sebalikya maka akan berpindah ke activity berikut nya.

1. Tambahkan sebuah icon arrow (panah) dari android studio, caranya pada package res klik kanan lalu pilih new/vector
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

    <ImageView
        android:id="@+id/arrowImage"
        android:layout_width="40dp"
        android:layout_height="40dp"
        android:src="@drawable/ic_arrow_forward_black_24dp"
        android:layout_centerHorizontal="true"
        android:layout_centerVertical="true"
        />

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



