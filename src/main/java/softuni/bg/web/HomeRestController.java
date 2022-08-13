package softuni.bg.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import softuni.bg.model.dto.DataDto;
import softuni.bg.service.DataService;

@RequestMapping("/api/data")
@RestController
public class HomeRestController {

    private final DataService dataService;

    public HomeRestController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping
    public ResponseEntity<DataDto> getStatistic() {
        DataDto data = this.dataService.getData();

        return ResponseEntity.ok(data);
    }
}
