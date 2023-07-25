package htt.httop;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface newsRepository extends JpaRepository<news, String> {
    news findByTitle(String title);
    news findById(int id);

    List<news> findAllByOrderByPublishDateDesc(Pageable pageable);
}
