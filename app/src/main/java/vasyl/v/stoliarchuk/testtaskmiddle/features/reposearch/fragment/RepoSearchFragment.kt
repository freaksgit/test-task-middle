package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import vasyl.v.stoliarchuk.testtaskmiddle.R
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.adapter.RepositoryDataRecyclerAdapter
import javax.inject.Inject

class RepoSearchFragment : DaggerFragment(), RepoSearchFrContract.View {


    private var searchResultListener: OnSearchResultListener? = null
    private lateinit var recyclerView: RecyclerView
    private val repositoryDataRecyclerAdapter = RepositoryDataRecyclerAdapter()

    @Inject
    lateinit var presenter: RepoSearchFrContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_repo_search, container, false)
        setupRecyclerView(rootView)
        return rootView
    }

    private fun setupRecyclerView(rootView: View) {
        recyclerView = rootView.findViewById(R.id.fragment_repo_search_result_recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = repositoryDataRecyclerAdapter
    }

    override fun showRepositories(repositoryDataList: List<RepositoryData>) {
        repositoryDataRecyclerAdapter.setData(repositoryDataList)
        repositoryDataRecyclerAdapter.notifyDataSetChanged()
    }

    override fun onError(t: Throwable) {
        searchResultListener?.onSearchError(t)
    }

    override fun onComplete() {
        searchResultListener?.onSearchCompleted()
    }

    override fun onSearchCanseled() {
        searchResultListener?.onSearchCanceled()
    }

    companion object {
        @JvmStatic
        fun newInstance() = RepoSearchFragment()
    }

    fun startSearch(queryText: String) {
        searchResultListener?.onSearchStarted()
        presenter.startSearch(queryText)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnSearchResultListener) {
            searchResultListener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnSearchResultListener")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    override fun onDetach() {
        super.onDetach()
        searchResultListener = null
    }

    interface OnSearchResultListener {
        fun onSearchStarted()
        fun onSearchCompleted()
        fun onSearchCanceled()
        fun onSearchError(t: Throwable)
    }
}
