package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import vasyl.v.stoliarchuk.testtaskmiddle.common.presentation.BasePresenter

interface RepoSearchContract {

    interface View {
        fun getSearchQueryText(): String
        fun toggleEmptyQueryErrorMessageVisibility(visible: Boolean)
        fun startSearch(queryText: String)
        fun toggleProgressVisibility(visible: Boolean)
        fun setQueryButtonText(stringResId: Int)
        fun showErrorMessage()

    }

    interface Presenter : BasePresenter {
        fun onSearchButtonClicked()
        fun onSearchStarted()
        fun onSearchCompleted()
        fun onSearchCanceled()
        fun onSearchError(t: Throwable)

    }
}