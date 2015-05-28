package com.example.rescue.pornapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by teddy on 2015/5/20.
 */
public class PhoneNumberAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    String [] Name;
    String [] Number;
    private Context FragmentContext;
    //建構子
    public  PhoneNumberAdapter (Context FragmentContext, String[] Name, String [] Number){
        inflater = LayoutInflater.from(FragmentContext);
        this.Name = Name;
        this.Number = Number;
        this.FragmentContext = FragmentContext;
    }
    @Override
    public int getCount() {
        return Name.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //利用view去設定我們自訂的layout
        view = inflater.inflate(R.layout.phonenumber_listview,viewGroup,false);
        TextView NameText,NumberText;
        NameText = (TextView) view.findViewById(R.id.textView4);
        NumberText = (TextView) view.findViewById(R.id.textView3);
        NameText.setText(Name[i]);
        NumberText.setText(Number[i]);
        //設置監聽
        view.setOnClickListener(new OnClickListener(Name[i],Number[i]) {});
        return view;
    }
    class OnClickListener implements View.OnClickListener{
        private String Name;
        private String Number;
       //利用建構子取得內容
        public OnClickListener(String Name,String Number){
            this.Name = Name;
            this.Number = Number;
        }
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(FragmentContext);
            builder.setTitle(FragmentContext.getString(R.string.callphone_yes_no))
                   .setMessage(Name +"\n"+ Number)
                    .setPositiveButton("撥打", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent call = new Intent(
                                    Intent.ACTION_CALL, Uri.parse("tel:" + Number));
                            FragmentContext.startActivity(call);
                        }
                    })
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
            AlertDialog PhoneCallDialog = builder.create();
            PhoneCallDialog.show();
        }
    }
}
