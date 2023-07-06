package com.example.myshop.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myshop.model.Product
import com.example.myshop.databinding.ProductListItemBinding

class ProductRvAdapter (val ProductList: List<Product>) : RecyclerView.Adapter<ProductRvAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ProductListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        var currentProduct = ProductList.get(position)
        var binding = holder.binding
        binding.tvId.text = currentProduct.id.toString()
        binding.tvTitle.text = currentProduct.title
        binding.tvDescription.text = currentProduct.description
        binding.tvPrice.text =currentProduct.price.toString()
        binding.tvRating.text =currentProduct.rating.toString()
        binding.tvStock.text = currentProduct.stock.toString()
        binding.tvBrand.text = currentProduct.brand
        binding.tvCategory.text = currentProduct.category
        binding.tvThumbnail.text = currentProduct.thumbnail
    }

    override fun getItemCount(): Int {
        return ProductList.size
    }
    class ProductViewHolder(var binding: ProductListItemBinding) : RecyclerView.ViewHolder(binding.root)

}