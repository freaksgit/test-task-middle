package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import dagger.Binds
import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.data.reposearch.datasource.RepositoryDataSource
import vasyl.v.stoliarchuk.testtaskmiddle.di.ActivityScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.DiNames
import javax.inject.Named

@Module
abstract class RepoSearchModule {

    @Binds
    abstract fun bindRepoSearchView(repoSearchActivity: RepoSearchActivity): RepoSearchContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideRepoSearchPresenter(view: RepoSearchContract.View,
                                       @Named(DiNames.REPOSITORY)repDataRepository: RepositoryDataSource): RepoSearchContract.Presenter {
            return RepoSearchPresenter(view, repDataRepository)
        }
    }
}