package com.example.moviesapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviesapp.data.presentation.MovieAdapter
import com.example.moviesapp.data.presentation.MyViewModel
import com.example.moviesapp.data.presentation.ViewModelFactory
import com.example.moviesapp.data.presentation.di.Injector
import com.example.moviesapp.databinding.ActivityMainBinding
import com.example.moviesapp.ui.theme.MoviesAppTheme
import javax.inject.Inject

class MainActivity :AppCompatActivity() {
      @Inject
     lateinit var factory: ViewModelFactory
     private lateinit var movieViewModel: MyViewModel
     private lateinit var  binding:ActivityMainBinding
     private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this,factory)
            .get(MyViewModel::class.java)

        initRecyclerView()




    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerView.adapter = adapter
        displayPopularMovies()




    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()

        responseLiveData.observe(this, Observer{

            if (it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No Data Available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateMovies()
                true
            }else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response = movieViewModel.updateMovies()
        response.observe(this, Observer {

            if (it!= null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.movieProgressBar.visibility = View.GONE
            }else{
                binding.movieProgressBar.visibility = View.GONE

            }
        })


    }
}