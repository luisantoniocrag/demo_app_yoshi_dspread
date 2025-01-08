package com.example.dspread_yoshi_basic_use_case.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dspread_yoshi_basic_use_case.databinding.ItemErrorMessageBinding

class MessageErrorsRecyclerView(
    var items: List<String>
) : RecyclerView.Adapter<MessageErrorsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageErrorsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemErrorMessageBinding.inflate(inflater, parent, false)
        return MessageErrorsViewHolder(binding.root)
    }

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: MessageErrorsViewHolder, position: Int) {
        items[position]?.let {
            holder.bind(it)
        }
    }

}


class MessageErrorsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemErrorMessageBinding.bind(view)

    fun bind(message: String) {
        binding.tvErrorMessage.text = message
    }

}