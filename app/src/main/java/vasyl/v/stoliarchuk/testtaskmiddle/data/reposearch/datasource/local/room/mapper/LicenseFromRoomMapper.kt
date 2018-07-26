package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License

class LicenseFromRoomMapper : Function<RoomLicense, License> {
    override fun apply(rLicense: RoomLicense): License = License(
            rLicense.key,
            rLicense.name,
            rLicense.spdxId,
            rLicense.url,
            rLicense.nodeId)
}