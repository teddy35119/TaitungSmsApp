package com.example.rescue.pornapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by teddy on 2015/5/14.
 */
public class Meun1Fragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    View RootView;
    private ExpandableListView PhoneNumberListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RootView = inflater.inflate(R.layout.meun1_fragment,container,false);
        PhoneNumberListView = (ExpandableListView)RootView.findViewById(R.id.listView);
        setExpandableListViewData();
        PhoneNumberListView.setAdapter(new ExpandableBaseAdapter(getActivity(),groupData));
        for(int i=0;i<groupTitle.length;i++){
            PhoneNumberListView.expandGroup(i);
        }
//        //自己塞的資料
//        String [] Name = new String[]{"陳oo","林oo","溫oo","施oo","胡oo"};
//        String [] Number = new String[]{"0970135531","0937232323","0928123456","0987987789","0988123423"};
//        PhoneNumberListView = (ListView) RootView.findViewById(R.id.listView);
//        //取得header
//        View header = inflater.inflate(R.layout.listviewsms_header, PhoneNumberListView, false);
//        PhoneNumberListView.addHeaderView(header, null, false);
//        //自訂layout頁面並利用Baseadater來轉接
//        PhoneNumberListView.setAdapter(new PhoneNumberAdapter(getActivity(),Name,Number));

        //用android本身設計得好的樣式
        //ArrayAdapter aa= new ArrayAdapter(getActivity(),android.R.layout.simple_expandable_list_item_1,value);



        return RootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    String [] groupTitle = new String[]{"替代役","特搜分隊","台東分隊","台東大隊"};
    String [][]SmsPhone = new String[][]{{"陳oo","林oo","溫oo","施oo","胡oo"},{"0970135531","0937232323","0928123456","0987987789","0988123423"}};
    private List<Map<String, Object>> groupData;
    private List<List<Map<String, Object>>> childData;
    private void setExpandableListViewData(){
        groupData = new ArrayList<Map<String,Object>>();
        childData = new ArrayList<List<Map<String,Object>>>();

        for (int i = 0 ; i < groupTitle.length;i++){
            Map<String, Object> groupObj = new HashMap<String, Object>();
            groupObj.put("Group",groupTitle[i]);
            groupData.add(groupObj);
        }
        //for (int i = 0 ; i < groupTitle.length;i++){
          // Log.v("TEST",groupData.get(i).toString());
        //}
    }

}
