package vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote

import EntityFactory
import io.reactivex.Maybe
import io.reactivex.functions.Function
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import vasyl.v.stoliarchuk.testtaskmiddle.RetrofitEntityFactory
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.GithubApi
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryData
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.remote.retrofit.entity.RetrofitRepositoryDataPack
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.entity.RepositoryData

class RemoteRepositoryDataSourceTest {

    companion object {
        const val queryText: String = "android"
    }

    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    @Mock
    lateinit var githubApi: GithubApi

    @Mock
    lateinit var fromRetrofitMapper: Function<RetrofitRepositoryData, RepositoryData>

    lateinit var remoteRepositoryDataSource: RemoteRepositoryDataSource

    @Before
    fun before() {
        remoteRepositoryDataSource = RemoteRepositoryDataSource(githubApi, fromRetrofitMapper)
    }

    @Test
    fun clearStorage() {
        val testObserver = remoteRepositoryDataSource.clearStorage().test()
        testObserver.assertError(UnsupportedOperationException::class.java)
    }

    @Test
    fun insertRepositories() {
        var testRepositoryDataList: List<RepositoryData> = EntityFactory.makeRepositoryDataEntityList(arrayOf(1))
        val testObserver = remoteRepositoryDataSource.insertRepositories(testRepositoryDataList).test()
        testObserver.assertError(UnsupportedOperationException::class.java)
    }

    @Test
    fun getRepositoriesByText() {
        var testRetrofitRepositoryDataPack: RetrofitRepositoryDataPack = RetrofitEntityFactory.makeRetrofitRepositoryDataPack(arrayOf(1))

        var testRepositoryDataList: List<RepositoryData> = EntityFactory.makeRepositoryDataEntityList(arrayOf(1))

        `when`(githubApi.getRepositoriesByText(queryText)).thenReturn(Maybe.just(testRetrofitRepositoryDataPack))
        `when`(fromRetrofitMapper.apply(testRetrofitRepositoryDataPack.items[0])).thenReturn(testRepositoryDataList[0])

        val testObserver = remoteRepositoryDataSource.getRepositoriesByText(queryText).test()

        testObserver.assertNoErrors()
        testObserver.assertValue(testRepositoryDataList)

        verify(githubApi).getRepositoriesByText(queryText)
        verify(fromRetrofitMapper).apply(testRetrofitRepositoryDataPack.items[0])
    }

}