package pl.alicjajot.photobook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.alicjajot.photobook.domain.Photo;
import pl.alicjajot.photobook.dto.PhotoDto;
import pl.alicjajot.photobook.repository.PhotoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;
    private final PhotoMapper photoMapper;

    public List<PhotoDto> getAll() {
        List<Photo> photos = photoRepository.findAll();
        return photoMapper.mapToDtos(photos);
    }

    public PhotoDto getOne(Long id) {
        Photo photo = photoRepository.getOne(id);
        return photoMapper.mapToDto(photo);
    }

    public PhotoDto add(PhotoDto dto) {
        Photo photo = photoMapper.mapToEntity(dto);
        Photo savedPhoto = photoRepository.save(photo);
        return photoMapper.mapToDto(savedPhoto);
    }

    public void delete(Long id) {
        photoRepository.deleteById(id);
    }
}
