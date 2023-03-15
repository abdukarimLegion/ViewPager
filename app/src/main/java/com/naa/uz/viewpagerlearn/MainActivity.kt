package com.naa.uz.viewpagerlearn

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.naa.uz.viewpagerlearn.adapter.UserPagerAdapter


import com.naa.uz.viewpagerlearn.databinding.ActivityMainBinding
import com.naa.uz.viewpagerlearn.models.User


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

//    lateinit var imageList: ArrayList<String>
//    lateinit var imageAdapter: ImageAdapter

    lateinit var userList: ArrayList<User>
    lateinit var userPagerAdapter: UserPagerAdapter

    lateinit var titleList: ArrayList<String>
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        userList = ArrayList()

        for (i in 1..100) {
            userList.add(
                User(
                    "Abdukarim 1",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtF3o2PvqxOMHgdrpj_YRItsLBjxyTeNZu_Q&usqp=CAU"
                )
            )
            userList.add(
                User(
                    "Abdukarim 2",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtF3o2PvqxOMHgdrpj_YRItsLBjxyTeNZu_Q&usqp=CAU"
                )
            )
            userList.add(
                User(
                    "Abdukarim 3",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtF3o2PvqxOMHgdrpj_YRItsLBjxyTeNZu_Q&usqp=CAU"
                )
            )
        }

        titleList = ArrayList()
        for (i in 1..100) {
            titleList.add("Home")
            titleList.add("About us")
            titleList.add("Contact us")
        }
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        handler = Handler()
        handler.postDelayed(runnable, 2000)


        userPagerAdapter = UserPagerAdapter(userList, titleList, supportFragmentManager)
        binding.viewPager.setPageTransformer(true, FlipVerticalTransformer())
        binding.viewPager.adapter = userPagerAdapter
//        loadImage()
//        imageAdapter = ImageAdapter(imageList)
//        binding.viewPager.adapter = imageAdapter
    }


//    private fun loadImage() {
//        imageList = ArrayList()
//

//        imageList.add("https://storage.kun.uz/source/thumbnails/_medium/9/Xb2q5ZI6gzrgLslLWQXTJjCUEnH14ySN_medium.jpg")
//        imageList.add("https://storage.kun.uz/source/thumbnails/_medium/9/kjil3yrWzNf6rQa5uhTwdJ41fi3E-MW4_medium.jpg")
//        imageList.add("https://storage.kun.uz/source/thumbnails/_medium/9/AiibIiZjtj3AKMILBYSrKBfu9T6Svz7c_medium.jpg")
//    }

    val runnable = object : Runnable {
        override fun run() {
            binding.viewPager.currentItem += 1
            handler.postDelayed(this,2000)
        }
    }
    fun add(){

    }
}

