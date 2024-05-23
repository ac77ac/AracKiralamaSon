package com.example.arackiralama;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;

public class CustomAdapter extends BaseAdapter {
    private Context context;

    public CustomAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 1; // 10 tane ImageButton olacak & 1 kez döndürecek
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_with_button, parent, false);
        }

        // ImageButton bileşenlerini tanımla
        ImageButton imageButton1=convertView.findViewById(R.id.imageButton74);
        ImageButton imageButton2=convertView.findViewById(R.id.imageButton75);
        ImageButton imageButton3=convertView.findViewById(R.id.imageButton76);
        ImageButton imageButton4=convertView.findViewById(R.id.imageButton77);
        ImageButton imageButton5=convertView.findViewById(R.id.imageButton78);
        ImageButton imageButton6=convertView.findViewById(R.id.imageButton79);
        ImageButton imageButton7=convertView.findViewById(R.id.imageButton80);
        ImageButton imageButton8=convertView.findViewById(R.id.imageButton81);
        ImageButton imageButton9=convertView.findViewById(R.id.imageButton82);
        ImageButton imageButton10=convertView.findViewById(R.id.imageButton83);

        if(i20satinalim.visibellel){
            imageButton1.setVisibility(View.VISIBLE);}
        if(egeasatinalim.visibellel2){
            imageButton2.setVisibility(View.VISIBLE);}
        if(corollasatinalim.visibellel3){
            imageButton3.setVisibility(View.VISIBLE);}
        if(meganesatinalim.visibellel4){
            imageButton4.setVisibility(View.VISIBLE);}
        if(astrasatinalim.visibellel5){
            imageButton5.setVisibility(View.VISIBLE);}
        if(scalasatinalim.visibellel6){
            imageButton6.setVisibility(View.VISIBLE);}
        if(focussatinalim.visibellel7){
            imageButton7.setVisibility(View.VISIBLE);}
        if(chrsatinalim.visibellel8){
            imageButton8.setVisibility(View.VISIBLE);}
        if(bmw216dsatinalim.visibellel9){
            imageButton9.setVisibility(View.VISIBLE);}
        if(mercedeseqesatinalim.visibellel10){
            imageButton10.setVisibility(View.VISIBLE);}



        return convertView;
    }
}