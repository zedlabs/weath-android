package tk.zedlabs.flobiz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.city_list_item.view.*
import tk.zedlabs.flobiz.models.City

class CityListAdapter(private val myDataset : List<City>, onImageListener : OnImageListener) : RecyclerView.Adapter<CityListAdapter.MyViewHolder>() {

    private var mOnImageListener: OnImageListener = onImageListener

    class MyViewHolder(view : View, var onImageListener: OnImageListener) : RecyclerView.ViewHolder(view), View.OnClickListener{

        init { view.setOnClickListener(this) }

        override fun onClick(v: View?) {
            onImageListener.onImageClick(adapterPosition)
        }
    }

    interface OnImageListener{ fun onImageClick(position: Int) }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        val cityCardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.city_list_item, parent, false)
        return MyViewHolder(cityCardView, mOnImageListener)
    }

    override fun getItemCount(): Int { return myDataset.size }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.textViewCard.text = myDataset[position].name


    }

}
