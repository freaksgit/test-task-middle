package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataHolder
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepositoryDataToRoomHolderMapper(private val repositoryDataToRoomMapper: Function<RepositoryData, RoomRepositoryData>,
                                       private val ownerToRoomMapper: Function<Owner, RoomOwner>,
                                       private val licenseToRoomMapper: Function<License, RoomLicense>)
    : Function<RepositoryData, RoomRepositoryDataHolder> {

    override fun apply(t: RepositoryData): RoomRepositoryDataHolder = RoomRepositoryDataHolder(
            repositoryDataToRoomMapper.apply(t),
            t.license?.let { licenseToRoomMapper.apply(it) },
            t.owner?.let { ownerToRoomMapper.apply(it) })
}