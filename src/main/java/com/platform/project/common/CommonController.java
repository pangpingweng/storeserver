package com.platform.project.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.platform.project.system.service.QiniuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.platform.common.constant.Constants;
import com.platform.common.utils.StringUtils;
import com.platform.common.utils.file.FileUploadUtils;
import com.platform.common.utils.file.FileUtils;
import com.platform.framework.config.FastConfig;
import com.platform.framework.config.ServerConfig;
import com.platform.framework.web.domain.AjaxResult;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 通用请求处理
 * 
 */
@RestController
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    private QiniuService qiniuService;

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.checkAllowDownload(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = FastConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {

            // 上传文件路径
            String filePath = FastConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("url", url);
            ajax.put("fileName", fileName);
//            ajax.put("newFileName", FileUtils.getName(fileName));
            ajax.put("originalFilename", file.getOriginalFilename());
            return ajax;

//                // 上传文件路径
//                String filePath = FastConfig.getUploadPath();
//                // 上传并返回新文件名称
//                String fileName = FileUploadUtils.upload(filePath, file);
//                String url = serverConfig.getUrl() + fileName;
//                AjaxResult ajax = AjaxResult.success();
//                String keyPath = filePath +fileName.replace("/profile/upload","");
//                ajax.put("fileName", keyPath);
//                ajax.put("url", url);
//                return ajax;
//              log.info("开始上传文件,文件名【{}】,文件大小【{}】", file.getName(),file.getSize());
//              String url = qiniuService.uploadFile(file.getInputStream());
//              log.info("文件上传完成,文件名【{}】,文件大小【{}】", file.getName(),file.getSize());
//              AjaxResult ajax = AjaxResult.success();
//              ajax.put("fileName", file.getOriginalFilename());
//              ajax.put("url", "https://"+url);
//              return ajax;

//            String filePath = COSClientUtil.upload(file);
//            AjaxResult ajax = AjaxResult.success();
//            ajax.put("fileName", file.getOriginalFilename());
//            ajax.put("url", "https://"+filePath);
//            return ajax;
        }
        catch (Exception e)   
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        try
        {
            if (!FileUtils.checkAllowDownload(resource))
            {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = FastConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }




}
