package pl.alicjajot.photobook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.alicjajot.photobook.dto.PhotoDto;
import pl.alicjajot.photobook.service.PhotoService;

import java.util.List;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    // TODO Zróbmy @RequestParam String name na filtrowanie
    @GetMapping
    public List<PhotoDto> getAll() {
        return photoService.getAll();
    }

    @GetMapping("/{id}")
    public PhotoDto get(@PathVariable Long id) {
        return photoService.getOne(id);
    }

    @PostMapping
    public PhotoDto add(@RequestBody PhotoDto dto) {
        return photoService.add(dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photoService.delete(id);
    }
}
