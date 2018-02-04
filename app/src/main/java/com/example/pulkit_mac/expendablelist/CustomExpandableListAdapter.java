package com.example.pulkit_mac.expendablelist;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pulkit-mac on 03/02/18.
 */

public class CustomExpandableListAdapter extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Team> team;
    private LayoutInflater inflater;

    public CustomExpandableListAdapter(Context context, ArrayList<Team> team) {
        this.context = context;
        this.team = team;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //GET A SINGLE PLAYER
    @Override
    public Object getChild(int groupPos, int childPos) {
        return team.get(groupPos).players.get(childPos);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.expandedListItem);
        expandedListTextView.setText(expandedListText);
        return convertView;
    }

    //GET NUMBER OF PLAYERS
    @Override
    public int getChildrenCount(int groupPosw) {
        // TODO Auto-generated method stub
        return team.get(groupPosw).players.size();
    }

    @Override
    public Object getGroup(int groupPos) {
        // TODO Auto-generated method stub
        return team.get(groupPos);
    }

    //GET NUMBER OF TEAMS
    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return team.size();
    }


    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        Team t=(Team) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_group, null);
        }
        TextView listTitleTextView = convertView
                .findViewById(R.id.listTitle);
        ImageView img= convertView.findViewById(R.id.listimagetitle);

        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(t.Name);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
