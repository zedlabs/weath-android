package tk.zedlabs.flobiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_list_item.view.*
import tk.zedlabs.flobiz.models.City

class CityListAdapter(private val myDataset : List<City>) : RecyclerView.Adapter<CityListAdapter.MyViewHolder>() {

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view)


    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        val cityCardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_list_item, parent, false)
        return MyViewHolder(cityCardView)
    }

    override fun getItemCount(): Int {
        return myDataset.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textViewCard.text = myDataset[position].name
    }
}