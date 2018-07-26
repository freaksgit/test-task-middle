package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RepositoryDataEmbeddedFromRoomMapper(private val repositoryDataFromRoomMapper: Function<RoomRepositoryData, RepositoryData>,
                                           private val licenseFromRoomMapper: Function<RoomLicense, License>,
                                           private val ownerFromRoomMapper: Function<RoomOwner, Owner>) : Function<RoomRepositoryDataEmbedded, RepositoryData> {
    override fun apply(t: RoomRepositoryDataEmbedded): RepositoryData {
        val repositoryData: RepositoryData = repositoryDataFromRoomMapper.apply(t.roomRepositoryData)
        repositoryData.license = if (!t.roomLicenses.isEmpty()) licenseFromRoomMapper.apply(t.roomLicenses[0]) else null
        repositoryData.owner = if (!t.roomOwners.isEmpty()) ownerFromRoomMapper.apply(t.roomOwners[0]) else null
        return repositoryData
    }
}