package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch

import io.reactivex.Completable
import io.reactivex.Maybe
import vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs.PreferenceDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepoRepository(private val localRepositoryDataSource: RepositoryDataSource,
                     private val remoteRepositoryDataSource: RepositoryDataSource,
                     private val preferenceRepository: PreferenceDataSource) : RepositoryDataSource {

    override fun insertRepositories(repositoriesData: Collection<RepositoryData>): Completable {
        return localRepositoryDataSource.insertRepositories(repositoriesData)
    }

    override fun clearStorage(): Completable {
        return localRepositoryDataSource.clearStorage()
    }

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        if (isQueryCached(text)) {
            return localRepositoryDataSource.getRepositoriesByText(text)
        } else {
            return Maybe.amb(listOf(remoteRepositoryDataSource.getRepositoriesByText(text), remoteRepositoryDataSource.getRepositoriesByText(text)))
                    .flatMap {
                        clearStorage()
                                .andThen(localRepositoryDataSource.insertRepositories(it))
                                .doOnComplete({ updateCachedQuery(text) })
                                .andThen(Maybe.just(it))
                    }
        }
    }

    private fun updateCachedQuery(text: String) {
        preferenceRepository.putString(KEY_LAST_QUERY_TEXT, text)
    }

    private fun isQueryCached(text: String) =
            text == preferenceRepository.getString(KEY_LAST_QUERY_TEXT, "")

    companion object {
        const val KEY_LAST_QUERY_TEXT: String = "key_last_query_text"
    }
}