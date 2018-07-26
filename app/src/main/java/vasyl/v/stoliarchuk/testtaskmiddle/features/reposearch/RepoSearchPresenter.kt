package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import vasyl.v.stoliarchuk.testtaskmiddle.R


class RepoSearchPresenter(private val mvpView: RepoSearchContract.View) : RepoSearchContract.Presenter {

    override fun onSearchButtonClicked() {
        val queryText: String = mvpView.getSearchQueryText()
        if (queryText.isEmpty()) {
            mvpView.toggleEmptyQueryErrorMessageVisibility(true)
        } else {
            mvpView.toggleEmptyQueryErrorMessageVisibility(false)
            mvpView.startSearch(queryText)
        }
    }
    override fun onSearchStarted() {
        mvpView.toggleProgressVisibility(true)
        mvpView.setQueryButtonText(R.string.activity_repo_search_cancel_button)
    }

    override fun onSearchCompleted() {
        mvpView.toggleProgressVisibility(false)
        mvpView.setQueryButtonText(R.string.activity_repo_search_query_button)
    }

    override fun onSearchCanceled() {
        mvpView.toggleProgressVisibility(false)
        mvpView.setQueryButtonText(R.string.activity_repo_search_query_button)
    }

    override fun onSearchError(t: Throwable) {
        mvpView.toggleProgressVisibility(false)
        mvpView.setQueryButtonText(R.string.activity_repo_search_query_button)
        mvpView.showErrorMessage()
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
    }
}