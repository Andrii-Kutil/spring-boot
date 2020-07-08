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
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> content = null;
        if (lines != null) {
            content = lines.collect(Collectors.toList());
            lines.close();
        }
        return content;
    }
}
