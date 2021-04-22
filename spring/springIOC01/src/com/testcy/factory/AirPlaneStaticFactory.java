package com.testcy.factory;

import com.testcy.bean.AirPlane;

public class AirPlaneStaticFactory {

    public static AirPlane getAirPlane(String jzName) {
        System.out.println("AirPlaneStaticFactory正在造飞机。。。");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("static太行");
        airPlane.setFjsName("Curry");
        airPlane.setYc("189.98m");
        airPlane.setJzName(jzName);
        return airPlane;
    }
}
