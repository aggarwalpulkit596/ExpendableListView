package com.example.pulkit_mac.expendablelist;

import java.util.ArrayList;

/**
 * Created by pulkit-mac on 04/02/18.
 */

public class Team {
    //PROPERTIES OF A SINGLE TEAM
    public String Name;
    public String Image;
    public ArrayList<String> players=new ArrayList<String>();

    public Team(String Name)
    {
        this.Name=Name;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Name;
    }
}
