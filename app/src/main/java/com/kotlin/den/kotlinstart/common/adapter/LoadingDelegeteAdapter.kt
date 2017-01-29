package com.kotlin.den.kotlinstart.common.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kotlin.den.kotlinstart.R
import com.kotlin.den.kotlinstart.common.inflate

/**
 * Created by Denis on 28-Jan-17.
 */
class LoadingDelegeteAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_loading))
}