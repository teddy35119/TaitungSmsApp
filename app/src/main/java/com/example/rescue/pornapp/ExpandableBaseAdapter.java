package com.example.rescue.pornapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;
import java.util.Map;

/**
 * Created by teddy on 2015/5/31.
 */
public class ExpandableBaseAdapter extends BaseExpandableListAdapter {
    private Context FragmentContext;
    private LayoutInflater inflater;
    private List<Map<String, Object>> groupTitle;
    public ExpandableBaseAdapter(Context FragmentContext, List<Map<String, Object>> group){
        inflater = LayoutInflater.from(FragmentContext);
        this.FragmentContext = FragmentContext;
        this.groupTitle = group;
    }

    @Override
    public int getGroupCount() {
        return groupTitle.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {

        return groupTitle.get(groupPosition);
    }

    @Override
    public Object getChild(int i, int i2) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int i, int i2) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View CustonGroupView, ViewGroup viewGroup) {
        String GroupText = groupTitle.get(groupPosition).get("Group").toString();
        CustonGroupView = inflater.inflate(R.layout.group_expandable,viewGroup,false);
        TextView GroupTitle = (TextView)CustonGroupView.findViewById(R.id.GroupText);
        GroupTitle.setText(GroupText);

        return CustonGroupView;
    }

    @Override
    public View getChildView(int i, int i2, boolean b, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public boolean isChildSelectable(int i, int i2) {
        return false;
    }
}
