package vasyl.v.stoliarchuk.testtaskmiddle

import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitLicense
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitOwner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryDataPack

class RetrofitEntityFactory {
    companion object Factory {
        fun makeRetrofitRepositoryDataEntity(id: Int, ownerId: Int, licenseKey: String): RetrofitRepositoryData {
            return RetrofitRepositoryData(
                    id,
                    "nodeId",
                    "name",
                    "fullName",
                    makeRetrofitOwnerEntity(ownerId),
                    false,
                    "htmlUrl",
                    "description",
                    false,
                    "url",
                    "forksUrl",
                    "keysUrl",
                    "collaboratorsUrl",
                    "teamsUrl",
                    "hooksUrl",
                    "issueEventsUrl",
                    "eventsUrl",
                    "assigneesUrl",
                    "branchesUrl",
                    "tagsUrl",
                    "blobsUrl",
                    "gitTagsUrl",
                    "gitRefsUrl",
                    "treesUrl",
                    "statusesUrl",
                    "languagesUrl",
                    "stargazersUrl",
                    "contributorsUrl",
                    "subscribersUrl",
                    "subscriptionUrl",
                    "commitsUrl",
                    "gitCommitsUrl",
                    "commentsUrl",
                    "issueCommentUrl",
                    "contentsUrl",
                    "compareUrl",
                    "mergesUrl",
                    "archiveUrl",
                    "downloadsUrl",
                    "issuesUrl",
                    "pullsUrl",
                    "milestonesUrl",
                    "notificationsUrl",
                    "labelsUrl",
                    "releasesUrl",
                    "deploymentsUrl",
                    "createdAt",
                    "updatedAt",
                    "pushedAt",
                    "gitUrl",
                    "sshUrl",
                    "cloneUrl",
                    "svnUrl",
                    "homepage",
                    10,
                    2,
                    3,
                    "language",
                    false,
                    false,
                    false,
                    false,
                    false,
                    1,
                    "mirrorUrl",
                    false,
                    1,
                    makeRetrofitLicenseEntity(licenseKey),
                    2,
                    2,
                    3,
                    "defaultBranch",
                    0.0)
        }

        fun makeRetrofitRepositoryDataEntity(id: Int): RetrofitRepositoryData {
            return makeRetrofitRepositoryDataEntity(id, id, id.toString())
        }

        fun makeRetrofitRepositoryDataEntityList(ids: Array<Int>, ownerIds: Array<Int>, licenseKeys: Array<String>): List<RetrofitRepositoryData> {
            val data: MutableList<RetrofitRepositoryData> = ArrayList(ids.size)
            for ((index, value) in ids.withIndex()) {
                data.add(makeRetrofitRepositoryDataEntity(value, ownerIds[index], licenseKeys[index]))
            }
            return data
        }

        fun makeRetrofitRepositoryDataEntityList(ids: Array<Int>): List<RetrofitRepositoryData> {
            val data: MutableList<RetrofitRepositoryData> = ArrayList(ids.size)
            for (value in ids) {
                data.add(makeRetrofitRepositoryDataEntity(value, value, value.toString()))
            }
            return data
        }

        fun makeRetrofitOwnerEntity(id: Int): RetrofitOwner {
            return RetrofitOwner(
                    "login",
                    id,
                    "nodeId",
                    "avatarUrl",
                    "gravatarId",
                    "url",
                    "htmlUrl",
                    "followersUrl",
                    "followingUrl",
                    "gistsUrl",
                    "starredUrl",
                    "subscriptionsUrl",
                    "organizationsUrl",
                    "reposUrl",
                    "eventsUrl",
                    "receivedEventsUrl",
                    "type",
                    false)
        }

        fun makeRetrofitOwnerEntityList(id: Array<Int>): List<RetrofitOwner> {
            val data: MutableList<RetrofitOwner> = ArrayList(id.size)
            for (value in id) {
                data.add(makeRetrofitOwnerEntity(value))
            }
            return data
        }

        fun makeRetrofitLicenseEntity(licenseKey: String): RetrofitLicense {
            return RetrofitLicense(
                    licenseKey,
                    "name",
                    "spdxId",
                    "url",
                    "nodeId")
        }

        fun makeRetrofitOwnerEntityList(licenseKeys: Array<String>): List<RetrofitLicense> {
            val data: MutableList<RetrofitLicense> = ArrayList(licenseKeys.size)
            for (value in licenseKeys) {
                data.add(makeRetrofitLicenseEntity(value))
            }
            return data
        }

        fun makeRetrofitRepositoryDataPack(id: Array<Int>): RetrofitRepositoryDataPack{
            return RetrofitRepositoryDataPack(id.size, false, makeRetrofitRepositoryDataEntityList(id))
        }
    }
}