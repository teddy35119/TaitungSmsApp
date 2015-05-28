package com.example.rescue.pornapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by teddy on 2015/5/14.
 */
public class Meun1Fragment extends Fragment {
    View RootView;
    private ListView PhoneNumberListView;
    private TextView NameText,NumberText;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.meun1_fragment,container,false);
        //自己塞的資料
        String [] Name = new String[]{"熊德麟","林宏逸","溫立言","施得群","胡維軒"};
        String [] Number = new String[]{"0970562218","0937083654","0928504697","0987424260","000"};
        PhoneNumberListView = (ListView) RootView.findViewById(R.id.listView);
        NameText = (TextView) RootView.findViewById(R.id.PhoneCallName);
        NumberText = (TextView) RootView.findViewById(R.id.PhoneCallNumber);
        //用android本身設計得好的樣式
        //ArrayAdapter aa= new ArrayAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,value);
        //自訂的layout利用Baseadater來轉接
        PhoneNumberListView.setAdapter(new PhoneNumberAdapter(getActivity(),Name,Number));
        PhoneNumberListView.addHeaderView(NameText);
        PhoneNumberListView.addHeaderView(NumberText);

        return RootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}
