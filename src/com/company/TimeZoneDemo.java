package com.company;

import java.util.HashMap;
import java.util.Map;

public class TimeZoneDemo
{
    public static void main (String[] args)
    {
        TimeZoneDemo timeZoneDemo=new TimeZoneDemo();
        timeZoneDemo.demo();

    }
    public void demo()
    {
        Map<String,Integer>  timeZone= new HashMap<>();
        timeZone.put("EST",-5);
        timeZone.put("CST",-6);
        timeZone.put("MST",-7);
        timeZone.put("PST",-8);
        timeZone.put("GMT",0);
        System.out.println(getTimeDiff(timeZone.get("PST"),timeZone.get("EST")));
    }
    public int getTimeDiff(int zone1, int zone2)
    {
        return zone1-zone2;
    }

}
