package htt.httop.news;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/news")
public class newsController {
    private final newsService newsService;


    public newsController(newsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/getNews")
    public List<news> getNews(@RequestBody int page){
        return newsService.getNews(page);
    }
}
