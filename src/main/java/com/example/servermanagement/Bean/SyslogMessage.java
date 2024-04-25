package com.example.servermanagement.Bean;

public class SyslogMessage {

    private String log;
    public SyslogMessage(){}
    public SyslogMessage(String log){this.log=log;}
    @Override
    public String toString() {
        return "SyslogMessage{" +
                "log='" + log + '\'' +
                '}';
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }
}
