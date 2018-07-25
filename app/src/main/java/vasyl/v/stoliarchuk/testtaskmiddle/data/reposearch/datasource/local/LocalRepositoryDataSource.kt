package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local

import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.GithubDatabase
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataHolder
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class LocalRepositoryDataSource(private val githubDatabase: GithubDatabase,
                                private val repositoryDataFromRoomMapper: Function<RoomRepositoryDataEmbedded, RepositoryData>,
                                private var repositoryDataToRoomHolderMapper: Function<RepositoryData, RoomRepositoryDataHolder>)
    : RepositoryDataSource {
    override fun insertRepositories(repositoriesData: Collection<RepositoryData>): Completable {
        return Observable.fromIterable(repositoriesData)
                .map(repositoryDataToRoomHolderMapper)
                .flatMapCompletable { repositoryDataRoomHolder ->
                    Completable.fromAction({ repositoryDataRoomHolder.roomOwner?.let { githubDatabase.onwerDao().insert(it) } })
                            .andThen(Completable.fromAction({ repositoryDataRoomHolder.roomLicense?.let { githubDatabase.licenseDao().insert(it) } })
                                    .andThen(Completable.fromAction({ repositoryDataRoomHolder.roomRepositoryData?.let { githubDatabase.repositoryDataDao().insert(it) } })))
                }
    }

    override fun clearStorage(): Completable {
        return Completable.fromAction({ githubDatabase.clearAndResetAllTables() })
    }

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