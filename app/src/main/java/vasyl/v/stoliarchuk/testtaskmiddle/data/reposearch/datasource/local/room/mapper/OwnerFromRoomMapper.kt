package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner

class OwnerFromRoomMapper : Function<RoomOwner, Owner> {
    override fun apply(rOwner: RoomOwner): Owner = Owner(
            rOwner.login,
            rOwner.id,
            rOwner.nodeId,
            rOwner.avatarUrl,
            rOwner.gravatarId,
            rOwner.avatarUrl,
            rOwner.htmlUrl,
            rOwner.followersUrl,
            rOwner.followingUrl,
            rOwner.gistsUrl,
            rOwner.starredUrl,
            rOwner.subscriptionsUrl,
            rOwner.organizationsUrl,
            rOwner.reposUrl,
            rOwner.eventsUrl,
            rOwner.receivedEventsUrl,
            rOwner.type,
            rOwner.siteAdmin)
}