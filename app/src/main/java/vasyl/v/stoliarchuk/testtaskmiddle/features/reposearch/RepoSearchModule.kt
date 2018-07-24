package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import dagger.Binds
import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.di.ActivityScope

@Module
abstract class RepoSearchModule {

    @Binds
    abstract fun bindRepoSearchView(repoSearchActivity: RepoSearchActivity): RepoSearchContract.View

    @Module
    companion object {
        @JvmStatic
        @Provides
        @ActivityScope
        fun provideRepoSearchPresenter(view: RepoSearchContract.View): RepoSearchContract.Presenter {
            return RepoSearchPresenter(view)
        }
    }
}