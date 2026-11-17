package com.example.practicaandroid

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
<<<<<<< HEAD
        assertEquals("com.example.practicaandroid1", appContext.packageName)
=======
        assertEquals("com.example.practicaandroid", appContext.packageName)
>>>>>>> 20a85884e1ce7cddedf7a72b68028f7482935d4c
    }
}