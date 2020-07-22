package top.king.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import top.king.model.User;
import top.king.serviceimpl.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Value("${fileUploadPath}")
    String path;
    String separator = System.getProperty("file.separator");

    @ModelAttribute("test")
    public String test() {
        return "abcd";
    }

    @ModelAttribute
    public String king() {
        System.out.println("方法ModelAttribute！");
        return "efgh";
    }

    @InitBinder("user")
    public void initValue(WebDataBinder webDataBinder) {
        System.out.println("user 方法执行！");
    }

    @InitBinder
    public void blankValue(WebDataBinder webDataBinder) {
        System.out.println("空@InitBinder方法执行!");
    }

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("user");
        mav.addObject("user", userService.selectUsers());
        return mav;
    }

    @RequestMapping("/add")
    @ResponseBody
    public void addUser(User user) {
        userService.insertUser(user);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void deleteUser(String primaryKey) {
        userService.deleteUser(primaryKey);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    /**
     * 文件上传
     *
     * @param
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    public void uploadFile(List<MultipartFile> files, HttpServletRequest request) {
        for (MultipartFile file : files) {
            String filename = file.getOriginalFilename();
            File document = new File(path + separator + filename);
            System.out.println(document.getAbsolutePath());
            try {
                if (!document.exists()) {
                    document.createNewFile();
                }
                file.transferTo(document);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("download")
    public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
        String downPath = path + separator + fileName;
        File file = new File(downPath);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
