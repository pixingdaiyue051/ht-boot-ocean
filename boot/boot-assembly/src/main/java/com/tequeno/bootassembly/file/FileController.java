package com.tequeno.bootassembly.file;

import com.tequeno.constants.HtResultModel;
import com.tequeno.constants.HtResultWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Desription:
 * @Author: hexk
 */

@RestController
@RequestMapping("file")
public class FileController {

    private final static Logger logger = LoggerFactory.getLogger(FileController.class);

    @Resource
    private FileUploader fileUploader;

    @Resource
    private FileDownloader fileDownloader;

    @RequestMapping("upload/single")
    public HtResultModel uploadSingle(@RequestParam("file") CommonsMultipartFile file) {
        try {
            String out = fileUploader.upload(file);
            return HtResultWrapper.success(out);
        } catch (Exception e) {
            logger.info("保存文件[{}]失败:", file.getOriginalFilename(), e);
            return HtResultWrapper.fail(e.getMessage());
        }
    }

    @RequestMapping("upload/multi")
    public HtResultModel uploadMulti(@RequestParam("fileList") List<CommonsMultipartFile> fileList) {
        try {
            List<String> out = fileUploader.upload(fileList);
            return HtResultWrapper.success(out);
        } catch (Exception e) {
            logger.info("保存文件失败:", e);
            return HtResultWrapper.fail(e.getMessage());
        }
    }

    @RequestMapping("export")
    public HtResultModel export(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            fileDownloader.export(fileName, request, response);
        } catch (Exception e) {
            logger.info("导出失败", e);
            return HtResultWrapper.fail(e.getMessage());
        }
        return HtResultWrapper.success("导出成功");
    }

    @RequestMapping("download")
    public HtResultModel download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            fileDownloader.download(fileName, request, response);
        } catch (Exception e) {
            logger.info("下载失败", e);
            return HtResultWrapper.fail(e.getMessage());
        }
        return HtResultWrapper.success("下载成功");
    }
}
