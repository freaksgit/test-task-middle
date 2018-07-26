package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnit
import vasyl.v.stoliarchuk.testtaskmiddle.R

open class RepoSearchPresenterTest {
    @get:Rule
    public var mockitoRule = MockitoJUnit.rule()


    @Mock
    lateinit var mvpView: RepoSearchContract.View

    lateinit var presenter: RepoSearchPresenter

    @Before
    fun before() {
        presenter = RepoSearchPresenter(mvpView)
    }


    private val validText = "abc"
    private val invalidText = ""

    @Test
    fun onSearchButtonClickedValidText() {
        `when`(mvpView.getSearchQueryText()).thenReturn(validText)
        presenter.onSearchButtonClicked()

        verify(mvpView).getSearchQueryText()
        verify(mvpView).toggleEmptyQueryErrorMessageVisibility(false)
        verify(mvpView).startSearch(validText)
    }

    @Test
    fun onSearchButtonClickedInvalidText() {
        `when`(mvpView.getSearchQueryText()).thenReturn(invalidText)
        presenter.onSearchButtonClicked()

        verify(mvpView).getSearchQueryText()
        verify(mvpView).toggleEmptyQueryErrorMessageVisibility(true)
        verify(mvpView, never()).startSearch(invalidText)
    }

    @Test
    fun onSearchStarted() {
        presenter.onSearchStarted()

        verify(mvpView).toggleProgressVisibility(true)
        verify(mvpView).setQueryButtonText(R.string.activity_repo_search_cancel_button)
    }

    @Test
    fun onSearchCompleted() {
        presenter.onSearchCompleted()

        verify(mvpView).toggleProgressVisibility(false)
        verify(mvpView).setQueryButtonText(R.string.activity_repo_search_query_button)
    }

    @Test
    fun onSearchCanceled() {
        presenter.onSearchCanceled()

        verify(mvpView).toggleProgressVisibility(false)
        verify(mvpView).setQueryButtonText(R.string.activity_repo_search_query_button)
    }

    @Test
    fun onSearchError() {
        presenter.onSearchError(Exception())

        verify(mvpView).toggleProgressVisibility(false)
        verify(mvpView).setQueryButtonText(R.string.activity_repo_search_query_button)
        verify(mvpView).showErrorMessage()
    }
}