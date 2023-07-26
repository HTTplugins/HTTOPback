package htt.httop.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class newsService {

    private final htt.httop.news.newsRepository newsRepository;

    @Autowired
    public newsService(newsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<news> getNews(int page){
        int pageSize = 10;
        int adjustedPage = page - 1;

        Pageable pageable = PageRequest.of(adjustedPage, pageSize);

        List<news> paginatedNews = newsRepository.findAllByOrderByPdateDesc(pageable);

        return paginatedNews;
    }
}
