package com.gulsahozaltun.bravenewcoinapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gulsahozaltun.bravenewcoinapp.databinding.AssetCardBinding
import com.gulsahozaltun.bravenewcoinapp.model.AssetDataModel
import com.gulsahozaltun.bravenewcoinapp.view.AssetFragmentDirections

class AssetAdapter(var mContext:Context,
                    var assetList:List<AssetDataModel> ):RecyclerView.Adapter<AssetAdapter.CardDesignHolder>() {

     val colors:Array<String> = arrayOf("#161b1e","#1d2226")

    inner class CardDesignHolder(assetCardBinding: AssetCardBinding):RecyclerView.ViewHolder(assetCardBinding.root){
        var cardDesign:AssetCardBinding
        init {
            this.cardDesign=assetCardBinding
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val layoutInflater=LayoutInflater.from(mContext)
        val design=AssetCardBinding.inflate(layoutInflater,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val obj=assetList.get(position)
        val view=holder.cardDesign
        view.cardView.setBackgroundColor(Color.parseColor(colors[position %2]))
        view.assetObj=obj

        view.buttonDetail.setOnClickListener {
            val nav = AssetFragmentDirections.assettoDetail(obj)
            Navigation.findNavController(it).navigate(nav)
        }

    }

    override fun getItemCount(): Int {
        return assetList.size
    }
}