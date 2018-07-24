package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vasyl.v.stoliarchuk.testtaskmiddle.di.ActivityScope
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.RepoSearchActivity
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.RepoSearchModule

@Module
abstract class AndroidModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(RepoSearchModule::class))
    internal abstract fun repoSearchActivityInjector(): RepoSearchActivity

}