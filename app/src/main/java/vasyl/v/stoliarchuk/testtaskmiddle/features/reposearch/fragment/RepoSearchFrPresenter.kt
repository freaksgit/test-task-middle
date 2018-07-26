package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource

class RepoSearchFrPresenter(private val mvpView: RepoSearchFrContract.View,
                            private val repoDataRepository: RepositoryDataSource) : RepoSearchFrContract.Presenter {
    var querySubscription: Disposable? = null
    var inProgress: Boolean = false
    override fun subscribe() {}

    override fun startSearch(queryText: String) {
        if (inProgress) {
            cancelActiveQuery()
        } else {
            getRepositoriesByText(queryText)
        }

    }

    private fun getRepositoriesByText(queryText: String) {
        inProgress = true
        querySubscription = repoDataRepository.getRepositoriesByText(queryText)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView.showRepositories(it)
                    mvpView.onComplete()
                    inProgress = false
                }, {
                    mvpView.onError(it)
                    inProgress = false
                }, {
                    mvpView.onComplete()
                    inProgress = false
                })
    }

    override fun unsubscribe() {
        disposeQuerySubscriber()
    }

    private fun cancelActiveQuery() {
        disposeQuerySubscriber()
        mvpView.onSearchCanseled()
    }

    private fun disposeQuerySubscriber() {
        inProgress = false
        if (querySubscription != null && !querySubscription!!.isDisposed) {
            querySubscription!!.dispose()
        }
    }
}