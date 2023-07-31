package htt.httop.news;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, String> {
    News findByTitle(String title);
    News findById(int id);

    //List<news> findAllByOrderByPublishDateDesc(Pageable pageable);
    List<News> findAllByOrderByPdateDesc(Pageable pageable);

}
