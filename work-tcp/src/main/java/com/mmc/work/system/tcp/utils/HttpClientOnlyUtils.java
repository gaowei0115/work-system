package com.mmc.work.system.tcp.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import sun.net.www.http.HttpClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @packageName：com.mmc.work.system.tcp.utils
 * @desrciption:
 * @author: gaowei
 * @date： 2018-03-07 10:59
 * @history: (version) author date desc
 */
public class HttpClientOnlyUtils {

    private static CloseableHttpClient httpclient = null;

    static {
        HttpClientBuilder builder = HttpClientBuilder.create();

        // socket config
        SocketConfig config = SocketConfig.custom().setSoKeepAlive(true).setTcpNoDelay(false).setSoTimeout(10000).setRcvBufSize(1024 * 1024)
                .setSndBufSize(1024 * 1024).build();

        // request config
        RequestConfig requestConfig = RequestConfig.custom().setCircularRedirectsAllowed(true).setRedirectsEnabled(true).setMaxRedirects(5).setConnectionRequestTimeout(10000).setConnectTimeout(10000)
                .setSocketTimeout(10000).build();

        // 设置builder属性
        builder.setMaxConnPerRoute(500).setMaxConnTotal(500).setDefaultSocketConfig(config).setDefaultRequestConfig(requestConfig);

        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(500);
        connectionManager.setDefaultMaxPerRoute(connectionManager.getMaxTotal());

        builder.setConnectionManager(connectionManager);

        httpclient = builder.build();
    }

    /**
     * 发送请求
     * @param url
     * @param message
     * @return
     */
    public static Object sendRequest(String url, Object message) {
        Object result = "";
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        try {
            httpGet = new HttpGet(url);
            response = httpclient.execute(httpGet);
            System.out.println("请求返回状态 status ：" + response.getStatusLine().getStatusCode());
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("请求返回结果：\n 【" + result + "】");
        } catch (Exception e) {
            System.out.println("send message exception : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (httpGet != null) {
                httpGet.abort();
            }
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    System.out.println("send message exception : " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        return result;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        ExecutorService executorService = new ThreadPoolExecutor(100, 1000, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), Executors.defaultThreadFactory());

        String url = "http://www.baidu.com";
        List<Future<Boolean>> futureList = new ArrayList<>();
        try {
            for (int i = 0; i < 1000; i++) {
                Future<Boolean> result = executorService.submit(new Callable<Boolean>() {

                    @Override
                    public Boolean call() throws Exception {
                        sendRequest(url, null);
                        return true;
                    }
                });
                futureList.add(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }

        for (Future<Boolean> future : futureList) {
            try {
                future.get();
            } catch (Exception e) {

            }
        }

        long end = System.currentTimeMillis();

        System.out.println("cost time : " + (end - start) + " ms");
    }
}
