package com.example.dressshop.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.dressshop.adapter.MyViewPagerAdapter
import com.example.dressshop.databinding.FragmentHomeBinding
import com.example.dressshop.viewmodel.DressViewModel
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dressshop.adapter.ShirtListAdapter


class HomeFragment : Fragment() {

    private val viewModel: DressViewModel by viewModels()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewPager2: ViewPager2
    private lateinit var viewPagerAdapter: MyViewPagerAdapter
    private lateinit var dotsIndicator: DotsIndicator

    private lateinit var recyclerView: RecyclerView
    private lateinit var shirtListAdapter: ShirtListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewPager2 = binding.viewPager2
        dotsIndicator = binding.dotsIndicator
        viewPagerAdapter = MyViewPagerAdapter(viewModel.pictureViewModel)
        viewPager2.adapter = viewPagerAdapter
        viewPager2.offscreenPageLimit = 1
        dotsIndicator.setViewPager2(viewPager2)
        viewPager2.currentItem = 0

        viewPager2.setPageTransformer { page, position ->
            page.translationX = viewModel.calculateTranslationX(position)
            page.scaleY = viewModel.calculateScaleXAndY(position)
            page.scaleX = viewModel.calculateScaleXAndY(position)
        }

        recyclerView = binding.recyclerViewShirt
        shirtListAdapter = ShirtListAdapter(viewModel.shirtData)
        recyclerView.adapter = shirtListAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
