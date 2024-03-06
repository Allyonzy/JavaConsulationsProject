package ru.innopolis.site.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.site.dto.FileUrlDto;
import ru.innopolis.site.services.FilesService;

import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class FilesController {

    @Autowired
    private FilesService filesService;

    @PermitAll
    @GetMapping("/files/upload")
    public String getFileUploadPage() {
        return "file_upload";
    }

    @GetMapping("/files/{file-name:.+}")
    public void getFile(@PathVariable("file-name") String fileName, HttpServletResponse response) {
        filesService.writeFileToResponse(fileName, response);
    }

    @PermitAll
    @PostMapping("/files")
    @ResponseBody
    public FileUrlDto saveFile(@RequestParam("file") MultipartFile file)  {
        return filesService.save(file);
    }
}
