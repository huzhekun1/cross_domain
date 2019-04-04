package com.ithzk.cross.controller;

import com.ithzk.cross.entity.Book;
import com.ithzk.cross.entity.ResultData;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzk
 * @date 2019/4/2
 */
@RestController
@RequestMapping("/api")
//@CrossOrigin
public class ApiController {

    @GetMapping("/getApi")
    public ResultData getApi(){
        System.out.println("ApiController.getApi");
        return new ResultData("ApiController.getApi");
    }

    @PostMapping("/postApi")
    public ResultData postApi(@RequestBody Book book){
        System.out.println("ApiController.postApi " + book.getName() + " " + book.getPrice());
        return new ResultData("ApiController.postApi " + book.getName() + " " + book.getPrice());
    }

    @GetMapping("/getCookie")
    public ResultData getCookie(@CookieValue(value="api_cookie") String apiCookie){
        System.out.println("ApiController.getCookie " + apiCookie);
        return new ResultData("ApiController.getCookie " + apiCookie);
    }

    @GetMapping("/getHeader")
    public ResultData getHeader(@RequestHeader(value = "X-Header-1") String header1,@RequestHeader(value = "X-Header-2") String header2){
        System.out.println("ApiController.getHeader " + header1 + " " + header2);
        return new ResultData("ApiController.getHeader " + header1 + " " + header2);
    }
}
