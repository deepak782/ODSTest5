package com.example.odstest5;

import android.net.Uri;

public class ContactModel {

    String name,number,image;
    Uri imageUri;

    public ContactModel(String name, String number, Uri imageUri) {
        this.name = name;
        this.number = number;
        this.imageUri = imageUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public ContactModel(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public ContactModel(String name, String number, String image) {
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ContactModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
