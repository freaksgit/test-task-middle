package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import vasyl.v.stoliarchuk.testtaskmiddle.App
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.DiNames
import javax.inject.Named

@Module
abstract class AppModule {

    @Binds
    @AppScope
    @Named(DiNames.APP_CONTEXT)
    abstract fun provideApplicationContext(app: App): Context


}