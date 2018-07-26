package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource

class RepoSearchPresenter(private val mvpView: RepoSearchContract.View,
                          private val repoDataRepository: RepositoryDataSource) : RepoSearchContract.Presenter {


    override fun subscribe() {
        repoDataRepository.getRepositoriesByText("text")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun unsubscribe() {
    }
}