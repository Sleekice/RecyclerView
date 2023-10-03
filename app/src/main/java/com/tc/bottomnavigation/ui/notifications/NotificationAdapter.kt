package com.tc.bottomnavigation.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tc.bottomnavigation.R
import com.tc.bottomnavigation.databinding.ItemNotificationBinding
import com.tc.bottomnavigation.ui.notifications.data.CatFactItemModel

class NotificationAdapter(private val dataList: ArrayList<CatFactItemModel>) :
    RecyclerView.Adapter<NotificationAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemNotificationBinding.bind(view)
        fun updateItemUI(catDetails: CatFactItemModel, position: Int) {
            binding.catTitle.text = catDetails.text
            //binding.catDescription.text = "${catDetails.type} $position"


            binding.catDescription.text =catDetails.source

            Glide
                .with(itemView.context)
                .load(
                    when {
                        position % 5 == 0 -> "https://cdn2.thecatapi.com/images/em.jpg"
                        position % 4 == 0 -> "https://cdn2.thecatapi.com/images/ck4.jpg"
                        position % 3 == 0 -> "https://cdn2.thecatapi.com/images/405.jpg"
                        position % 2 == 0 -> "https://cdn2.thecatapi.com/images/ao5.jpg"
                        else -> "https://cdn2.thecatapi.com/images/178.jpg"
                    }
                )
                .centerCrop() // Scale Type for the image
                .placeholder(R.drawable.ic_home_black_24dp) // in case of error/loading a demo image
                .into(binding.catImage);

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_notification, parent, false)
    )

    override fun getItemCount() = dataList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.updateItemUI(dataList[position], position)
    }

    fun updateList(catFacts: java.util.ArrayList<CatFactItemModel>) {
        dataList.addAll(catFacts)
        notifyDataSetChanged() // updates/reloads the changed data
    }
}