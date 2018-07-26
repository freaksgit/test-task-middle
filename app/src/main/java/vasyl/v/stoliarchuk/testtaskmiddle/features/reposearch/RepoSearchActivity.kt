package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_repo_search.*
import kotlinx.android.synthetic.main.toolbar.*
import vasyl.v.stoliarchuk.testtaskmiddle.R
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.RepoSearchFragment
import javax.inject.Inject

class RepoSearchActivity : DaggerAppCompatActivity(), RepoSearchContract.View, RepoSearchFragment.OnSearchResultListener {

    @Inject
    lateinit var presenter: RepoSearchContract.Presenter

    private val repoSearchFragment = RepoSearchFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_search)

        setSupportActionBar(toolbar)

        supportFragmentManager.beginTransaction()
                .add(R.id.activity_repo_search_fragment_container, repoSearchFragment)
                .commit()

        activity_repo_search_query_button.setOnClickListener({
            presenter.onSearchButtonClicked()
        })

        presenter.subscribe()
    }

    override fun getSearchQueryText(): String {
        return activity_repo_search_query_edit_text.text.toString()
    }

    override fun toggleEmptyQueryErrorMessageVisibility(visible: Boolean) {
        if (visible) {
            activity_repo_search_input_layout.error = getString(R.string.activity_repo_search_input_layout_empty_error)
        } else {
            activity_repo_search_input_layout.isErrorEnabled = false
        }
    }


    override fun startSearch(queryText: String) {
        repoSearchFragment.startSearch(queryText)
    }

    override fun onSearchStarted() {
        presenter.onSearchStarted()
    }

    override fun onSearchCompleted() {
        presenter.onSearchCompleted()
    }

    override fun onSearchCanceled() {
        presenter.onSearchCanceled()
    }

    override fun onSearchError(t: Throwable) {
        presenter.onSearchError(t)
    }

    override fun setQueryButtonText(stringResId: Int) {
        activity_repo_search_query_button.text = getString(stringResId)
    }

    override fun toggleProgressVisibility(visible: Boolean) {
        if (visible){
            activity_repo_search_progress_bar.visibility = View.VISIBLE
        } else {
            activity_repo_search_progress_bar.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}
