package com.olivix.flow_snikers_app.feature.sneaker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.olivix.flow_snikers_app.databinding.FragmentSneakersBinding
import com.olivix.flow_snikers_app.feature.sneaker.presentation.adapter.SneakerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SneakersFragment : Fragment() {
    private var _binding: FragmentSneakersBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SneakersViewModel by viewModel()
    private lateinit var adapter: SneakerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSneakersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SneakerAdapter()
        setUpRecycler()
        setUpObserver()
        viewModel.loadSnikersList()

       

    }

    private fun setUpRecycler() {
        binding.apply {
            recyclerSnikers.layoutManager = GridLayoutManager(context, 2)
            recyclerSnikers.adapter = adapter
        }
    }

    private fun setUpObserver() {
        val observer = Observer<SneakersViewModel.UiState>() {
            adapter.submitList(it.sneakersLoaded)
        }
        viewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}