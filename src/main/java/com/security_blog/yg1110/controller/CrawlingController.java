package com.security_blog.yg1110.controller;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security_blog.yg1110.domain.Post;
import com.security_blog.yg1110.domain.User;
import com.security_blog.yg1110.servicer.IPostService;

@RestController
public class CrawlingController {
	@Autowired
	private IPostService postService;

	@GetMapping(value = "/test")
	public String crawling(User user) throws MessagingException, IOException {

		Connection.Response response = Jsoup.connect("https://yg1110.tistory.com/")

        .method(Connection.Method.GET)
        .execute();

		Document document = response.parse();
		Element element = document.select(".inner").get(1);
		List<String> links = element.select(".post-item a").eachAttr("href");
		List<String> titles = element.select(".post-item .title").eachText();
		List<String> excerpts = element.select(".post-item .excerpt").eachText();
		List<String> thums = element.select(".post-item .thum img").eachAttr("src");
		
		for (int i=0; i<links.size(); i++) {
			Connection.Response response2 = Jsoup.connect("https://yg1110.tistory.com/"+links.get(i))
			        .method(Connection.Method.GET)
			        .execute();
			
			Document document2 = response2.parse();
			String date = document2.select(".post-meta .date").text();
			Element element2 = document2.select(".tt_article_useless_p_margin").first();
			element2.select(".container_postbtn").remove();
			String content = element2.html();
			String datesplit[] = date.replace(".", "").split(" ");
			if(Integer.parseInt(datesplit[1]) > 0 && Integer.parseInt(datesplit[1])<10) {
				datesplit[1] = "0" + datesplit[1];
			}
			if(Integer.parseInt(datesplit[2]) > 0 && Integer.parseInt(datesplit[2])<10) {
				datesplit[2] = "0" + datesplit[2];
			}

			String datetime = datesplit[0] + "-" + datesplit[1] + "-" + datesplit[2] + " " + datesplit[3];

			Post post = new Post(titles.get(i), content, datetime, thums.get(i), excerpts.get(i));

			postService.postwrite(post);
		}
		return null;
	}
}
