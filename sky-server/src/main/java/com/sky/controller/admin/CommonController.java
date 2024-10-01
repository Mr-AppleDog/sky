package com.sky.controller.admin;

import com.sky.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author MrLu
 * @version 1.0
 * @description: TODO
 * @date 2024/9/27 23:40
 */
@RequestMapping("/admin/common")
@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:8080")
@Api(tags = "公共管理")
public class CommonController {

   @Value("${cangqiong.path}")
    private String basePath;

    /**
     * 文件上传
     * @param file 接受前端上传的文件  与前端自动名一致
     * @return 本地地址
     */
    @PostMapping("/upload")
    @ApiOperation("文件上传")
    public Result<String> upload(MultipartFile file) {

        //获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //获取后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //使用uuid 生成文件名
        String filename = UUID.randomUUID()+suffix;

        //创建一个目录
        File dir=new File(basePath);
        if(!dir.exists()){
            //目录不存在,需要创建
            dir.mkdirs();
        }

        try {
            file.transferTo(new File(basePath+filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success(filename);
    }

    /**
     * 文件下载
     * 由于存放在本地  前端<img> 发送请求的时候 不携带token
     * 在WebMvcConfiguration类中 放过对/admin/common/download 的token 检验
     * @param response
     * @param name
     */
    @GetMapping("/download")
    @ApiOperation("文件下载")
    public void download(HttpServletResponse response, String name) {

        try {
            //输入流
            FileInputStream fileInputStream = new FileInputStream(new File(basePath + name));

            //输出流,写回到浏览器

            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
                outputStream.flush();
            }

            //关闭资源
            outputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
