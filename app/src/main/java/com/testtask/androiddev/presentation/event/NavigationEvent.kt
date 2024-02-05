package com.testtask.androiddev.presentation.event

sealed interface NavigationEvent {

    data class OnNavigate(val numberInfo: String): NavigationEvent
}