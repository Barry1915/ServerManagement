package com.example.servermanagement.Controller;


import com.example.servermanagement.Bean.SyslogMessage;
import com.example.servermanagement.Bean.User;
import com.example.servermanagement.Mapper.UserMapper;
import com.example.servermanagement.Service.SshService;
import com.example.servermanagement.utils.sysassist;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class SshController {

    @Autowired
    private SshService sshService;

    @GetMapping("/syslog/133")
    public String getRemotesyslog() throws JSchException, SftpException {
        return sshService.readRemoteFile();
    }

    @GetMapping("/syslog/test")
    public List<SyslogMessage> getRemotesyslog2() throws JSchException, SftpException {
        return sshService.readRemoteFile_v2();
    }

    @GetMapping("/syslog/page")
    public List<SyslogMessage>getlogpage(int page, int pageSize) throws JSchException, SftpException, IOException {
        return sshService.readRemoteFilePaged(page,pageSize);
    }

    @GetMapping("authlog/page")
    public List<SyslogMessage>getauthlog(int page, int pageSize) throws JSchException, SftpException, IOException {
        return sshService.getauth(page,pageSize);
    }

    @GetMapping("/syslog/{id}")
    public List<SyslogMessage> getlog(@PathVariable int id){
        List<SyslogMessage> loglist = new ArrayList();
        if (id == 131){
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd[1]: logrotate.service: Succeeded."));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd[1]: logrotate.service: Succeeded."));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));
            loglist.add(sysassist.createSyslogMessage("Apr 23 00:00:00 gpu-4x3090-133 systemd-networkd[1494]: veth2de165c: Link DOWN"));

        }


        return loglist;
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @Autowired
    private UserMapper userMapper;

    @GetMapping("findall")
    public List<User> findall(){
        return userMapper.findall();
    }

}
