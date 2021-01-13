package com.tequeno.bootassembly.file;

import com.tequeno.common.constants.HtResultBinder;
import com.tequeno.common.utils.HtResultInfoWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @Desription:
 * @Author: hexk
 */

@RestController
@RequestMapping("file")
public class FileTestController extends BaseFileController {

    private final static Logger logger = LoggerFactory.getLogger(FileTestController.class);

    @RequestMapping("upload/doc")
    public HtResultBinder uploadDoc(@RequestParam("fileList") List<CommonsMultipartFile> fileList) {
        try {
            return super.upload(fileList, new DocFileUploader());
        } catch (Exception e) {
            logger.info("上传失败", e);
            return HtResultInfoWrapper.fail(e.getMessage());
        }
    }

    @RequestMapping("upload/img")
    public HtResultBinder uploadImg(@RequestParam("fileList") List<CommonsMultipartFile> fileList) {
        try {
            return super.upload(fileList, new ImgFileUploader());
        } catch (Exception e) {
            logger.info("上传失败", e);
            return HtResultInfoWrapper.fail(e.getMessage());
        }
    }

    @RequestMapping("upload/all")
    public HtResultBinder upload(@RequestParam("fileList") List<CommonsMultipartFile> fileList) {
        try {
            return super.upload(fileList, new CommonFileUploader());
        } catch (Exception e) {
            logger.info("上传失败", e);
            return HtResultInfoWrapper.fail(e.getMessage());
        }
    }
}
