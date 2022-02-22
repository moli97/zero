package top.imoli.zero.controller;

import org.springframework.web.bind.annotation.*;
import top.imoli.spider.entity.Book;
import top.imoli.spider.entity.Result;
import top.imoli.spider.entity.Search;
import top.imoli.spider.task.BookTask;
import top.imoli.spider.task.SearchTask;

import java.util.List;

/**
 * @author moli@hulai.com
 * @date 2022/2/22 2:23 PM
 */
@RestController
@RequestMapping("/spider")
public class SpiderController {

    @GetMapping("/search")
    public Object search(@RequestParam String keyWord) {
        SearchTask task = new SearchTask(keyWord);
        task.run();
        Search search = task.getSearch();
        List<Result> results = search.getList();
        return results;
    }

    @GetMapping("/down")
    public String down(@RequestParam String url) {
        BookTask task = new BookTask(url);
        Book call = task.call();
        return call.toText();
    }
}
