import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.*

class RoomEntityFactory {
    companion object Factory {
        fun makeRoomRepositoryDataEntity(id: Int, ownerId: Int, licenseKey: String): RoomRepositoryData {
            return RoomRepositoryData(
                    id,
                    "nodeId",
                    "name",
                    "fullName",
                    ownerId,
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
                    licenseKey,
                    2,
                    2,
                    3,
                    "defaultBranch",
                    0.0)
        }

        fun makeRoomRepositoryDataEntity(id: Int): RoomRepositoryData {
            return makeRoomRepositoryDataEntity(id, id, id.toString())
        }

        fun makeRoomRepositoryDataEntityList(ids: Array<Int>, ownerIds: Array<Int>, licenseKeys: Array<String>): List<RoomRepositoryData> {
            val data: MutableList<RoomRepositoryData> = ArrayList(ids.size)
            for ((index, value) in ids.withIndex()) {
                data.add(makeRoomRepositoryDataEntity(value, ownerIds[index], licenseKeys[index]))
            }
            return data
        }

        fun makeRoomRepositoryDataEntityList(ids: Array<Int>): List<RoomRepositoryData> {
            val data: MutableList<RoomRepositoryData> = ArrayList(ids.size)
            for (value in ids) {
                data.add(makeRoomRepositoryDataEntity(value, value, value.toString()))
            }
            return data
        }

        fun makeRoomOwnerEntity(id: Int): RoomOwner {
            return RoomOwner(
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

        fun makeRoomOwnerEntityList(id: Array<Int>): List<RoomOwner> {
            val data: MutableList<RoomOwner> = ArrayList(id.size)
            for (value in id) {
                data.add(makeRoomOwnerEntity(value))
            }
            return data
        }

        fun makeRoomLicenseEntity(licenseKey: String): RoomLicense {
            return RoomLicense(
                    licenseKey,
                    "name",
                    "spdxId",
                    "url",
                    "nodeId")
        }

        fun makeRoomOwnerEntityList(licenseKeys: Array<String>): List<RoomLicense> {
            val data: MutableList<RoomLicense> = ArrayList(licenseKeys.size)
            for (value in licenseKeys) {
                data.add(makeRoomLicenseEntity(value))
            }
            return data
        }


        fun makeRoomRepositoryDataEmbeddeEntity(id: Int, ownerId: Int, licenseKey: String): RoomRepositoryDataEmbedded {
            return RoomRepositoryDataEmbedded(
                    makeRoomRepositoryDataEntity(id, ownerId, licenseKey),
                    listOf(makeRoomLicenseEntity(licenseKey)),
                    listOf(makeRoomOwnerEntity(ownerId)))
        }

        fun makeRoomRepositoryDataEmbeddeEntityList(ids: Array<Int>, ownerIds: Array<Int>, licenseKeys: Array<String>): List<RoomRepositoryDataEmbedded> {
            val data: MutableList<RoomRepositoryDataEmbedded> = ArrayList(ids.size)
            for ((index, value) in ids.withIndex()) {
                data.add(makeRoomRepositoryDataEmbeddeEntity(value, ownerIds[index], licenseKeys[index]))
            }
            return data
        }

        fun makeRoomRepositoryDataEmbeddeEntityList(ids: Array<Int>): List<RoomRepositoryDataEmbedded> {
            val data: MutableList<RoomRepositoryDataEmbedded> = ArrayList(ids.size)
            for (value in ids) {
                data.add(makeRoomRepositoryDataEmbeddeEntity(value, value, value.toString()))
            }
            return data
        }

        fun makeRoomRepositoryHolderEntity(id: Int, ownerId: Int, licenseKey: String): RoomRepositoryDataHolder {
            return RoomRepositoryDataHolder(
                    makeRoomRepositoryDataEntity(id, ownerId, licenseKey),
                    makeRoomLicenseEntity(licenseKey),
                    makeRoomOwnerEntity(ownerId))
        }

        fun makeRoomRepositoryHolderEntityList(ids: Array<Int>, ownerIds: Array<Int>, licenseKeys: Array<String>): List<RoomRepositoryDataHolder> {
            val data: MutableList<RoomRepositoryDataHolder> = ArrayList(ids.size)
            for ((index, value) in ids.withIndex()) {
                data.add(makeRoomRepositoryHolderEntity(value, ownerIds[index], licenseKeys[index]))
            }
            return data
        }

        fun makeRoomRepositoryHolderEntityList(ids: Array<Int>): List<RoomRepositoryDataHolder> {
            val data: MutableList<RoomRepositoryDataHolder> = ArrayList(ids.size)
            for (value in ids) {
                data.add(makeRoomRepositoryHolderEntity(value, value, value.toString()))
            }
            return data
        }
    }
}