package top.king.serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.king.service.FileResourceService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileResourceServiceImpl implements FileResourceService {
    @Value("${fileUploadPath}")
    String path;

    @Override
    public List<String> searchFiles() {
        List<String> files = new ArrayList<String>();
        try {
            File file = new File(path);
            File[] listFiles = file.listFiles();
            for (File file1 : listFiles) {
                files.add(file1.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return files;
    }
}
