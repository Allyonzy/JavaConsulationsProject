package ru.innopolis.site.services;

import org.springframework.web.multipart.MultipartFile;
import ru.innopolis.site.dto.FileUrlDto;

import jakarta.servlet.http.HttpServletResponse;


public interface FilesService {
    FileUrlDto save(MultipartFile file);

    void writeFileToResponse(String fileName, HttpServletResponse response);
}
