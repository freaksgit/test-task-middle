package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local

import io.reactivex.Maybe
import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.GithubDatabase
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class LocalRepositoryDataSource(private val githubDatabase: GithubDatabase,
                                private val repositoryDataFromRoomMapper: Function<RoomRepositoryDataEmbedded, RepositoryData>)
    : RepositoryDataSource {

    override fun getRepositoriesByText(text: String): Maybe<List<RepositoryData>> {
        return githubDatabase.repositoryDataDao()
                .getEmbeddedRepositories()
                .toObservable()
                .flatMapIterable { it }
                .map(repositoryDataFromRoomMapper)
                .toList()
                .toMaybe()
    }

}