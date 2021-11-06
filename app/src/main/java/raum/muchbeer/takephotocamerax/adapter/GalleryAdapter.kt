package raum.muchbeer.takephotocamerax.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import raum.muchbeer.takephotocamerax.databinding.PhotoItemBinding
import java.io.File

class GalleryAdapter() : ListAdapter<File, GalleryAdapter.GalleryVH>(gallaDifUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryVH {
       val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PhotoItemBinding.inflate(layoutInflater, parent, false)

        return GalleryVH(binding)
    }

    override fun onBindViewHolder(holder: GalleryVH, position: Int) {
        holder.bindData(getItem(position))
    }


    class GalleryVH(val binding: PhotoItemBinding) :
             RecyclerView.ViewHolder(binding.root) {

                 fun bindData(file : File) {
                     Glide.with(binding.root).load(file).into(binding.photoItem)
             }
    }


    companion object gallaDifUtil : DiffUtil.ItemCallback<File>() {
        override fun areItemsTheSame(oldItem: File, newItem: File): Boolean {
            return oldItem.absolutePath == newItem.absolutePath        }

        override fun areContentsTheSame(oldItem: File, newItem: File): Boolean {
            return oldItem == newItem
        }

    }
}