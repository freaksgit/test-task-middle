package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner

class OwnerToRoomMapper : Function<Owner, RoomOwner>{
    override fun apply(owner: Owner): RoomOwner = RoomOwner(
            owner.login,
            owner.id,
            owner.nodeId,
            owner.avatarUrl,
            owner.gravatarId,
            owner.avatarUrl,
            owner.htmlUrl,
            owner.followersUrl,
            owner.followingUrl,
            owner.gistsUrl,
            owner.starredUrl,
            owner.subscriptionsUrl,
            owner.organizationsUrl,
            owner.reposUrl,
            owner.eventsUrl,
            owner.receivedEventsUrl,
            owner.type,
            owner.siteAdmin
    )

}