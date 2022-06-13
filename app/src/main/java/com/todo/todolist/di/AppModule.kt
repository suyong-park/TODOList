package com.todo.todolist.di

import com.todo.core.log.*
import com.todo.presentation.ui.calendar.CalendarViewModel
import com.todo.presentation.ui.common.BaseViewModel
import com.todo.presentation.ui.home.HomeDialogViewModel
import com.todo.presentation.ui.home.HomeViewModel
import com.todo.presentation.ui.intro.IntroViewModel
import com.todo.presentation.ui.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { BaseViewModel() }
    viewModel { HomeViewModel() }
    viewModel { HomeDialogViewModel() }
    viewModel { CalendarViewModel() }
    viewModel { IntroViewModel() }
    viewModel { SettingViewModel() }
}

val loggerModules = module {
    single { AndroidLogger() }
    single { LogFileLogger() }
    single { CrashlyticsLogger() }
    single<Logger> { CombinedLogger(listOf(AndroidLogger(), LogFileLogger(), CrashlyticsLogger())) }
}

val repositoryModules = module {

}

val useCaseModules = module {

}

val appModules = listOf(viewModelModules, loggerModules)