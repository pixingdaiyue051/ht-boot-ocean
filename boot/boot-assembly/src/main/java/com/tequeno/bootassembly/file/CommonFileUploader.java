//package com.tequeno.bootassembly.file;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @Desription:
// * @Author: hexk
// */
//
//public class CommonFileUploader implements FileUploader {
//
//    private final static Logger logger = LoggerFactory.getLogger(CommonFileUploader.class);
//
//    @Override
//    public String doUpload(CommonsMultipartFile file, String baseFileDir) {
//        File dest = new File(baseFileDir + "/" + file.getOriginalFilename());
//        try {
//            file.transferTo(dest);
//        } catch (IOException e) {
//            logger.info("保存文件[{}]失败:", file.getOriginalFilename(), e);
//            return null;
//        }
//        return dest.getPath();
//    }
//
//    @Override
//    public List<String> doUpload(List<CommonsMultipartFile> fileList, String baseFileDir) {
//        return fileList.parallelStream()
//                .map(file -> doUpload(file, baseFileDir))
//                .collect(Collectors.toList());
//    }
//
//}
