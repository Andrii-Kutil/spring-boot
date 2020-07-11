package springboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.demo.service.CsvReader;
import springboot.demo.service.ReviewService;

@RestController
@RequestMapping("/inject")
public class InjectController {

    @Autowired
    private CsvReader csvReader;
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{fileName}")
    public String saveAll(@PathVariable String fileName) {
        reviewService.saveAll(csvReader.getDataFromCsv(fileName));
        return "Done!";
    }
}
