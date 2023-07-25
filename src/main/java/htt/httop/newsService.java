package htt.httop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class newsService {

    private final newsRepository newsRepository;

    @Autowired
    public newsService(htt.httop.newsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<news> getNews(int page){
        return newsRepository.findAll();
    }
}
