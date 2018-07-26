package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment

import io.reactivex.disposables.Disposable
import vasyl.v.stoliarchuk.testtaskmiddle.common.schedulers.SchedulerProvider
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource

class RepoSearchFrPresenter(private val mvpView: RepoSearchFrContract.View,
                            private val repoDataRepository: RepositoryDataSource,
                            private val schedulerProvider: SchedulerProvider) : RepoSearchFrContract.Presenter {
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
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
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
        mvpView.onSearchCanceled()
    }

    private fun disposeQuerySubscriber() {
        inProgress = false
        if (querySubscription != null && !querySubscription!!.isDisposed) {
            querySubscription!!.dispose()
        }
    }
}