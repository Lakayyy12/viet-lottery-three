package com.application.vietlotterytri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.vietlotterytri.Navigator.Companion.openPage
import kotlinx.android.synthetic.main.activity_guide_page.*

class GuidePage : AppCompatActivity(), OnContentClickListener {

    private var layoutManager: RecyclerView.LayoutManager? = null

    private val onItemClicked by lazy { this }

    private var btnG : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_page)

        initRecyclerView()
        initOnClicked()

        btnG = findViewById(R.id.btnG)
        btnG?.setOnClickListener{
            onBackPressed()
        }
    }

    private fun initRecyclerView(){
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = RecyclerAdapter(onItemClicked)
    }
    private fun initOnClicked(){
        cdView?.setOnClickListener {
            openPage(this, ContentInside::class.java)
        }
    }
    override fun OnContentItemClicked(image: Int, content: Int) {
        openPage(this, ContentInside::class.java, image, content)
    }
}

