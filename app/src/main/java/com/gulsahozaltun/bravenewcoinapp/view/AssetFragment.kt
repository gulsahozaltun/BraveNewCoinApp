package com.gulsahozaltun.bravenewcoinapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.gulsahozaltun.bravenewcoinapp.R
import com.gulsahozaltun.bravenewcoinapp.adapter.AssetAdapter
import com.gulsahozaltun.bravenewcoinapp.databinding.FragmentAssetBinding
import com.gulsahozaltun.bravenewcoinapp.viewModel.CryptoDataViewModel


class AssetFragment : Fragment() {
    private lateinit var viewModel:CryptoDataViewModel
    private lateinit var adapter:AssetAdapter
    private lateinit var binding:FragmentAssetBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_asset, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: CryptoDataViewModel by viewModels()
        viewModel=temp

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()


/*        viewModel.assetList.observe(viewLifecycleOwner,{ list ->
            adapter= AssetAdapter(requireContext(),list)
            binding.assetAdapter=adapter

        })*/
    }
    private fun observeLiveData() {

        viewModel.downloadData()

        viewModel.assets.observe(viewLifecycleOwner) {
            adapter = AssetAdapter(requireContext(),ArrayList(it))
            binding.assetAdapter=adapter
            binding.assetList.visibility = View.VISIBLE
        }

        viewModel.assetError.observe(viewLifecycleOwner) {
            if(it) {
                //hata var
                binding.countryError.visibility = View.VISIBLE
            } else {
                //hata yok
                binding.countryError.visibility = View.GONE
            }
        }

        viewModel.assetLoading.observe(viewLifecycleOwner) {
            if (it) {
                //yükleniyor
                binding.countryLoading.visibility = View.VISIBLE
                binding.assetList.visibility = View.GONE
                binding.countryError.visibility = View.GONE
            } else {
                binding.countryLoading.visibility = View.GONE
            }
        }

    }

}