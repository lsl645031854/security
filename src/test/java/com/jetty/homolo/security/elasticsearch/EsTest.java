package com.jetty.homolo.security.elasticsearch;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetRequest;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author homolo
 * @DESC
 * @Create 2019-12-04  下午12:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTest {

	@Autowired
	private RestHighLevelClient highLevelClient;

	@Test
	public void testSearch() throws IOException {
		MultiGetRequest multiGetRequest = new MultiGetRequest();
		multiGetRequest.add("lib2", "2");
		multiGetRequest.add("lib2", "1");
		multiGetRequest.add("lib2", "3");
		MultiGetResponse mgResponse = highLevelClient.mget(multiGetRequest, RequestOptions.DEFAULT);
		MultiGetItemResponse[] responses = mgResponse.getResponses();
		for (MultiGetItemResponse mult : responses) {
			GetResponse response = mult.getResponse();
			String source = response.getSourceAsString();
			System.out.println(source);
		}
	}

	@Test
	public void testAdd() throws Exception { // 同步添加数据
		IndexRequest indexRequest = new IndexRequest("lib");
		indexRequest.id("6");
		Map<String, Object> map = new HashMap<>();
		map.put("name", "张三");
		indexRequest.source(map);
		IndexResponse index = highLevelClient.index(indexRequest, RequestOptions.DEFAULT);
	}

}
