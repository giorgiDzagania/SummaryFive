package com.exercise.summaryfive.data.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.exercise.summaryfive.data.model.ActiveCourse
import com.exercise.summaryfive.databinding.ItemLayoutBinding

class CourseAdapter :
    ListAdapter<ActiveCourse, CourseAdapter.CourseViewHolder>(CourseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CourseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val course = getItem(position)
        holder.bind(course)
    }

    inner class CourseViewHolder(private val binding: ItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(course: ActiveCourse) {
            binding.titleTextView.text = course.title

            if (course is ActiveCourse) {
                binding.bookingTimeTextView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.VISIBLE
                binding.imageView.visibility = View.VISIBLE

                binding.bookingTimeTextView.text = "Booking Time: ${course.booking_time}"

                Glide.with(itemView)
                    .load(course.image)
                    .into(binding.imageView)
            } else {
                binding.bookingTimeTextView.visibility = View.GONE
                binding.progressBar.visibility = View.GONE
                binding.imageView.visibility = View.GONE
            }
        }
    }

    private class CourseDiffCallback : DiffUtil.ItemCallback<ActiveCourse>() {
        override fun areItemsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ActiveCourse, newItem: ActiveCourse): Boolean {
            return oldItem.id == newItem.id
        }
    }
}