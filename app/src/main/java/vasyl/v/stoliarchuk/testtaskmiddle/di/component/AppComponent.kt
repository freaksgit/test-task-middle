package vasyl.v.stoliarchuk.testtaskmiddle.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import vasyl.v.stoliarchuk.testtaskmiddle.App
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.module.*
import javax.inject.Singleton

@AppScope
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AndroidModule::class,
    AppModule::class,
    DataMappingModule::class,
    DataModule::class,
    NetworkModule::class
])
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }

    override fun inject(app: App)
}