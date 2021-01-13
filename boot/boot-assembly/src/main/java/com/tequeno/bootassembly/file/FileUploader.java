package com.tequeno.bootassembly.file;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @Desription:
 * @Author: hexk
 */
public interface FileUploader {

    default boolean doCheck(CommonsMultipartFile file) {
        return true;
    }

    default boolean doCheck(List<CommonsMultipartFile> fileList) {
        return true;
    }

    String doUpload(CommonsMultipartFile file, String baseFileDir);

    List<String> doUpload(List<CommonsMultipartFile> fileList, String baseFileDir);
}
