package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment

import EntityFactory
import io.reactivex.Maybe
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnit
import vasyl.v.stoliarchuk.testtaskmiddle.common.schedulers.SchedulerProvider
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource

open class RepoSearchFrPresenterTest {
    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()

    private val text = "test"

    @Mock
    lateinit var mvpView: RepoSearchFrContract.View

    @Mock
    lateinit var repository: RepositoryDataSource

    @Mock
    lateinit var schedulerProvider: SchedulerProvider

    lateinit var presenter: RepoSearchFrPresenter

    @Before
    fun before() {
        presenter = RepoSearchFrPresenter(mvpView, repository, schedulerProvider)
        `when`(schedulerProvider.io()).thenReturn(Schedulers.trampoline())
        `when`(schedulerProvider.ui()).thenReturn(Schedulers.trampoline())
    }


    @Test
    fun startSearchInProgress() {
        presenter.inProgress = true
        presenter.startSearch(text)

        verify(mvpView).onSearchCanceled()
    }

    @Test
    fun startSearchNotInProgressSuccess() {
        val repositoryDataEntityList = EntityFactory.makeRepositoryDataEntityList(arrayOf(1, 2))
        `when`(repository.getRepositoriesByText(text)).thenReturn(Maybe.just(repositoryDataEntityList))

        presenter.startSearch(text)

        verify(mvpView).showRepositories(repositoryDataEntityList)
        verify(mvpView).onComplete()
    }

    @Test
    fun startSearchNotInProgressComplete() {
        `when`(repository.getRepositoriesByText(text)).thenReturn(Maybe.empty())

        presenter.startSearch(text)

        verify(mvpView).onComplete()
    }

    @Test
    fun startSearchNotInProgressError() {
        val exception = Exception()
        `when`(repository.getRepositoriesByText(text)).thenReturn(Maybe.error(exception))

        presenter.startSearch(text)

        verify(mvpView).onError(exception)
    }


}