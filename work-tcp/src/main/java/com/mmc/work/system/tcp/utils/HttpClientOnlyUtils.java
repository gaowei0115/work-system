package com.mmc.work.system.tcp.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
        SocketConfig config = SocketConfig.custom().setSoKeepAlive(true).setTcpNoDelay(true).setSoTimeout(10000).setRcvBufSize(1024 * 1024)
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
        InputStream is = null;
        try {
            httpGet = new HttpGet(url);
            httpGet.setHeader(HttpHeaders.CONNECTION, "close");
            response = httpclient.execute(httpGet);
            System.out.println("请求返回状态 status ：" + response.getStatusLine().getStatusCode());
            int status = response.getStatusLine().getStatusCode();
            if (status != 200) {
                // 如果获取响应状态不是200成功，则释放连接
                httpGet.abort();
                return null;
            }
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sb = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sb.append(temp);
                }
                System.out.println("请求返回结果：\n 【" + sb.toString() + "】");
                return sb.toString();
            }
        } catch (Exception e) {
            System.out.println("send message exception : " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (httpGet != null) {
                try {
                    httpGet.releaseConnection();
                } catch (Exception e) {
                    httpGet.releaseConnection();
                    e.printStackTrace();
                }
            }
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    System.out.println("send message exception : " + e.getMessage());
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
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

//        final String url = "http://10.4.3.122:8992/match-web/getIhsData.uz";
        final String url = "http://www.baidu.com";
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
