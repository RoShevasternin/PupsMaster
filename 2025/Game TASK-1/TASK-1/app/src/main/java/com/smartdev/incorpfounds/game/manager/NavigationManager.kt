package com.smartdev.incorpfounds.game.manager

import com.badlogic.gdx.Gdx
import com.smartdev.incorpfounds.game.screens.*
import com.smartdev.incorpfounds.game.screens.savings.SavingsEditScreen
import com.smartdev.incorpfounds.game.screens.savings.SavingsInputScreen
import com.smartdev.incorpfounds.game.screens.savings.SavingsResultScreen
import com.smartdev.incorpfounds.game.screens.savings.SavingsScreen
import com.smartdev.incorpfounds.game.screens.test.SelectedTestScreen
import com.smartdev.incorpfounds.game.screens.test.TestResultScreen
import com.smartdev.incorpfounds.game.screens.test.TestScreen
import com.smartdev.incorpfounds.game.utils.advanced.AdvancedScreen
import com.smartdev.incorpfounds.game.utils.gdxGame
import com.smartdev.incorpfounds.game.utils.runGDX

class NavigationManager {

    private val backStack = mutableListOf<String>()

    fun navigate(toScreenName: String, fromScreenName: String? = null) = runGDX {
        gdxGame.updateScreen(getScreenByName(toScreenName))
        backStack.filter { name -> name == toScreenName }.onEach { name -> backStack.remove(name) }
        fromScreenName?.let { fromName ->
            backStack.filter { name -> name == fromName }.onEach { name -> backStack.remove(name) }
            backStack.add(fromName)
        }
    }

    fun back() = runGDX {
        if (isBackStackEmpty()) exit() else gdxGame.updateScreen(getScreenByName(backStack.removeAt(backStack.lastIndex)))
    }

    fun exit() = runGDX { Gdx.app.exit() }


    fun isBackStackEmpty() = backStack.isEmpty()

    private fun getScreenByName(name: String): AdvancedScreen = when(name) {
        LoaderScreen    ::class.java.name -> LoaderScreen()
        DashboardScreen ::class.java.name -> DashboardScreen()

        SavingsScreen      ::class.java.name -> SavingsScreen()
        SavingsInputScreen ::class.java.name -> SavingsInputScreen()
        SavingsResultScreen::class.java.name -> SavingsResultScreen()
        SavingsEditScreen  ::class.java.name -> SavingsEditScreen()

        CalculatorScreen::class.java.name -> CalculatorScreen()
        GlossaryScreen  ::class.java.name -> GlossaryScreen()

        TestScreen        ::class.java.name -> TestScreen()
        SelectedTestScreen::class.java.name -> SelectedTestScreen()
        TestResultScreen  ::class.java.name -> TestResultScreen()

        else -> DashboardScreen()
    }

}
