package pl.alicjajot.photobook.service;

import org.springframework.stereotype.Component;
import pl.alicjajot.photobook.domain.Photo;
import pl.alicjajot.photobook.dto.PhotoDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PhotoMapper {

    public List<PhotoDto> mapToDtos(List<Photo> photos) {
        return photos.stream()
                .map(photo -> mapToDto(photo))
                .collect(Collectors.toList());
    }

    public PhotoDto mapToDto(Photo photo) {
        PhotoDto dto = new PhotoDto();
        dto.setId(photo.getId());
        dto.setName(photo.getName());
        return dto;
    }

    public Photo mapToEntity(PhotoDto dto) {
        Photo photo = new Photo();
        photo.setId(dto.getId());
        photo.setName(dto.getName());
        return photo;
    }
}
