package com.macro.mall.controller;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.UploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * 文件上传控制
 * @author zhouguangming
 * @date 19-8-26
 * @since
 */
@Controller
@Api(tags = "UploadController", description = "文件上传")
@RequestMapping("/upload")
public class UploadController {

    @Resource
    private UploadService uploadService;

    @ApiOperation("上传多个文件")
    @RequestMapping(value = "/uploadFiles", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:create')")
    public CommonResult uploadFiles(@RequestBody MultipartFile[] files) {
        try {
            List<String> fileIds = uploadService.saveFiles(files);
            return CommonResult.success(fileIds);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("上传文件发生异常");
        }
    }

    @ApiOperation("上传单个文件")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    //@PreAuthorize("hasAuthority('pms:product:create')")
    public CommonResult uploadFile(@RequestBody MultipartFile file) {
        try {
            String fileId = uploadService.saveFile(file);
            return CommonResult.success(fileId);
        } catch (Exception e) {
            e.printStackTrace();
            return CommonResult.failed("上传文件发生异常");
        }
    }
}
