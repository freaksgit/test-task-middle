package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.GithubApi
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RemoteRepositoryDataSource(private val githubApi: GithubApi, private val fromRetrofitMapper: Function<RetrofitRepositoryData, RepositoryData>) : RepositoryDataSource {
    override fun clearStorage(): Completable = Completable.error(UnsupportedOperationException("Not implemented"))

    override fun insertRepositories(repositoriesData: Collection<RepositoryData>): Completable = Completable.error(UnsupportedOperationException("Not implemented"))

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        return githubApi.getRepositoriesByText(text)
                .map { it.items }
                .toObservable()
                .flatMapIterable { it }
                .map(fromRetrofitMapper)
                .toList()
                .toMaybe()
    }
}