package com.testtask.androiddev.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.testtask.androiddev.presentation.composables.nav_host.NavigationHost
import com.testtask.androiddev.presentation.theme.TestTaskAndroidDevTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestTaskAndroidDevTheme {
                NavigationHost()
            }
        }
    }
}