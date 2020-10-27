package qubit.engineering.harryporter.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_houses.view.*
import qubit.engineering.harryporter.Data.HousesItem
import qubit.engineering.harryporter.R

class HousesAdapter(
    private val list: List<HousesItem>,
    private val listener: RecyclerViewClickListener
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<HousesItem> = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HouseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_houses, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HouseViewHolder -> {
                holder.bind(items.get(position))
                holder.linear.setOnClickListener {

                    listener.onRecyclerViewItemClick(holder.linear, items[position])
                    //Toast.makeText(it.context, "Its toast!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HouseViewHolder constructor(
        itemView: View

    ) : RecyclerView.ViewHolder(itemView) {
        val thumbnail: ImageView = itemView.item_thumbnail
        val title: TextView = itemView.item_title
        val mascot: TextView = itemView.item_mascot
        val linear: LinearLayout = itemView.item_lin
        //val rating_tomatoes: TextView = itemView.item_tomatoes
        //val rating_stars : TextView = itemView.item_stars
        //val year: TextView = itemView.item_year

        fun bind(houseItem: HousesItem) {

            title.setText(houseItem.name)
            mascot.setText(houseItem.mascot)
            //rating_tomatoes.setText(movie.imdbRating)
            //rating_stars.setText(movie.metascore)
            //year.setText(movie.year)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.refresh)
                .error(R.drawable.attention)
            var image = 0
            if (houseItem.name == "Gryffindor") {
                image = R.drawable.gryffindor
            } else if (houseItem.name == "Ravenclaw") {
                image = R.drawable.ravenclaw
            } else if (houseItem.name == "Slytherin") {
                image = R.drawable.slytherin
            } else if (houseItem.name == "Hufflepuff") {
                image = R.drawable.hufflepuff
            }
            thumbnail.setImageResource(R.drawable.gryffindor)
            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(image)
                .into(thumbnail)

        }

    }


}