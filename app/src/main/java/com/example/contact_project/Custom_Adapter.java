package com.example.contact_project;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Custom_Adapter extends BaseAdapter {
    Context context;
private  int res;
    public Custom_Adapter(Context context, ArrayList<User> list,int res) {
        this.context = context;
        this.list = list;
        this.res=res;
    }

    ArrayList<User>list;
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v=view;
        if(v==null){
            v= LayoutInflater.from(context).inflate(res,null,false);
        }

        TextView name_text=v.findViewById(R.id.user_name);
        TextView number_text=v.findViewById(R.id.number);
        ImageButton img_btn=v.findViewById(R.id.imageButton);
        name_text.setText(list.get(i).getName());
        img_btn.setImageResource(R.drawable.baseline_phone_24);
        number_text.setText(list.get(i).getNumber());
        ImageView imageView=v.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.image);
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+list.get(i).getNumber())); // Replace with your phone number
                context.startActivity(callIntent);
            }
        });
        return v;
    }
}
