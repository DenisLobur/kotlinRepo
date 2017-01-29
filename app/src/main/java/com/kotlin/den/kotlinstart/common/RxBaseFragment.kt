package com.kotlin.den.kotlinstart.common

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by Denis on 29-Jan-17.
 */
open class RxBaseFragment: Fragment() {
    protected var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        if(!subscriptions.isUnsubscribed) {
            subscriptions.unsubscribe()
        }
        subscriptions.clear()
    }
}