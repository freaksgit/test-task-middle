package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch

import io.reactivex.Completable
import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepoRepository(private val localRepositoryDataSource: RepositoryDataSource,
                     private val remoteRepositoryDataSource: RepositoryDataSource) : RepositoryDataSource {
    private var lastQueryText: String? = null

    override fun insertRepositories(repositoriesData: Collection<RepositoryData>): Completable {
        return localRepositoryDataSource.insertRepositories(repositoriesData)
    }

    override fun clearStorage(): Completable {
        return localRepositoryDataSource.clearStorage()
    }

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        if (text == lastQueryText) {
            return localRepositoryDataSource.getRepositoriesByText(text)
        } else {
            return remoteRepositoryDataSource.getRepositoriesByText(text)// todo Replace with 2 parallel simultaneous request
                    .flatMap {
                        localRepositoryDataSource.insertRepositories(it)
                                .andThen(Maybe.just(it))
                                .doOnComplete({ this.lastQueryText = text }) //todo Replace with sharedPrefs
                    }
        }
    }
}