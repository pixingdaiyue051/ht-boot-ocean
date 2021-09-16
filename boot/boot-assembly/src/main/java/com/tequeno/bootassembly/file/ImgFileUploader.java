//package com.tequeno.bootassembly.file;
//
//import org.springframework.web.multipart.commons.CommonsMultipartFile;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @Desription:
// * @Author: hexk
// */
//
//public class ImgFileUploader extends CommonFileUploader {
//
//    private final static String MAX = "10M";
//
//    private final static long MAX_SIZE = 10496246L; // 10.01M = 10.01*1024*1024=10496246
//
//    private static Map<String, String> SUFFIX_MAP = null;
//
//    private boolean suffixMatched(String suffix) {
//        if (null == SUFFIX_MAP) {
//            SUFFIX_MAP = new HashMap<>(5);
//            SUFFIX_MAP.put("jpg", "jpg");
//            SUFFIX_MAP.put("jpeg", "jpeg");
//            SUFFIX_MAP.put("png", "png");
//            SUFFIX_MAP.put("bmp", "bmp");
//            SUFFIX_MAP.put("gif", "gif");
//        }
//        return SUFFIX_MAP.containsKey(suffix);
//    }
//
//    @Override
//    public boolean doCheck(List<CommonsMultipartFile> fileList) {
//        for (CommonsMultipartFile file : fileList) {
//            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
//            if (!suffixMatched(suffix)) {
//                throw new RuntimeException(String.format("只能上传%s", SUFFIX_MAP.values()));
//            }
//            if (file.getSize() > MAX_SIZE) {
//                throw new RuntimeException(String.format("[%s]大小超出%s", file.getOriginalFilename(), MAX));
//            }
//        }
//        return true;
//    }
//}
