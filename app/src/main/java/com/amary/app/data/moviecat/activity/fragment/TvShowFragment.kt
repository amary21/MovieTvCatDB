package com.amary.app.data.moviecat.activity.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amary.app.data.moviecat.R
import com.amary.app.data.moviecat.activity.SettingActivity
import com.amary.app.data.moviecat.adapter.TvShowAdapter
import com.amary.app.data.moviecat.model.MovieTvCatData
import com.amary.app.data.moviecat.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_tv_show.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class TvShowFragment : Fragment() {

    private var movieTvCatData = ArrayList<MovieTvCatData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tv_show, container, false)
        movieTvCatData = DataDummy.getDummyTvshows(resources)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_tvshow.setHasFixedSize(true)
        setHasOptionsMenu(true)
        showRecyclerListTvShow()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list_rv, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mn_list -> showRecyclerListTvShow()
            R.id.mn_grid -> showRecyclerGridTvShow()
            R.id.mn_setting -> {
                val intent = Intent(activity, SettingActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerListTvShow() {
        val tvListAdapter = TvShowAdapter(context as Activity, false)
        tvListAdapter.setTvshow(movieTvCatData)

        rv_tvshow.layoutManager = LinearLayoutManager(activity)
        rv_tvshow.adapter = tvListAdapter
        tvListAdapter.notifyDataSetChanged()
    }

    private fun showRecyclerGridTvShow() {
        val tvGridAdapter = TvShowAdapter(context as Activity, true)
        tvGridAdapter.setTvshow(movieTvCatData)

        rv_tvshow.layoutManager = GridLayoutManager(activity, 2)
        rv_tvshow.adapter = tvGridAdapter
        tvGridAdapter.notifyDataSetChanged()
    }
}