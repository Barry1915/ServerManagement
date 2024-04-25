package com.example.servermanagement.Controller;


import com.example.servermanagement.Bean.User;
import com.example.servermanagement.Mapper.UserMapper;
import com.example.servermanagement.utils.JwtUtils;
import com.example.servermanagement.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/user/login")
    public Result login(@RequestBody User user){
        System.out.println(user);
        String token = JwtUtils.generateToken(user.getUsername());
        System.out.println(token);

        return Result.ok().data("token",token);
    }
    @GetMapping("/user/info")
    public Result info(String token){
        System.out.println(token);
        String username = JwtUtils.getClaimsByToken(token).getSubject();
        String url = "https://img-blog.csdnimg.cn/direct/8de9d5a425684f34bf79d4b6ec155ed5.png";
        return Result.ok().data("name",username).data("avatar",url);
    }

    @PostMapping("/user/logout")
    public Result logout(){return Result.ok();}

    @PostMapping("/user/login2")
    public boolean login2(@RequestBody User user){
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());

        User user2 = userMapper.login(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user2.getPassword());

        System.out.println(user.getPassword().equals(user2.getPassword()));
//        String token = JwtUtils.generateToken(user.getUsername());
        return user.getPassword() == user2.getPassword();

    }


}
