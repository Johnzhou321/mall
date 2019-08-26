package com.macro.mall.service.impl;

import com.macro.mall.service.UploadService;
import com.macro.mall.util.FastDFSClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * 文件上传服务类
 * @author zhouguangming
 * @date 19-8-26
 * @since
 */
@Service
public class UploadServiceImpl implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadServiceImpl.class);

    @Value("${file.url}")
    public String fileUrl;

    @Override
    public List<String> saveFiles(MultipartFile[] files) throws Exception {
        if (files == null || files.length == 0){
            return new ArrayList<>(0);
        }
        List<String> fileIds = new ArrayList<>(files.length);
        for (MultipartFile file : files){
            fileIds.add(fileUrl + FastDFSClient.save(file));
        }
        return fileIds;
    }

    @Override
    public String saveFile(MultipartFile file) throws Exception {
        if (file == null){
            return null;
        }
        String fileId = FastDFSClient.save(file);
        return fileUrl + fileId; //加上服务器地址（配置有nginx代理）
    }
}
