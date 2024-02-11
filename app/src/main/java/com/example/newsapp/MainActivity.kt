package com.example.newsapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewbinding.ViewBinding
import com.example.newsapp.APIServices.APIinterface
import com.example.newsapp.APIServices.RetrofitHelper
import com.example.newsapp.Repository.NewsRepository
import com.example.newsapp.ViewModel.MainActivityViewModel
import com.example.newsapp.ViewModel.newsViewModelFactory
import com.example.newsapp.adapter.MyAdapter
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.models.Article
import com.example.newsapp.models.Source

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    lateinit var  adapter : MyAdapter
    lateinit var mainActivityViewModel: MainActivityViewModel

    val dataList = arrayListOf<Article>()
    val healthDataList = arrayListOf<Article>()
    val entertainmentDataList = arrayListOf<Article>()
    val generalDataList = arrayListOf<Article>()
    val businessDataList = arrayListOf<Article>()
    val scienceDataList = arrayListOf<Article>()
    val sportsDataList = arrayListOf<Article>()
    val technologyDataList = arrayListOf<Article>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val earthservices = RetrofitHelper.getInstance().create(APIinterface :: class.java)
        val repository = NewsRepository(earthservices)
        mainActivityViewModel = ViewModelProvider(this,newsViewModelFactory(repository)).get(MainActivityViewModel:: class.java)


        binding.rcv.layoutManager = LinearLayoutManager(this)

        val dataList = arrayListOf<Article>() // Assuming you have a function to generate your data

        adapter = MyAdapter(this, dataList)
        binding.rcv.adapter = adapter



        // Observe health news data
        mainActivityViewModel.healthNewsData.observe(this, Observer { news ->

            healthDataList.addAll(news.articles)
            dataList.addAll(healthDataList)
            Log.e("TAG123", "${dataList.isEmpty()}")
            adapter.notifyDataSetChanged()
        })

// Observe entertainment news data
        mainActivityViewModel.entertainmentNewsData.observe(this, Observer { news ->
            entertainmentDataList.addAll(news.articles)

        })

// Observe general news data
        mainActivityViewModel.generalNewsData.observe(this, Observer { news ->
            generalDataList.addAll(news.articles)

        })

// Observe business news data
        mainActivityViewModel.businessNewsData.observe(this, Observer { news ->
            businessDataList.addAll(news.articles)

        })

// Observe science news data
        mainActivityViewModel.scienceNewsData.observe(this, Observer { news ->
            scienceDataList.addAll(news.articles)

        })

// Observe sports news data
        mainActivityViewModel.sportsNewsData.observe(this, Observer { news ->
            sportsDataList.addAll(news.articles)

        })

// Observe technology news data
        mainActivityViewModel.technologyNewsData.observe(this, Observer { news ->
            technologyDataList.addAll(news.articles)

        })


        binding.buinessbtn.setOnClickListener {
            allButtonReset()
            binding.buinessbtn.setBackgroundResource(R.drawable.button_bg)
            binding.buinessbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(businessDataList)
            adapter.notifyDataSetChanged()
        }

        binding.generalbtn.setOnClickListener {
            allButtonReset()
            binding.generalbtn.setBackgroundResource(R.drawable.button_bg)
            binding.generalbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(generalDataList)
            adapter.notifyDataSetChanged()
        }

        binding.sportsbtn.setOnClickListener {
            allButtonReset()
            binding.sportsbtn.setBackgroundResource(R.drawable.button_bg)
            binding.sportsbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(sportsDataList)
            adapter.notifyDataSetChanged()
        }

        binding.techbtn.setOnClickListener {
            allButtonReset()
            binding.techbtn.setBackgroundResource(R.drawable.button_bg)
            binding.techbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(technologyDataList)
            adapter.notifyDataSetChanged()
        }

        binding.entertainmentbtn.setOnClickListener {
            allButtonReset()
            binding.entertainmentbtn.setBackgroundResource(R.drawable.button_bg)
            binding.entertainmentbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(entertainmentDataList)
            adapter.notifyDataSetChanged()
        }

        binding.healthbtn.setOnClickListener {
            allButtonReset()
            binding.healthbtn.setBackgroundResource(R.drawable.button_bg)
            binding.healthbtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(healthDataList)
            adapter.notifyDataSetChanged()
        }

        binding.sciencebtn.setOnClickListener {
            allButtonReset()
            binding.sciencebtn.setBackgroundResource(R.drawable.button_bg)
            binding.sciencebtn.setTextColor(Color.BLACK)
            dataList.clear()
            dataList.addAll(scienceDataList)
            adapter.notifyDataSetChanged()
        }

    }

    //to reset color of all buttons
    private fun allButtonReset() {
        binding.buinessbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.buinessbtn.setTextColor(Color.WHITE)

        binding.healthbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.healthbtn.setTextColor(Color.WHITE)

        binding.entertainmentbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.entertainmentbtn.setTextColor(Color.WHITE)

        binding.sportsbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.sportsbtn.setTextColor(Color.WHITE)

        binding.generalbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.generalbtn.setTextColor(Color.WHITE)

        binding.techbtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.techbtn.setTextColor(Color.WHITE)

        binding.sciencebtn.setBackgroundResource(R.drawable.button_bg_default)
        binding.sciencebtn.setTextColor(Color.WHITE)

    }
}
