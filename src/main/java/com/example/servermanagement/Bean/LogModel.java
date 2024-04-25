package com.example.servermanagement.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LogModel {

    private String time;
    private String machine;
    private String log;
    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd HH:mm:ss", Locale.ENGLISH);
    SimpleDateFormat outputFormat = new SimpleDateFormat("MM-dd HH:mm:ss");


    public LogModel(){};

    public LogModel(String time,String machine,String log) throws ParseException {
        this.time = outputFormat.format(sdf.parse(time));
        this.machine = machine;
        this.log = log;
    }

    @Override
    public String toString() {
        return "LogModel{" +
                "date=" + time +
                ", machine='" + machine + '\'' +
                ", log='" + log + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMachine() {
        return machine;
    }

    public void setMachine(String machine) {
        this.machine = machine;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
