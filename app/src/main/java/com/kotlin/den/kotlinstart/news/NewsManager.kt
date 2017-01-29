package com.kotlin.den.kotlinstart.news

import com.kotlin.den.kotlinstart.common.RedditNewsItem
import rx.Observable

/**
 * Created by Denis on 29-Jan-17.
 */
class NewsManager() {

    fun getNews(after: String): Observable<List<RedditNewsItem>> {
        return Observable.create {
            subscriber ->
            val news = (1..10).map {
                RedditNewsItem(
                        "author$it",
                        "Title $it",
                        it,                                             // number of comments
                        1500000000L - it * 200,                         // time
                        "http://lorempixel.com/200/200/technics/$it",   // image url
                        "url"
                )
            }
            subscriber.onNext(news)
        }
    }
}