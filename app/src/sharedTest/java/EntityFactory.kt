import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.License
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.Owner
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class EntityFactory {
    companion object Factory {
        fun makeRepositoryDataEntity(id: Int, ownerId: Int?, licenseKey: String?): RepositoryData {
            return RepositoryData(
                    id,
                    "nodeId",
                    "name",
                    "fullName",
                    makeOwnerEntity(ownerId),
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
                    makeLicenseEntity(licenseKey),
                    2,
                    2,
                    3,
                    "defaultBranch",
                    0.0)
        }

        fun makeRepositoryDataEntity(id: Int): RepositoryData {
            return makeRepositoryDataEntity(id, id, id.toString())
        }

        fun makeRepositoryDataEntityList(ids: Array<Int>, ownerIds: Array<Int>, licenseKeys: Array<String>): List<RepositoryData> {
            val data: MutableList<RepositoryData> = ArrayList(ids.size)
            for ((index, value) in ids.withIndex()) {
                data.add(makeRepositoryDataEntity(value, ownerIds[index], licenseKeys[index]))
            }
            return data
        }

        fun makeRepositoryDataEntityList(ids: Array<Int>): List<RepositoryData> {
            val data: MutableList<RepositoryData> = ArrayList(ids.size)
            for (value in ids) {
                data.add(makeRepositoryDataEntity(value, value, value.toString()))
            }
            return data
        }

        fun makeOwnerEntity(id: Int?): Owner? {
            if (id == null) {
                return null
            } else {

                return Owner(
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
        }

        fun makeOwnerEntityList(id: Array<Int>): List<Owner?> {
            val data: MutableList<Owner?> = ArrayList(id.size)
            for (value in id) {
                data.add(makeOwnerEntity(value))
            }
            return data
        }

        fun makeLicenseEntity(licenseKey: String?): License? {
            return if (licenseKey == null) {
                null
            } else {
                License(
                        licenseKey,
                        "name",
                        "spdxId",
                        "url",
                        "nodeId")
            }
        }

        fun makeOwnerEntityList(licenseKeys: Array<String>): List<License?> {
            val data: MutableList<License?> = ArrayList(licenseKeys.size)
            for (value in licenseKeys) {
                data.add(makeLicenseEntity(value))
            }
            return data
        }
    }
}