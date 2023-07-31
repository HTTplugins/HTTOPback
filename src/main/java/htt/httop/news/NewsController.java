package htt.httop.news;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;


    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/getNews")
    public List<News> getNews(@RequestBody int page){
        return newsService.getNews(page);
    }

    @PostMapping("/addNews")
    public News addNews(@RequestBody News news){

        return newsService.addNews(news);
    }


    @PostMapping("/getDetailedNews")
    public News getDetailedNews(@RequestBody int id){
        return newsService.getDetailedNews(id);
    }
}
