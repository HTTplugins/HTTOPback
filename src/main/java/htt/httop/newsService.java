package htt.httop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;



import java.util.List;

@Service
public class newsService {

    private final newsRepository newsRepository;

    @Autowired
    public newsService(htt.httop.newsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<news> getNews(int page){
        int pageSize = 10;
        int adjustedPage = page - 1;

        // Crear una instancia de Pageable para la consulta paginada
        Pageable pageable = PageRequest.of(adjustedPage, pageSize);

        // Obtener los resultados paginados del repositorio

        List<news> paginatedNews = newsRepository.findAllByOrderByPublishDateDesc(pageable);

        return paginatedNews;
    }
}
