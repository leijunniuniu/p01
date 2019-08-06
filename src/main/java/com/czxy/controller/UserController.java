package com.czxy.controller;

import com.czxy.domain.User;
import com.czxy.service.UserService;
import com.czxy.vericode.VerificationCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("login")
    public ResponseEntity<Void> login(User user, String checkAuto,String vcText, HttpServletRequest request, HttpServletResponse response){
        System.out.println(vcText);
        User login = userService.login(user);

        String vcCode = (String) request.getSession().getAttribute("vcCode");
        System.out.println(vcCode);
        if (!vcCode.equalsIgnoreCase(vcText)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        if (login!=null){
            System.out.println("登录成功！");
            request.getSession().setAttribute("loginU",login);

            Cookie ck1 = new Cookie("checkAuto", checkAuto);
            Cookie ck2 = new Cookie("username", user.getUsername());
            Cookie ck3 = new Cookie("password", user.getPassword());

            ck1.setPath("/");
            ck2.setPath("/");
            ck3.setPath("/");

            if("yes".equals(checkAuto)){
                //勾选了记住我  存活时间 7天
                //创建 仨cookie 分别存储 用户名 密码 勾选状态 给前端
                ck1.setMaxAge(60*60*24*7);
                ck2.setMaxAge(60*60*24*7);
                ck3.setMaxAge(60*60*24*7);
            }else{
                //未勾选记住我
                //创建 仨cookie 分别存储 用户名 密码 勾选状态 存活时间为 0 给前端
                ck1.setMaxAge(0);
                ck2.setMaxAge(0);
                ck3.setMaxAge(0);
            }

            response.addCookie(ck1);
            response.addCookie(ck2);
            response.addCookie(ck3);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getSessionByLoginU")
    public ResponseEntity<User> getSessionByLoginU(HttpServletRequest request){
        User loginU = (User) request.getSession().getAttribute("loginU");
        return ResponseEntity.ok(loginU);
    }

    @GetMapping("/loginOut")
    public void loginOut(HttpServletRequest request){
        System.out.println("退出登录了");
        request.getSession().removeAttribute("loginU");
    }

    @PutMapping("/putUser")
    public ResponseEntity<Void>updateUser(User user){
        try {
            userService.update(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<User> getUserInfo(HttpServletRequest request){
        User loginU = (User) request.getSession().getAttribute("loginU");
        return ResponseEntity.ok(userService.selectByPrimaryKey(loginU.getUid()));
    }


    /**
     * 注册
     * */
    @PutMapping
    public ResponseEntity<Void> insert(User user,String repassword,String vcText, HttpServletRequest request){
        try {
            String vcCode = (String) request.getSession().getAttribute("vcCode");
            if (!vcCode.equalsIgnoreCase(vcText)){
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }

            if (!user.getPassword().equals(repassword)){
                return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
            }

            User registerUser = userService.registerVerifyByUserName(user.getUsername());
            if (registerUser == null) {
                String s = UUID.randomUUID().toString();
                String[] split = s.split("-");
                String id="";
                for (String s1 : split) {
                    id+=s1;
                }
                user.setUid(id);
                userService.insert(user);
                request.getSession().setAttribute("user",user);
                return new ResponseEntity<>(HttpStatus.CREATED);
            }
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //注册页面校验用户名
    @GetMapping("/checkusername")
    public ResponseEntity<Void>checkusername(String username){
        try {
            if (userService.registerVerifyByUserName(username)==null){
                return new ResponseEntity<>(HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @GetMapping("/getVcImg")
    public void getVcImg(HttpServletRequest request, HttpServletResponse response) throws IOException, IOException {
        VerificationCode verificationCode = new VerificationCode();
        //获得图片
        BufferedImage image = verificationCode.getImage();
        String vccode = verificationCode.getText();
        //用于产生随机的验证码
        StringBuffer randomCode = new StringBuffer();
        randomCode.append(vccode);
        //将衍生码保存到session中
        request.getSession().setAttribute("vcCode",randomCode.toString());
        //禁止图像缓存
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires",0);
        response.setContentType("image/jpeg");
        //将图像输出到servlet输出流中
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(image,"jpeg",sos);
        sos.flush();
    }

}
