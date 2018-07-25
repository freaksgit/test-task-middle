package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License

class LicenseToRoomMapper : Function<License, RoomLicense> {
    override fun apply(license: License): RoomLicense = RoomLicense(
            license.key,
            license.name,
            license.spdxId,
            license.url,
            license.nodeId)
}