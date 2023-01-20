package com.example.logtestapi.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;

import com.example.logtestapi.ReturnStatement.FileUploadResponse;
import com.example.logtestapi.ReturnStatement.ResponseData;
import com.example.logtestapi.ReturnStatement.ReturnStatement;
import com.example.logtestapi.Util.FileUtil;
import com.example.logtestapi.helpers.ReturnStatementPreparator;

@RestController
// @CrossOrigin(origins = "http://localhost:8082") open for specific port
@CrossOrigin() // open for all ports

@RequestMapping("api/v1/user")
public class FileUploadController {
    @Autowired
    private ReturnStatementPreparator returnStatementPreparator;

    /**
     * Method to upload multiple files
     * 
     * @param file
     * @return FileResponse
     */
    @PostMapping("/upload")
    public ResponseEntity<ReturnStatement> uploadFiles(@RequestParam("file") MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                createDirIfNotExist();
                // read and write the file to the local folder
                byte[] bytes = new byte[0];
                bytes = file.getBytes();
                Files.write(Paths.get(FileUtil.folderPath + file.getOriginalFilename()), bytes);
                List lis = new ArrayList<>();
                lis.add(file.getOriginalFilename());
                return ResponseEntity.status(HttpStatus.OK)
                        .body(returnStatementPreparator.prepareSuccess("0000", "file Added successufully", false, lis));
            } else {
                return ResponseEntity.status(HttpStatus.OK)
                        .body(returnStatementPreparator.prepare("0004", "NO FILE FOUND"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(returnStatementPreparator.prepare("0001", "Exception to upload files!"));

        }
    }

    /**
     * Create directory to save files, if not exist
     */
    private void createDirIfNotExist() {
        // create directory to save the files
        File directory = new File(FileUtil.folderPath);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    /**
     * Method to get the list of files from the file storage folder.
     * 
     * @return file
     */
    @GetMapping("/files")
    public ResponseEntity<ReturnStatement> getListFiles() {

        List lis = new ArrayList<>();
        lis.add(new File(FileUtil.folderPath).list());
        return ResponseEntity.status(HttpStatus.OK)
                .body(returnStatementPreparator.prepareSuccess("0000", "show all files ", false, lis));
    }

    public ReturnStatement prepReturnStatement() {
        return null;

    }
}
