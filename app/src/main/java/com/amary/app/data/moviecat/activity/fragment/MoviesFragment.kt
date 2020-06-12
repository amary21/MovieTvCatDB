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
import com.amary.app.data.moviecat.adapter.MovieAdapter
import com.amary.app.data.moviecat.model.MovieTvCatData
import com.amary.app.data.moviecat.utils.DataDummy
import kotlinx.android.synthetic.main.fragment_movies.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class MoviesFragment : Fragment() {

    private var movieTvCatData = ArrayList<MovieTvCatData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        movieTvCatData = DataDummy.getDummyMovies(resources)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rv_movies.setHasFixedSize(true)
        setHasOptionsMenu(true)
        showRecyclerListMovies()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list_rv, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.mn_list -> showRecyclerListMovies()
            R.id.mn_grid -> showRecyclerGridMovies()
            R.id.mn_setting -> {
                val intent = Intent(activity, SettingActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerListMovies() {
        val movieCatListAdapter = MovieAdapter(context as Activity, false)
        movieCatListAdapter.setMovie(movieTvCatData)

        rv_movies.layoutManager = LinearLayoutManager(activity)
        rv_movies.adapter = movieCatListAdapter
        movieCatListAdapter.notifyDataSetChanged()

    }

    private fun showRecyclerGridMovies() {
        val movieCatGridAdapter = MovieAdapter(context as Activity, true)
        movieCatGridAdapter.setMovie(movieTvCatData)

        rv_movies.layoutManager = GridLayoutManager(activity, 2)
        rv_movies.adapter = movieCatGridAdapter
        movieCatGridAdapter.notifyDataSetChanged()
    }
}