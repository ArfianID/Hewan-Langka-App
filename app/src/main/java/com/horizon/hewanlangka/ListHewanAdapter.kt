package com.horizon.hewanlangka

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListHewanAdapter(private val listHewan: ArrayList<Hewan>): RecyclerView.Adapter<ListHewanAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAsal: TextView = itemView.findViewById(R.id.tv_asal)
        var tvPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_hewan, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listHewan.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val hewan = listHewan[position]

        Glide.with(holder.itemView.context)
            .load(hewan.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.tvPhoto)

        holder.tvName.text = hewan.name
        holder.tvAsal.text = hewan.asal

        val context = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(context, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_NAME, hewan.name)
            moveDetail.putExtra(DetailActivity.EXTRA_ASAL, hewan.asal)
            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO, hewan.photo)
            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO1, hewan.photo1)
            moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, hewan.detail)
            context.startActivity(moveDetail)
        }
    }

}