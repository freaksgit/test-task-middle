package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import dagger.Binds
import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.common.schedulers.SchedulerProvider
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.di.ActivityScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.DiNames
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.RepoSearchFrContract
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.RepoSearchFrPresenter
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.fragment.RepoSearchFragment
import javax.inject.Named

@Module
abstract class RepoSearchModule {

    @Binds
    abstract fun bindRepoSearchView(repoSearchActivity: RepoSearchActivity): RepoSearchContract.View

    @Binds
    abstract fun bindRepoSearchFrView(repoSearchFragment: RepoSearchFragment): RepoSearchFrContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideRepoSearchPresenter(view: RepoSearchContract.View): RepoSearchContract.Presenter {
            return RepoSearchPresenter(view)
        }

        @JvmStatic
        @Provides
        @ActivityScope
        fun provideRepoSearchFrPresenter(view: RepoSearchFrContract.View,
                                         @Named(DiNames.REPOSITORY) repDataRepository: RepositoryDataSource,
                                         @Named(DiNames.PROVIDER_RX) schedulerProvider: SchedulerProvider): RepoSearchFrContract.Presenter {
            return RepoSearchFrPresenter(view, repDataRepository, schedulerProvider)
        }
    }
}