package com.olivix.flow_snikers_app.feature.sneaker.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.faltenreich.skeletonlayout.Skeleton
import com.faltenreich.skeletonlayout.applySkeleton
import com.google.android.material.tabs.TabLayout
import com.olivix.flow_snikers_app.R
import com.olivix.flow_snikers_app.databinding.FragmentSneakersBinding
import com.olivix.flow_snikers_app.feature.sneaker.presentation.adapter.SneakerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SneakersFragment : Fragment() {
    private var _binding: FragmentSneakersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SneakersViewModel by viewModel()
    private val skeletonView: Skeleton by lazy {
        binding.recyclerSnikers.applySkeleton(R.layout.item_skeleton_sneaker, 6)
    }
    private lateinit var adapter: SneakerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSneakersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SneakerAdapter { sneaker ->
            navigateToDetail(sneaker.styleID)
        }
        setupRecycler()
        setupObserver()
        setupTabLayout()
        viewModel.loadSnikersList()
    }

    private fun setupRecycler() {
        binding.recyclerSnikers.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@SneakersFragment.adapter
        }
    }

    private fun setupObserver() {
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            if (state.isLoading) {
                // Solo aquí muestras el skeleton
                skeletonView.showSkeleton()
                Log.d("@dev", "loading = True")
            } else {
                // En todos los demás casos (error o datos listos)
                skeletonView.showOriginal()
                adapter.submitList(state.sneakersLoaded)
            }
        }
    }

    private fun setupTabLayout() {
        // 1. Configurar listener primero
        binding.tab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {

                viewModel.filterSneakersByBrand(tab.text?.toString(), tab.position)

            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        // 2. Restaurar posición después de configurar listener
        requireView().post {
            if (viewModel.selectedTabIndex < binding.tab.tabCount) {
                binding.tab.getTabAt(viewModel.selectedTabIndex)?.select()
            }
        }
    }

    private fun navigateToDetail(sneakerId: String) {
        findNavController().navigate(
            SneakersFragmentDirections.actionSneakersFragmentToSneakerDetailFragment(sneakerId)
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}