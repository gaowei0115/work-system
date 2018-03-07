package com.mmc.work.system.tcp.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @packageName：com.mmc.work.system.tcp.utils
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-07 10:26
 * @history: (version) author date desc
 */
public class HttpClientMoreUtils {

    public static Object sendPost(String url, Object message) {

        // 1. 使用默认配置的httpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        // 2. 使用get方式
        HttpGet get = new HttpGet(url);

        CloseableHttpResponse response = null;
        try {
            response =  httpClient.execute(get);

            System.out.println(Thread.currentThread().getName() + " >>  status : " + response.getStatusLine().getStatusCode());

            HttpEntity entity = response.getEntity();
//            InputStream is = entity.getContent();

            if (entity != null) {
                System.out.println(Thread.currentThread().getName() + " >> " + EntityUtils.toString(entity, "UTF-8"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            if (get != null) {
                get.abort();
            }
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        String url = "http://www.baidu.com";
        ExecutorService executorService = new ThreadPoolExecutor(100, 10000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024), Executors.defaultThreadFactory());

        long start = System.currentTimeMillis();

        List<Future<Boolean>> resultList = new ArrayList<>();
        try {
            for (int i = 0; i < 100; i++) {
                Future<Boolean> result = executorService.submit(new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        sendPost(url, null);
                        return true;
                    }
                });
                resultList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

        for (Future<Boolean> future : resultList) {
            try {
                future.get();
            } catch (Exception e) {

            }
        }

        long end = System.currentTimeMillis();
        System.out.println("cost time " + (end - start) + " ms");
    }
}
