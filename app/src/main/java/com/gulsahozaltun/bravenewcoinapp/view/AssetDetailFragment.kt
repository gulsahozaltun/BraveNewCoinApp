package com.gulsahozaltun.bravenewcoinapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.gulsahozaltun.bravenewcoinapp.R
import com.gulsahozaltun.bravenewcoinapp.databinding.FragmentAssetDetailBinding


class AssetDetailFragment : Fragment() {
    private lateinit var design:FragmentAssetDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design= DataBindingUtil.inflate(inflater,R.layout.fragment_asset_detail, container, false)
        return design.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle : AssetDetailFragmentArgs by navArgs()
        var obj=bundle.assetArg
        design.detailObj=obj

        design.webView.settings.javaScriptEnabled=true
        design.webView.loadUrl(obj.url)

    }


}