package com.example.servermanagement.Service;
import com.example.servermanagement.Bean.SyslogMessage;
import com.jcraft.jsch.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@Service
public class SshService {
    private final String host = "172.20.137.133";
    private final int port = 23333;
    private final String user = "zouyinan";
    private final String password = "zyn20002239"; // 替换为你的密码
    private String remoteFilePath = "/home/zouyinan/syslog";

    public String readRemoteFile() throws JSchException, SftpException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no"); // 注意：生产环境中应该使用更安全的方式处理host key
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        InputStream inputStream = channelSftp.get(remoteFilePath);
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        channelSftp.disconnect();
        session.disconnect();

        return fileContent.toString();
    }
    public List<SyslogMessage> readRemoteFile_v2() throws JSchException, SftpException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no"); // 注意：生产环境中应该使用更安全的方式处理host key
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        InputStream inputStream = channelSftp.get(remoteFilePath);
        StringBuilder fileContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fileContent.append(line).append("@");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        channelSftp.disconnect();
        session.disconnect();
        String [] logcontent = fileContent.toString().split("@");
        List<SyslogMessage> loglist = new ArrayList();
        for(String log : logcontent){
            loglist.add(new SyslogMessage(log));
        }
        return loglist;
    }

    public List<SyslogMessage> readRemoteFilePaged(int page, int pageSize) throws JSchException, SftpException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no"); // 注意：生产环境中应该使用更安全的方式处理host key
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        // 计算跳过的行数
        int skipLines = (page - 1) * pageSize;
        int currentLine = 0;
        List<SyslogMessage> loglist = new ArrayList<>();

        InputStream inputStream = channelSftp.get(remoteFilePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 跳过指定数量的行
                if (currentLine < skipLines) {
                    currentLine++;
                    continue;
                }
                // 读取指定数量的行
                if (loglist.size() < pageSize) {
                    loglist.add(new SyslogMessage(line));
                } else {
                    break; // 达到每页大小，退出循环
                }
            }
        }
        channelSftp.disconnect();
        session.disconnect();
        return loglist;
    }


    public List<SyslogMessage> getauth(int page, int pageSize) throws JSchException, SftpException, IOException {
        JSch jsch = new JSch();
        Session session = jsch.getSession(user, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no"); // 注意：生产环境中应该使用更安全的方式处理host key
        session.connect();

        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();

        // 计算跳过的行数
        int skipLines = (page - 1) * pageSize;
        int currentLine = 0;
        List<SyslogMessage> loglist = new ArrayList<>();

        remoteFilePath = "/home/zouyinan/auth.log";

        InputStream inputStream = channelSftp.get(remoteFilePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 跳过指定数量的行
                if (currentLine < skipLines) {
                    currentLine++;
                    continue;
                }
                // 读取指定数量的行
                if (loglist.size() < pageSize) {
                    loglist.add(new SyslogMessage(line));
                } else {
                    break; // 达到每页大小，退出循环
                }
            }
        }
        channelSftp.disconnect();
        session.disconnect();
        return loglist;
    }



}
