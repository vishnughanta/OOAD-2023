package main.java.subscriber;

import java.util.List;
import java.util.ArrayList;

public class SubscriberObject {
    private String nameOfFNCD;
    private List<String> logList;
    private double totalMoneyFNCD;
    private double totalMoneyStaff;
    private int day;

    public SubscriberObject() {
        logList = new ArrayList<>();
        totalMoneyStaff = 0;
        totalMoneyFNCD = 0;
        day = 0;
    }

    public List<String> getLogList() {
        return logList;
    }

    public void setLogList(List<String> logList) {
        this.logList = logList;
    }

    public double getTotalMoneyFNCD() {
        return totalMoneyFNCD;
    }

    public void setTotalMoneyFNCD(double totalMoneyFNCD) {
        this.totalMoneyFNCD = totalMoneyFNCD;
    }

    public double getTotalMoneyStaff() {
        return totalMoneyStaff;
    }

    public void setTotalMoneyStaff(double totalMoneyStaff) {
        this.totalMoneyStaff = totalMoneyStaff;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getNameOfFNCD() {
        return nameOfFNCD;
    }

    public void setNameOfFNCD(String nameOfFNCD) {
        this.nameOfFNCD = nameOfFNCD;
    }
}
