package htt.httop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface newsRepository extends JpaRepository<news, String> {
    news findByTitle(String title);
    news findById(int id);
}
