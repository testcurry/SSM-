package com.testcy.factory;

import com.testcy.bean.AirPlane;

public class AirPlaneInstanceFactory {

    public AirPlane getAirPlane(String jzName) {
        System.out.println("AirPlaneInstanceFactory正在造飞机。。。");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("instance太行");
        airPlane.setFjsName("Curry");
        airPlane.setYc("189.98m");
        airPlane.setJzName(jzName);
        return airPlane;
    }
}
