package htt.httop.news;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.Date;
import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News getDetailedNews(int id){
        return newsRepository.findById(id);
    }
    public List<News> getNews(int page){
        int pageSize = 10;
        int adjustedPage = page - 1;

        Pageable pageable = PageRequest.of(adjustedPage, pageSize);

        List<News> paginatedNews = newsRepository.findAllByOrderByPdateDesc(pageable);

        return paginatedNews;
    }

    public News addNews(News news){
        news.setPdate(new Date());
        return newsRepository.save(news);
    }

    @Transactional
    public void deleteNews(int id){
         newsRepository.deleteById(id);
    }
}
