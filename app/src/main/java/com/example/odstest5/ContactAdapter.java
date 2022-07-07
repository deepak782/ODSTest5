package com.example.odstest5;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {
    Context context;
    List<ContactModel> contactModelList=new ArrayList<>();
    LayoutInflater layoutInflater;

    public ContactAdapter(Context context, List<ContactModel> contactModelList) {
        this.context = context;
        this.contactModelList = contactModelList;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return contactModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View root=layoutInflater.inflate(R.layout.custom_contacts,null);

        ShapeableImageView shapeableImageView=root.findViewById(R.id.contact_image);
        TextView name=root.findViewById(R.id.contact_name);
        TextView number=root.findViewById(R.id.contact_number);

        name.setText(contactModelList.get(i).getName());
        number.setText(contactModelList.get(i).getNumber());

        if(contactModelList.get(i).getImage()!=null)
        {
            shapeableImageView.setImageURI(Uri.parse(""+contactModelList.get(i).getImage()));

        }
        else

        {
            Log.i("null",""+contactModelList.get(i).getImage());

        }
        return root;
    }
}
