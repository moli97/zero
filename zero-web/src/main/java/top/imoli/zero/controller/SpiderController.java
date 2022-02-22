package top.imoli.zero.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.imoli.spider.entity.Book;
import top.imoli.spider.entity.Result;
import top.imoli.spider.entity.Search;
import top.imoli.spider.task.BookTask;
import top.imoli.spider.task.SearchTask;
import top.imoli.zero.model.entity.ParserRuleDemo;
import top.imoli.zero.model.mapper.ParserRuleMapper;

import java.util.List;

/**
 * @author moli@hulai.com
 * @date 2022/2/22 2:23 PM
 */
@RestController
@RequestMapping("/spider")
public class SpiderController {

    @Autowired
    private ParserRuleMapper parserRuleMapper;

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

    @GetMapping("/parserRuleList")
    public Object getParserRuleList() {
        List<ParserRuleDemo> allParserRule = parserRuleMapper.getAllParserRule();
        if (allParserRule.isEmpty()) {
            ParserRuleDemo demo = JSON.parseObject("{\"authorSet\":{\"list\":[{\"args\":[],\"param\":\".info > .small > span\",\"type\":1},{\"args\":[],\"type\":3},{\"args\":[\"作者：\",\"\"],\"param\":\"replace\",\"type\":8}]},\"baseUrl\":\"https://www.bige7.com\",\"chapterListSet\":{\"list\":[{\"args\":[],\"param\":\".listmain > dl\",\"type\":1},{\"args\":[],\"param\":\"dd:not(.more) > a\",\"type\":2}]},\"chapterSet\":{\"list\":[{\"args\":[],\"param\":\"#chaptercontent\",\"type\":1},{\"args\":[],\"param\":\"top.imoli.spider.parser.Parser@getText\",\"type\":9},{\"args\":[],\"param\":\"top.imoli.spider.config.Replace@handle\",\"type\":9}]},\"nameSet\":{\"list\":[{\"args\":[],\"param\":\".info > h1\",\"type\":1},{\"args\":[],\"type\":3}]}}\n", ParserRuleDemo.class);
            System.out.println(JSON.toJSONString(demo));
            parserRuleMapper.insert(demo);
        }
        return allParserRule;
    }
}
