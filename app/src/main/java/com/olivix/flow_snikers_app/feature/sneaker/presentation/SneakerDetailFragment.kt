package com.olivix.flow_snikers_app.feature.sneaker.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.olivix.flow_snikers_app.databinding.FragmentDetailSneakerBinding
import com.olivix.flow_snikers_app.feature.sneaker.domain.Sneaker
import org.koin.androidx.viewmodel.ext.android.viewModel


class SneakerDetailFragment : Fragment() {
    private var _binding: FragmentDetailSneakerBinding? = null
    private val binding get() = _binding!!
    private val args: SneakerDetailFragmentArgs by navArgs()
    private val sneakerDetailViewModel: SneakerDetailViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailSneakerBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObserver()
        sneakerDetailViewModel.loadSneakerDetail(args.sneakerId)

        binding.apply {
            //Navegar hacia atras al pulsar el icono de la barr
            topApp.topAppBar.setNavigationOnClickListener {
                findNavController().navigateUp()

            }
        }

    }

    private fun setUpObserver() {
        val observer = Observer<SneakerDetailViewModel.UiState>() {
            if (it.isLoading) {
                //
            }
            if (it.error) {
                //Mostrar pantalla de error de carga especial.
            }
            bindInfo(it.sneakerLoaded)
        }
        sneakerDetailViewModel.uiState.observe(viewLifecycleOwner, observer)
    }

    private fun bindInfo(sneakerLoaded: Sneaker?) {
        binding.apply {
            textShoeName.text = sneakerLoaded?.shoeName
            textBrand.text = sneakerLoaded?.brand
            textColorway.text = sneakerLoaded?.colorway
            textReleaseDate.text = sneakerLoaded?.releaseDate
            textDescription.text = sneakerLoaded?.description
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}