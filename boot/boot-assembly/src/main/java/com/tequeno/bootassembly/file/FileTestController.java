package com.tequeno.bootassembly.file;

import com.tequeno.constants.HtResultBinder;
import com.tequeno.utils.HtResultInfoWrapper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
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

    @RequestMapping("export")
    public HtResultBinder export(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) {
        if (!filePath.startsWith("/")) {
            filePath = String.format("%s/%s", template, filePath);
        }
        try (ServletOutputStream outputStream = response.getOutputStream()) {
            handleFileNameFromPath(request, response, filePath);
            XSSFWorkbook workbook = new XSSFWorkbook(filePath);
            workbook.write(outputStream);
        } catch (Exception e) {
            logger.info("导出失败", e);
            return HtResultInfoWrapper.fail(e.getMessage());
        }
        return HtResultInfoWrapper.success("导出成功");
    }

    @RequestMapping("download")
    public HtResultBinder download(@RequestParam("filePath") String filePath, HttpServletRequest request, HttpServletResponse response) {
        if (!filePath.startsWith("/")) {
            filePath = String.format("%s/%s", template, filePath);
        }
        try (ServletOutputStream outputStream = response.getOutputStream();
             FileInputStream fis = new FileInputStream(filePath)) {
            handleFileNameFromPath(request, response, filePath);
            byte[] b = new byte[1024];
            while (fis.read(b) != -1) {
                outputStream.write(b);
            }
        } catch (Exception e) {
            logger.info("下载失败", e);
            return HtResultInfoWrapper.fail(e.getMessage());
        }
        return HtResultInfoWrapper.success("下载成功");
    }

    private void handleFileNameFromPath(HttpServletRequest request, HttpServletResponse response, String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
        if (!file.isFile()) {
            throw new RuntimeException("不是文件,无法读取");
        }
        String fileName = file.getName();
        int pointIdx = fileName.lastIndexOf(".");
        String suffix = fileName.substring(pointIdx + 1);
        fileName = URLEncoder.encode(fileName.substring(0, pointIdx), "UTF-8");
        response.setHeader("Content-disposition", String.format("attachment; filename=%s%d.%s", fileName, System.currentTimeMillis(), suffix));
        response.setContentType(request.getServletContext().getMimeType(filePath));
    }
}
