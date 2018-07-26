package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local

import EntityFactory
import RoomEntityFactory
import io.reactivex.Maybe
import io.reactivex.functions.Function
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.GithubDatabase
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.LicenseDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.OwnerDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.dao.RepositoryDataDao
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataEmbedded
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.room.entity.RoomRepositoryDataHolder
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

open class LocalRepositoryDataSourceTest {
    companion object {
        const val queryText: String = "android"
    }

    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var githubDatabase: GithubDatabase

    @Mock
    lateinit var repositoryDataEmbeddedFromRoomMapper: Function<RoomRepositoryDataEmbedded, RepositoryData>

    @Mock
    lateinit var repositoryDataToRoomHolderMapper: Function<RepositoryData, RoomRepositoryDataHolder>

    @Mock
    lateinit var repositoryDataDao: RepositoryDataDao

    @Mock
    lateinit var ownerDao: OwnerDao

    @Mock
    lateinit var licenseDao: LicenseDao

    lateinit var localRepositoryDataSource: LocalRepositoryDataSource

    lateinit var testRepositoryDataEmbeddedList: List<RoomRepositoryDataEmbedded>
    lateinit var testRepositoryDataList: List<RepositoryData>
    lateinit var testRepositoryDataHolderList: List<RoomRepositoryDataHolder>

    @Before
    fun before() {
        localRepositoryDataSource = LocalRepositoryDataSource(githubDatabase, repositoryDataEmbeddedFromRoomMapper, repositoryDataToRoomHolderMapper)
        testRepositoryDataEmbeddedList = RoomEntityFactory.makeRoomRepositoryDataEmbeddeEntityList(arrayOf(1))
        testRepositoryDataList = EntityFactory.makeRepositoryDataEntityList(arrayOf(1))
        testRepositoryDataHolderList = RoomEntityFactory.makeRoomRepositoryHolderEntityList(arrayOf(1))
    }

    @Test
    fun getRepositoriesByTextTest() {
        `when`(githubDatabase.repositoryDataDao()).thenReturn(repositoryDataDao)
        `when`(repositoryDataDao.getEmbeddedRepositories()).thenReturn(Maybe.just(testRepositoryDataEmbeddedList))
        `when`(repositoryDataEmbeddedFromRoomMapper.apply(testRepositoryDataEmbeddedList[0])).thenReturn(testRepositoryDataList[0])

        val testObserver = localRepositoryDataSource.getRepositoriesByText(queryText).test()

        testObserver.assertNoErrors()
        testObserver.assertValue(testRepositoryDataList)

        verify(githubDatabase).repositoryDataDao()
        verify(repositoryDataDao).getEmbeddedRepositories()
        verify(repositoryDataEmbeddedFromRoomMapper).apply(testRepositoryDataEmbeddedList[0])
    }

    @Test
    fun clearStorageTest() {
        doNothing().`when`(githubDatabase).clearAndResetAllTables()

        val testObserver = localRepositoryDataSource.clearStorage().test()
        testObserver.assertNoErrors()
        testObserver.assertComplete()

        verify(githubDatabase).clearAndResetAllTables()
    }

    @Test
    fun insertRepositoriesTest() {
        `when`(githubDatabase.repositoryDataDao()).thenReturn(repositoryDataDao)
        `when`(githubDatabase.onwerDao()).thenReturn(ownerDao)
        `when`(githubDatabase.licenseDao()).thenReturn(licenseDao)
        `when`(repositoryDataToRoomHolderMapper.apply(testRepositoryDataList[0])).thenReturn(testRepositoryDataHolderList[0])
        val testObserver = localRepositoryDataSource.insertRepositories(testRepositoryDataList).test()

        testObserver.assertNoErrors()
        testObserver.assertComplete()

        verify(githubDatabase).repositoryDataDao()
        verify(githubDatabase).onwerDao()
        verify(githubDatabase).licenseDao()
        verify(ownerDao).insert(testRepositoryDataHolderList[0].roomOwner!!)
        verify(repositoryDataDao).insert(testRepositoryDataHolderList[0].roomRepositoryData!!)
        verify(licenseDao).insert(testRepositoryDataHolderList[0].roomLicense!!)
        verify(repositoryDataToRoomHolderMapper).apply(testRepositoryDataList[0])
    }

}