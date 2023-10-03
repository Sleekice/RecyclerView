package com.tc.bottomnavigation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.bottomnavigation.databinding.FragmentHomeBinding
import com.tc.bottomnavigation.ui.notifications.NotificationAdapter
import com.tc.bottomnavigation.ui.notifications.data.CatFactItemModel
import java.util.ArrayList

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel.text.observe(viewLifecycleOwner) {
            // textView.text = it

        }

        adapter = HomeAdapter(arrayListOf())
        //recyclerview
        //layout Manager
        //Adapter
        binding.recyclerviewNotification.apply{

            layoutManager=LinearLayoutManager(context)
            adapter = HomeAdapter(homeViewModel.getUserList())
        }
        return root

    }

    private fun showData(getUserList: ArrayList<HomeViewModel>) {
        adapter.updateUserList(getUserList)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}