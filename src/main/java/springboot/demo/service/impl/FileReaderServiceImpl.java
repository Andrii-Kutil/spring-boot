package springboot.demo.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import springboot.demo.service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String> getFileContent(String filePath) {
        Path path = Paths.get(filePath);
        List<String> content;
        try (Stream<String> lines = Files.lines(path)) {
            content = lines.collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file which path is : " + path, e);
        }
        return content;
    }
}
