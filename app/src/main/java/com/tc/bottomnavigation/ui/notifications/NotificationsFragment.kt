package com.tc.bottomnavigation.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tc.bottomnavigation.databinding.FragmentNotificationsBinding
import com.tc.bottomnavigation.ui.notifications.data.CatFactItemModel
import java.util.ArrayList

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var adapter: NotificationAdapter

//    var counter: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        notificationsViewModel.catFact.observe(viewLifecycleOwner) {
            it?.let {
//                showData(it)
                binding.recyclerviewNotification.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = NotificationAdapter(it)
                }
            }
        }

        notificationsViewModel.catImage.observe(viewLifecycleOwner) {
            it?.let {
                //Handle the image here
            }
        }

        adapter = NotificationAdapter(arrayListOf())

//        binding.recyclerviewNotification.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = adapter
//        }

        notificationsViewModel.getCatFacts()
        notificationsViewModel.getCatImage()

        return root
    }

    private fun showData(catFacts: ArrayList<CatFactItemModel>) {
        adapter.updateList(catFacts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}