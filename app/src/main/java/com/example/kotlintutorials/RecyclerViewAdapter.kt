package com.example.kotlintutorials

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintutorials.databinding.ListItemBinding
import com.example.kotlintutorials.db.Subscriber

class RecyclerViewAdapter(private val clickListener: (Subscriber) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    private val subscribersList= ArrayList<Subscriber>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(subscribersList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return subscribersList.size
    }

    fun setList(subscriber: List<Subscriber>){
        subscribersList.clear()
        subscribersList.addAll(subscriber)
    }

}

class ViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit) {
        binding.tvListName.text = subscriber.name
        binding.tvListEmail.text = subscriber.email
        binding.llListItem.setOnClickListener {
            clickListener(subscriber)
        }
    }
}