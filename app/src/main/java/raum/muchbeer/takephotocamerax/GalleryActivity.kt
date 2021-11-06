package raum.muchbeer.takephotocamerax

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import raum.muchbeer.takephotocamerax.adapter.GalleryAdapter
import raum.muchbeer.takephotocamerax.databinding.ActivityGalleryBinding
import java.io.File

class GalleryActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val directory = File(externalMediaDirs[0].absolutePath)
        val files = directory.listFiles() as Array<File>

        val adapter = GalleryAdapter()
        binding.viewPager.adapter = adapter
        adapter.submitList(files.toList())
    }
}