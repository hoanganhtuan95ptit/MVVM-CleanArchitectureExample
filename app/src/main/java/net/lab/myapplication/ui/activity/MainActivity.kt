package net.lab.myapplication.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import net.citigo.kiotviet.pos.fnb.ui.adapters.ImageAdapter
import net.lab.myapplication.R
import net.lab.myapplication.ui.viewmodel.ImageViewModel
import net.lab.myapplication.ui.viewmodel.factory.ImageViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageViewModelFactory: ImageViewModelFactory

    private lateinit var imageAdapter: ImageAdapter
    private lateinit var imageViewModel: ImageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewModel =
            ViewModelProviders.of(this, imageViewModelFactory).get(ImageViewModel::class.java)

        imageAdapter = ImageAdapter(this)
        imageAdapter.setRecyclerView(recyclerView)

        imageViewModel.images.observe(this, Observer {
            swipeRefreshLayout.isRefreshing = false
            imageAdapter.bindData(it)
        })

        swipeRefreshLayout.setOnRefreshListener {
            imageViewModel.getImage()
        }
        swipeRefreshLayout.post {
            swipeRefreshLayout.isRefreshing = true
            imageViewModel.getImage()
        }
    }
}
