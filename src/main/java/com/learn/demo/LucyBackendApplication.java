package com.learn.demo;

import com.learn.demo.vo.request.LoginRequestVo;
import com.learn.demo.vo.response.LoginResponseVo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xiwang
 */
@Controller
@SpringBootApplication
public class LucyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LucyBackendApplication.class, args);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseVo> login(@RequestBody LoginRequestVo vo) {
        boolean successful = "xinxin".equals(vo.getPassword())
                && "xinxin".equals(vo.getUserName());
        return ResponseEntity.ok(getResponse(successful));
    }

    private LoginResponseVo getResponse(boolean type) {
        LoginResponseVo vo = new LoginResponseVo();
        vo.setIsSuccess(type);
        if (type) {
            vo.setMessage("Login Successful");
        } else {
            vo.setMessage("Login Failed");
        }
        return vo;
    }

}
