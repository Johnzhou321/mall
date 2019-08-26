package com.macro.mall.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadService {
    List<String> saveFiles(MultipartFile[] files) throws Exception;

    String saveFile(MultipartFile file) throws Exception;
}
