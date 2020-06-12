package com.amary.app.data.moviecat.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.activity.DetailMovieActivity
import com.amary.app.data.moviecat.model.MovieCatData
import kotlinx.android.synthetic.main.item_moviecat.view.*
import java.util.*
import kotlin.collections.ArrayList

class MovieCatAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var movieCatData: MutableList<MovieCatData> = ArrayList()

    fun setMovieCatData(movieCatData: ArrayList<MovieCatData>) {
        this.movieCatData.addAll(movieCatData)
        notifyDataSetChanged()
    }

    private fun getItem(position: Int): MovieCatData {
        return movieCatData[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_moviecat, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieCatData.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(getItem(position), context)
    }

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: MovieCatData, context: Context) {
            itemView.img_poster.setImageResource(item.poster)
            itemView.txt_durasi.text = item.judul
            itemView.txt_thn_rilis.text = item.thnRilis
            itemView.txt_durasi.text = item.durasiMovie
            itemView.txt_genre.text = item.genreMovie

            itemView.setOnClickListener {
                val intent = Intent(context, DetailMovieActivity::class.java)
                intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, item)
                context.startActivity(intent)
            }
        }

    }
}