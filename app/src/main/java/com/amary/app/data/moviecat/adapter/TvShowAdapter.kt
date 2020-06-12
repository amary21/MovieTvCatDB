package com.amary.app.data.moviecat.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.activity.DetailMovieTvActivity
import com.amary.app.data.moviecat.model.MovieTvCatData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_grid.view.*
import kotlinx.android.synthetic.main.item_rv_list.view.*

class TvShowAdapter(private val context: Context, private val grid : Boolean) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var movieTvCatData: MutableList<MovieTvCatData> = ArrayList()

    fun setTvshow(movieTvCatData: List<MovieTvCatData>){
        this.movieTvCatData.addAll(movieTvCatData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = if (grid) {
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_grid, parent, false)
        } else{
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_list, parent, false)
        }

        return ItemViewHolder(view)
    }

    private fun getItem(position: Int) : MovieTvCatData{
        return movieTvCatData[position]
    }

    override fun getItemCount(): Int {
        return movieTvCatData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(getItem(position), context, grid)
    }


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: MovieTvCatData, context: Context, grid: Boolean) {
            if (grid){
                itemView.tv_gd_judul.text = item.judul
                itemView.tv_gd_thn_rilis.text = item.thnRilis
                itemView.tv_gd_durasi.text = item.durasiMovie
                itemView.tv_gd_genre.text = item.genreMovie
                Glide.with(context)
                        .load(item.poster)
                        .into(itemView.img_gd_poster)
            } else{
                itemView.txt_judul.text = item.judul
                itemView.txt_thn_rilis.text = item.thnRilis
                itemView.txt_durasi.text = item.durasiMovie
                itemView.txt_genre.text = item.genreMovie
                Glide.with(context)
                        .load(item.poster)
                        .into(itemView.img_poster)
            }

            itemView.setOnClickListener {
                val intent = Intent(context, DetailMovieTvActivity::class.java)
                intent.putExtra(DetailMovieTvActivity.EXTRA_MOVIE, item)
                context.startActivity(intent)
            }
        }

    }

}