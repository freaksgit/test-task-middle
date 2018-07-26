package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment

import vasyl.v.stoliarchuk.testtaskmiddle.common.presentation.BasePresenter
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

interface RepoSearchFrContract {

    interface View {
        fun showRepositories(repositoryDataList: List<RepositoryData>)
        fun onError(t: Throwable)
        fun onComplete()
        fun onSearchCanceled()

    }

    interface Presenter : BasePresenter {
        fun startSearch(queryText: String)

    }
}