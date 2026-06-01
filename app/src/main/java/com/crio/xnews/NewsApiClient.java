package com.crio.xnews;

import java.io.IOException;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NewsApiClient {

    private static final String API_URL = "https://newsapi.org/v2/everything";
    private static final String API_KEY = "c106f83df14741c682ee699d5d6aabbf";

    private final OkHttpClient client;

    public NewsApiClient() {
        this.client = new OkHttpClient();
    }

    public List<NewsArticle> fetchNewsArticles(String query,
            String language,
            String sortBy) throws IOException {

        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query parameter must not be empty");
        }

        String url = buildUrl(query, language, sortBy);

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("HTTP error code: " + response.code());
            }

            ResponseBody body = response.body();
            if (body == null) {
                throw new IOException("Empty response body");
            }

            String responseString = body.string();
            return NewsParser.parse(responseString);
        }
    }

    private String buildUrl(String query, String language, String sortBy) {

        if (query == null || query.trim().isEmpty()) {
            throw new IllegalArgumentException("Query parameter must not be empty");
        }

        StringBuilder urlBuilder = new StringBuilder(API_URL);
        urlBuilder.append("?apiKey=").append(API_KEY);
        urlBuilder.append("&q=").append(query);

        if (language != null && !language.trim().isEmpty()) {
            urlBuilder.append("&language=").append(language);
        }

        if (sortBy != null && !sortBy.trim().isEmpty()) {
            urlBuilder.append("&sortBy=").append(sortBy);
        }

        return urlBuilder.toString();
    }
}
