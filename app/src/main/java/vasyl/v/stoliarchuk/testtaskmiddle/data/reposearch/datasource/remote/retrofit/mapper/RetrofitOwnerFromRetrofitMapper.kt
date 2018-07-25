package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.mapper

import io.reactivex.functions.Function
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner

class RetrofitOwnerFromRetrofitMapper : Function<RetrofitOwner, Owner> {
    override fun apply(rOwner: RetrofitOwner): Owner {
        return Owner(
                rOwner.login,
                rOwner.id,
                rOwner.nodeId,
                rOwner.avatarUrl,
                rOwner.gravatarId,
                rOwner.url,
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
}