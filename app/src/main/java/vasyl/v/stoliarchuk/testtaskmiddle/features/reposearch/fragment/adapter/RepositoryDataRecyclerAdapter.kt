package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.recycler_repository_data_item.view.*
import vasyl.v.stoliarchuk.testtaskmiddle.R
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData


class RepositoryDataRecyclerAdapter(private var data: List<RepositoryData> = ArrayList()) : RecyclerView.Adapter<RepositoryDataViewHolder>() {

    fun setData(data: List<RepositoryData>) {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_repository_data_item, parent, false)
        return RepositoryDataViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RepositoryDataViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}

class RepositoryDataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bindData(repositoryData: RepositoryData) {
        tvTitle.text = repositoryData.fullName
        tvDescription.text = repositoryData.description
        tvLicense.text = if (repositoryData.license != null) repositoryData.license?.spdxId else tvLicense.context.getString(R.string.no_license)
        tvOwner.text = repositoryData.owner?.login
    }

    val tvTitle = view.recycler_repository_data_item_title
    val tvDescription = view.recycler_repository_data_item_description
    val tvOwner = view.recycler_repository_data_item_owner
    val tvLicense = view.recycler_repository_data_item_license
}