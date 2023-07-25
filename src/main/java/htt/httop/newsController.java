package htt.httop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class newsController {
    private final newsService newsService;

    @Autowired
    public newsController(htt.httop.newsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping("/getNews")
    public List<news> getNews(@RequestBody int page){
        return newsService.getNews(page);
    }
}
