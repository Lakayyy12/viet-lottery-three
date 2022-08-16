package com.application.vietlotterytri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //actionbar
    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    private var btn1 : TextView? = null
    private var btn2 : TextView? = null
    private var btn3 : TextView? = null

    private var exit = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn1?.setOnClickListener {
            intent = Intent(this, GuidePage::class.java)
            startActivity(intent)
        }
        btn2 = findViewById(R.id.btn2)
        btn2?.setOnClickListener {
            intent = Intent(this, MorePage::class.java)
            startActivity(intent)
        }
        btn3 = findViewById(R.id.btn3)
        btn3?.setOnClickListener {
            intent = Intent(this, AboutPage::class.java)
            startActivity(intent)
        }

            //init actionbar
            loadCards()
            //add page change listener
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    //change title of actionbar
                    var title = myModelList[position].title
                }

                override fun onPageSelected(position: Int) {
                }

                override fun onPageScrollStateChanged(state: Int) {
                }
            })
    }

    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        myModelList.add(MyModel(
            "Trò chơi xổ số Việt Nam",
            R.string.main1,
            R.drawable.navbar))

        myModelList.add(MyModel(
            "Mega 6/45",
            R.string.main2,
            R.drawable.navbar))

        myModelList.add(MyModel(
            "Power 6/55",
            R.string.main3,
            R.drawable.navbar))

        myModelList.add(MyModel(
            "Max 3D",
            R.string.main4,
            R.drawable.navbar))

        myModelList.add(MyModel(
            "Max 4D",
            R.string.main5,
            R.drawable.navbar))

        myModelList.add(MyModel(
            "Keno",
            R.string.main6,
            R.drawable.navbar))
        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        // set default padding
        viewPager.setPadding(100,0,100,0)
    }

    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "BẤM ĐÔI ĐỂ Thoát", Toast.LENGTH_SHORT).show()
        } else {
            finish()
        }
    }
}
