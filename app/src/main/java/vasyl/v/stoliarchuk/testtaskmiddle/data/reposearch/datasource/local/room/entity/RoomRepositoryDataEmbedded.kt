package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Relation

data class RoomRepositoryDataEmbedded @JvmOverloads constructor(
        @Embedded var roomRepositoryData: RoomRepositoryData,

        @Relation(entity = RoomLicense::class,
                parentColumn = RoomRepositoryData.COLUMN_LICENSE_KEY,
                entityColumn = RoomLicense.COLUMN_KEY)
        var roomLicenses: List<RoomLicense> = listOf(),

        @Relation(entity = RoomOwner::class,
                parentColumn = RoomRepositoryData.COLUMN_OWNER_ID,
                entityColumn = RoomOwner.COLUMN_ID)
        var roomOwners: List<RoomOwner> = listOf()
)