package springboot.demo.service;

import java.util.List;

public interface FileReaderService {
    List<String> getFileContent(String filePath);
}
