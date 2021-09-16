//package com.tequeno.bootassembly.file;
//
//import com.tequeno.constants.HtResultBinder;
//import com.tequeno.utils.HtDateUtil;
//import com.tequeno.utils.HtResultInfoWrapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import java.io.File;
//import java.util.List;
//
///**
// * @Desription:
// * @Author: hexk
// */
//
//@Controller
//public class BaseFileController {
//
//    private final static Logger logger = LoggerFactory.getLogger(BaseFileController.class);
//
//    @Value("${file.upload}")
//    protected String uploadPath;
//
//    @Value("${file.template}")
//    protected String template;
//
//    protected String getBaseFileDir() {
//        String baseFileDir = uploadPath + HtDateUtil.nowDate();
//        File dirFile = new File(baseFileDir);
//        if (!dirFile.exists()) {
//            dirFile.mkdirs();
//        }
//        return baseFileDir;
//    }
//
//    protected HtResultBinder upload(CommonsMultipartFile file, FileUploader fileUploader) {
//        boolean checked = fileUploader.doCheck(file);
//        if (!checked) {
//            throw new RuntimeException("文件校验失败");
//        }
//        String path = fileUploader.doUpload(file, getBaseFileDir());
//        return HtResultInfoWrapper.success(path);
//    }
//
//    protected HtResultBinder upload(List<CommonsMultipartFile> fileList, FileUploader fileUploader) {
//        boolean checked = fileUploader.doCheck(fileList);
//        if (!checked) {
//            throw new RuntimeException("文件校验失败");
//        }
//        List<String> list = fileUploader.doUpload(fileList, getBaseFileDir());
//        return HtResultInfoWrapper.success(list);
//    }
//}
