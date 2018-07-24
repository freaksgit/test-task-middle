package vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch

import dagger.Subcomponent
import vasyl.v.stoliarchuk.testtaskmiddle.di.ActivityScope

@ActivityScope
@Subcomponent(modules = [RepoSearchModule::class])
interface RepoSearchComponent {
    fun inject(repoSearchActivity: RepoSearchActivity): RepoSearchActivity
}