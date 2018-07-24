package vasyl.v.stoliarchuk.testtaskmiddle.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vasyl.v.stoliarchuk.testtaskmiddle.App
import vasyl.v.stoliarchuk.testtaskmiddle.di.module.AppModule
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.RepoSearchComponent
import vasyl.v.stoliarchuk.testtaskmiddle.features.reposearch.RepoSearchModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)

    fun plus(repoSearchModule: RepoSearchModule): RepoSearchComponent
}