package com.zego.util;

import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

    /**
     * http GET 请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String httpGet(String url) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(60000).setConnectTimeout(60000).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    /**
     * http GET 请求
     * @param url
     * @param timeout 超时时间
     * @return
     * @throws Exception
     */
    public static String httpGet(String url, int timeout) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(timeout).setConnectTimeout(timeout).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity);
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    /**
     * http GET 请求
     * @param url
     * @param defaultCharset 编码例如UTF-8
     * @return
     * @throws Exception
     */
    public static String httpGet(String url, String defaultCharset) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000).build();
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, defaultCharset);
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    /**
     * http POST 请求
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public static String httpPost(String url, Map<String, Object> params) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(100000).setConnectTimeout(100000).build();
        httpPost.setConfig(requestConfig);
        //拼接参数
        java.util.List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        for (String key : params.keySet()) {
            if(params.get(key)!=null) {
                nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
            }else {
                nvps.add(new BasicNameValuePair(key, null));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);

        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    public static String httpPost(String url, java.util.List<NameValuePair> nvps) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(25000).build();
        httpPost.setConfig(requestConfig);
        //拼接参数
//        java.util.List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        for (String key : params.keySet()) {
//            nvps.add(new BasicNameValuePair(key, params.get(key).toString()));
//        }
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
        CloseableHttpResponse response = httpClient.execute(httpPost);

        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    /**
     * http post
     * @param url
     * @param jsonParam
     * @return
     * @throws Exception
     */
    public static String httpPost(String url, String jsonParam) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //设置最大请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(25000).build();
        httpPost.setConfig(requestConfig);
        //参数
        //解决中文乱码问题
        StringEntity entityParam = new StringEntity(jsonParam.toString(), "utf-8");
        entityParam.setContentEncoding("UTF-8");
        entityParam.setContentType("application/json");
        httpPost.setEntity(entityParam);
        CloseableHttpResponse response = httpClient.execute(httpPost);

        try {
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity entity = response.getEntity();
                result = EntityUtils.toString(entity, "utf-8");
                EntityUtils.consume(entity);
            } else {
                throw new Exception(response.getStatusLine().toString());
            }
        } finally {
            response.close();
        }
        return result;
    }

    /**
     * es索引http post请求 创建更新索引
     * @param esSearchUrl
     * @param json
     * @throws Exception
     */
    public static String esHttpPost(String url, String json) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(25000)
                    .build();
            httpPost.setConfig(requestConfig);
            StringEntity stringentity = new StringEntity(json, ContentType.create("text/json", "UTF-8"));
            httpPost.setEntity(stringentity);
            response = httpClient.execute(httpPost);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * es索引http delete请求 删除索引
     * @param esSearchUrl
     * @throws Exception
     */
    public static String esHttpDelete(String url) throws Exception {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            HttpDelete httpDelete = new HttpDelete(url);
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(25000)
                    .build();
            httpDelete.setConfig(requestConfig);
            response = httpClient.execute(httpDelete);
            return EntityUtils.toString(response.getEntity());
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
            if (response != null) {
                response.close();
            }
        }
    }
}
