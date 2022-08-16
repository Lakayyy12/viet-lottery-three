package com.application.vietlotterytri

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val onItemClicked: OnContentClickListener
): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    //Title and Description
    private var titles = arrayOf("1.Chọn xổ số để chơi", "2.Chọn số của bạn", "3.Mua vé", "4.Kiểm tra số của bạn", "5.Yêu cầu giải thưởng")
    private var details = arrayOf("HƯỚNG DẪN 1", "HƯỚNG DẪN 2", "HƯỚNG DẪN 3", "HƯỚNG DẪN 4", "HƯỚNG DẪN 5")

    private var contents = intArrayOf(R.string.gp1, R.string.gp2, R.string.gp3, R.string.gp4, R.string.gp5)

    //Images
    private var images = intArrayOf(R.drawable.banner2,R.drawable.banner2,R.drawable.banner2,R.drawable.banner2,R.drawable.banner2)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout2, parent, false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
        return  titles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])

        holder.itemView.setOnClickListener{
            onItemClicked.OnContentItemClicked(images[position], contents[position])
        }
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.item_image)
        var itemTitle: TextView = itemView.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView.findViewById(R.id.item_detail)
    }
}