package com.example.odstest5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView cList;
    ContentResolver contentResolver;
    Cursor cursor;
    ContactModel contactModel;
    ContactAdapter contactAdapter;
    List<ContactModel> contactModelList=new ArrayList<>();


   /* ArrayList<String> arrayList=new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cList=findViewById(R.id.contactList);


        findViewById(R.id.loadContacts).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)!= PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_CONTACTS},101);
                }
                else
                {
                    readAllContacts();

                }


            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case 101:
                if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
                {
                    readAllContacts();
                }
                else
                {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private void readAllContacts() {
        contentResolver=getContentResolver();
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI; //Uniform Resource identifiers
        String[] projections={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER,
                ContactsContract.CommonDataKinds.Photo.PHOTO_URI};
        String selection=null; //Selection for row wise Search
        String[] args=null;
        String order= ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" asc";

        cursor=contentResolver.query(uri,projections,selection,args,order);

        if(cursor.getCount()>0&&cursor!=null)
        {
            while (cursor.moveToNext())
            {
                @SuppressLint("Range") String name=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                @SuppressLint("Range") String number=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                @SuppressLint("Range") String photo=cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Photo.PHOTO_URI));
               // Log.d("IMAGE",""+photo);

                contactModel=new ContactModel(name,number,photo);
                contactModelList.add(contactModel);

                contactAdapter=new ContactAdapter(getApplicationContext(),contactModelList);
                cList.setAdapter(contactAdapter);

                /*arrayList.add(""+name+"\n"+number);
                arrayAdapter=new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,arrayList);
                cList.setAdapter(arrayAdapter);*/

            }

        }
        else
        {
            Toast.makeText(this, "No Contacts Found in  Your Device", Toast.LENGTH_SHORT).show();
        }


    }
}