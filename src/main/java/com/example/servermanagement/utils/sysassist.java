package com.example.servermanagement.utils;

import com.example.servermanagement.Bean.SyslogMessage;

public class sysassist {
    public static SyslogMessage createSyslogMessage(String log){
        SyslogMessage syslogMessage = new SyslogMessage();
        syslogMessage.setLog(log);
        return syslogMessage;
    }
}

