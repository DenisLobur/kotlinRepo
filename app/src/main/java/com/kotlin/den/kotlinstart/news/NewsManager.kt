package com.kotlin.den.kotlinstart.news

import com.kotlin.den.kotlinstart.api.RestApi
import com.kotlin.den.kotlinstart.common.RedditNews
import com.kotlin.den.kotlinstart.common.RedditNewsItem
import rx.Observable

/**
 * NewsManager allows you to request news from Reddit.
 * Created by Denis on 29-Jan-17.
 */

class NewsManager(private val api: RestApi = RestApi()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews> {
        return Observable.create {
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments,
                            item.created, item.thumbnail, item.url)
                }
                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news
                )
                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}