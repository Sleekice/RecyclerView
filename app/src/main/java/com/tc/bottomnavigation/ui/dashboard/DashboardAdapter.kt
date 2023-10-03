package com.tc.bottomnavigation.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tc.bottomnavigation.R
import com.tc.bottomnavigation.databinding.ItemDashboardUserBinding
import com.tc.bottomnavigation.ui.home.HomeAdapter


class DashboardAdapter (private val dashboardData:DashboardViewModel):RecyclerView.Adapter<DashboardAdapter.CustomViewHolder>(){

    class CustomViewHolder(view: View): RecyclerView.ViewHolder(view){
        private val binding =ItemDashboardUserBinding.bind(view)

        fun setupUI(title: String, description:  String, image:Int) {
            binding.toptext.text = title
            binding.bottomtext.text = description
            binding.imageView.setImageResource(image) // Get image resource from DashboardViewModel


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard_user, parent, false)
        return CustomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dashboardData.getNames().size
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.setupUI(
        dashboardData.getNames().elementAt(position),
        dashboardData.getDescription().elementAt(position),
        dashboardData.getImages().elementAt(position)
        )
    }
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ):CustomViewHolder {
//        return CustomViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard_user, parent, false)
//        )
//    }

//    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
//        holder.setupUI(userList[position],position)
//    }


    //    override fun getItemCount(): Int {
//    return  userList.size
//    }
//    //simpler way to do the above
//    override fun getItemCount() =userList.size



}