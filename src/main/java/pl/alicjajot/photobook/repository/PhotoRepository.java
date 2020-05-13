package pl.alicjajot.photobook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.alicjajot.photobook.domain.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
