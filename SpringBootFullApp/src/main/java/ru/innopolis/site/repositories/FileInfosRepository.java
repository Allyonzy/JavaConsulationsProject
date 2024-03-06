package ru.innopolis.site.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.innopolis.site.models.FileInfo;


public interface FileInfosRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageFileName(String fileName);
}
