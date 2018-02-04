package com.example.pulkit_mac.expendablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = findViewById(R.id.expandableListView);

        final ArrayList<Team> team=getData();

        expandableListAdapter = new CustomExpandableListAdapter(this, team);
        expandableListView.setAdapter(expandableListAdapter);

    }
    private ArrayList<Team> getData()
    {

        Team t1=new Team("Man Utd");
        t1.players.add("Wayne Rooney");
        t1.players.add("Van Persie");
        t1.players.add("Ander Herera");
        t1.players.add("Juan Mata");

        Team t2=new Team("Arsenal");
        t2.players.add("Aaron Ramsey");
        t2.players.add("Mesut Ozil");
        t2.players.add("Jack Wilshere");
        t2.players.add("Alexis Sanchez");

        Team t3=new Team("Chelsea");
        t3.players.add("John Terry");
        t3.players.add("Eden Hazard");
        t3.players.add("Diego Costa");
        t3.players.add("Oscar");

        ArrayList<Team> allTeams=new ArrayList<Team>();
        allTeams.add(t1);
        allTeams.add(t2);
        allTeams.add(t3);

        return allTeams;
    }

}
