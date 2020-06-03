package com.sun_asterisk.shared.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {
    private var itemData: T? = null

    init {
        itemView.setOnClickListener {
            itemData?.let { onItemClickListener(it) }
        }
    }

    open fun onBindData(itemData: T) {
        this.itemData = itemData
    }

    open fun onItemClickListener(itemData: T) {}
}
