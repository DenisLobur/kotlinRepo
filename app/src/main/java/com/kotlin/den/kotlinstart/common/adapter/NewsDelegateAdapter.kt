package com.kotlin.den.kotlinstart.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kotlin.den.kotlinstart.R
import com.kotlin.den.kotlinstart.common.RedditNewsItem
import com.kotlin.den.kotlinstart.common.getFriendlyTime
import com.kotlin.den.kotlinstart.common.inflate
import com.kotlin.den.kotlinstart.common.loadImage
import kotlinx.android.synthetic.main.item_news.view.*

/**
 * Created by Denis on 28-Jan-17.
 */
class NewsDelegateAdapter: ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(parent.inflate(R.layout.item_news)) {
        fun bind(item: RedditNewsItem) = with(itemView) {
            img_thumbnail.loadImage(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
        }
    }
}