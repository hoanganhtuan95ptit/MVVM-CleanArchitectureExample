package net.lab.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import net.lab.myapplication.data.db.ImageDb
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageDb: ImageDb

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }
}
