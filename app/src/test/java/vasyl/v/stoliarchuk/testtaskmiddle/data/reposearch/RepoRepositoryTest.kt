package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch

import EntityFactory
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs.PreferenceDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.common.data.prefs.PreferenceRepository
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.local.LocalRepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.RemoteRepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData


open class RepoRepositoryTest {

    companion object {
        const val queryText: String = "android"
    }

    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var local: RepositoryDataSource

    @Mock
    lateinit var remote: RepositoryDataSource

    @Mock
    lateinit var preference: PreferenceDataSource

    lateinit var repository: RepoRepository

    @Before
    fun before() {
        repository = RepoRepository(local, remote, preference)
    }

    @Test
    fun getRepositoriesDataNotCachedTest() {
        val testRepositoryDataList: List<RepositoryData> = EntityFactory.makeRepositoryDataEntityList(arrayOf(1, 2, 3, 4))
        `when`(local.clearStorage()).thenReturn(Completable.complete())
        `when`(local.insertRepositories(testRepositoryDataList)).thenReturn(Completable.complete())
        `when`(remote.getRepositoriesByText(queryText)).thenReturn(Maybe.just(testRepositoryDataList))
        `when`(preference.getString(RepoRepository.KEY_LAST_QUERY_TEXT, "")).thenReturn("")

        val testObserver: TestObserver<List<RepositoryData>> = repository.getRepositoriesByText(queryText).test()

        testObserver.assertNoErrors()
        testObserver.assertValue(testRepositoryDataList)

        verify(remote, times(2)).getRepositoriesByText(queryText)
        verify(preference, times(1)).getString(RepoRepository.KEY_LAST_QUERY_TEXT, "")
        verify(preference, times(1)).putString(RepoRepository.KEY_LAST_QUERY_TEXT, queryText)
        verify(local, times(0)).getRepositoriesByText(queryText)
        verify(local, times(1)).insertRepositories(testRepositoryDataList)
        verify(local, times(1)).clearStorage()
    }


    @Test
    fun getRepositoriesDataCachedTest() {
        val testRepositoryDataList: List<RepositoryData> = EntityFactory.makeRepositoryDataEntityList(arrayOf(1, 2, 3, 4))
        `when`(local.getRepositoriesByText(queryText)).thenReturn(Maybe.just(testRepositoryDataList))
        `when`(preference.getString(RepoRepository.KEY_LAST_QUERY_TEXT, "")).thenReturn(queryText)

        val testObserver: TestObserver<List<RepositoryData>> = repository.getRepositoriesByText(queryText).test()

        testObserver.assertNoErrors()
        testObserver.assertValue(testRepositoryDataList)

        verify(remote, times(0)).getRepositoriesByText(queryText)
        verify(preference, times(1)).getString(RepoRepository.KEY_LAST_QUERY_TEXT, "")
        verify(preference, times(0)).putString(RepoRepository.KEY_LAST_QUERY_TEXT, queryText)
        verify(local, times(1)).getRepositoriesByText(queryText)
        verify(local, times(0)).insertRepositories(testRepositoryDataList)
        verify(local, times(0)).clearStorage()
    }

    @Test
    fun clearStorageTest() {
        `when`(local.clearStorage()).thenReturn(Completable.complete())

        val testObserver: TestObserver<Void> = repository.clearStorage().test()

        testObserver.assertNoErrors()
        testObserver.assertComplete()

        verify(remote, times(0)).clearStorage()
        verify(local, times(1)).clearStorage()
    }

    @Test
    fun insertRepositoriesTest() {
        val testRepositoryDataList: List<RepositoryData> = EntityFactory.makeRepositoryDataEntityList(arrayOf(1, 2, 3, 4))
        `when`(local.insertRepositories(testRepositoryDataList)).thenReturn(Completable.complete())

        val testObserver: TestObserver<Void> = repository.insertRepositories(testRepositoryDataList).test()

        testObserver.assertNoErrors()
        testObserver.assertComplete()

        verify(remote, times(0)).clearStorage()
        verify(local, times(1)).insertRepositories(testRepositoryDataList)
    }
}