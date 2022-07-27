package com.khalil.newsapp;

import com.khalil.newsapp.Models.NewsHeadLines;

import java.util.List;

public interface ONFetchDataListener<NewsApiResponse> {
    void onFetchData(List<NewsHeadLines> list,String message);
    void onError(String message);
}
