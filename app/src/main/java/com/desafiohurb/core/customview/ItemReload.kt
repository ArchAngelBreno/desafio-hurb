package com.desafiohurb.core.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.desafiohurb.R

class ItemReload @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0):
    LinearLayout(context, attrs, defStyleAttr) {

    var loading: ProgressBar
    var buttonRetry: ImageView

    init {
        inflate(context, R.layout.custom_view_loading_error_item, this)
        loading = findViewById(R.id.progressLoadingBottom)
        buttonRetry = findViewById(R.id.errorOnLoadListRetry)
    }

    fun showLoading() {
        loading.visibility = View.VISIBLE
        buttonRetry.visibility = View.GONE
    }

    fun showErrorRetry() {
        buttonRetry.visibility = View.VISIBLE
        loading.visibility = View.GONE
    }
}