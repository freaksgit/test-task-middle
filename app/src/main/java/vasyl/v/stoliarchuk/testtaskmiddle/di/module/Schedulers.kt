package vasyl.v.stoliarchuk.testtaskmiddle.di.module

import dagger.Module
import dagger.Provides
import vasyl.v.stoliarchuk.testtaskmiddle.common.schedulers.RxSchedulerProvider
import vasyl.v.stoliarchuk.testtaskmiddle.common.schedulers.SchedulerProvider
import vasyl.v.stoliarchuk.testtaskmiddle.di.AppScope
import vasyl.v.stoliarchuk.testtaskmiddle.di.DiNames
import javax.inject.Named

@Module
class Schedulers {
    @Provides
    @AppScope
    @Named(DiNames.PROVIDER_RX)
    fun provideSchedulerProvider():SchedulerProvider{
        return RxSchedulerProvider()
    }
}