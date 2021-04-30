package com.testcy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    /**
     * 多文件传
     *
     * @param username
     * @param files
     * @param model
     * @return
     */
    @RequestMapping("/uploadMul")
    public String uploadFileMul(@RequestParam(value = "username", required = false) String username,
                                @RequestParam("headImg") MultipartFile[] files, Model model) {

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                System.out.println("上传的文件名称：" + file.getOriginalFilename());
                try {
                    file.transferTo(new File("e:/tmp/" + file.getOriginalFilename()));
                    model.addAttribute("msg", "文件上传成功了！");
                } catch (IOException e) {
                    model.addAttribute("msg", "文件上传失败！"+e.getMessage());
                }
            }
        }
        return "redirect:/index.jsp";
    }

    /**
     * 单文件上传
     *
     * @param username
     * @param file
     * @param model
     * @return
     */
    @RequestMapping("/upload")
    public String uploadFile(@RequestParam(value = "username", required = false) String username,
                             @RequestParam("headImg") MultipartFile file, Model model) {

        System.out.println("上传的文件信息：" + file);
        System.out.println("上传的文件名：" + file.getName());
        System.out.println("上传的文件名：" + file.getOriginalFilename());
        try {
            file.transferTo(new File("e:/tmp/" + file.getOriginalFilename()));
            model.addAttribute("msg", "文件上传成功！");
        } catch (IOException e) {
            model.addAttribute("msg", "文件上传失败！" + e.getMessage());
        }
        return "redirect:/index.jsp";
    }

}
