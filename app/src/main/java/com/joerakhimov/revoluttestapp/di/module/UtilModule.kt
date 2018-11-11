package com.joerakhimov.revoluttestapp.di.module

import android.content.Context
import com.joerakhimov.revoluttestapp.util.code.CodeConverter
import com.joerakhimov.revoluttestapp.util.code.CodeConverterImpl
import com.joerakhimov.revoluttestapp.util.concurrency.scheduler.SchedulerProvider
import com.joerakhimov.revoluttestapp.util.concurrency.scheduler.SchedulerProviderImpl
import com.joerakhimov.revoluttestapp.util.image.ImageLoader
import com.joerakhimov.revoluttestapp.util.image.ImageLoaderImpl
import com.joerakhimov.revoluttestapp.util.log.LogUtil
import com.joerakhimov.revoluttestapp.util.log.LogUtilImpl
import com.joerakhimov.revoluttestapp.util.text.TextUtil
import com.joerakhimov.revoluttestapp.util.text.TextUtilImpl
import dagger.Module
import dagger.Provides

@Module
class UtilModule {

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = SchedulerProviderImpl()

    @Provides
    fun provideImageLoader(context: Context): ImageLoader = ImageLoaderImpl(context)

    @Provides
    fun provideCodeConverter(): CodeConverter = CodeConverterImpl()

    @Provides
    fun provideTextUtil(): TextUtil = TextUtilImpl()

    @Provides
    fun provideLogUtil(): LogUtil = LogUtilImpl()

}