package com.deadrudolph.template_mvvm.presentation.ui.activity

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.deadrudolph.core.base.action.ActivityActions
import com.deadrudolph.navigation.GlobalNavTarget
import com.deadrudolph.navigation.Navigator
import com.deadrudolph.navigation.di.component.NavigationComponentHolder
import com.deadrudolph.template_mvvm.R
import com.deadrudolph.template_mvvm.di.component.main.AppComponentHolder
import com.deadrudolph.template_mvvm.navigation.host.NavigationComponent
import com.deadrudolph.template_mvvm.navigation.tab.TabItem
import com.deadrudolph.uicomponents.compose.theme.CustomTheme
import com.deadrudolph.uicomponents.compose.theme.DefaultTheme

internal class MainActivity : ComponentActivity(), ActivityActions {

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        theme.applyStyle(R.style.Theme_Template, true)
        return theme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponentHolder.getInternal().inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            DefaultTheme {
                Surface {
                    val navigator: Navigator = NavigationComponentHolder.get().navigator()
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = { NavBar(navController = navController) },
                        content = { paddingValues ->
                            ScreenContent(
                                paddingValues = paddingValues,
                                navController = navController,
                                navigator = navigator,
                            )
                        }
                    )
                }
            }
        }
    }

    @Composable
    private fun ScreenContent(
        paddingValues: PaddingValues,
        navController: NavHostController,
        navigator: Navigator,
    ) {
        Box(Modifier.padding(paddingValues)) {
            NavigationComponent(
                navController = navController,
                navigator = navigator
            )
        }
    }

    @Composable
    private fun NavBar(
        navController: NavController,
    ) {
        BottomNavigation(
            backgroundColor = CustomTheme.colors.white_100
        ) {
            getBottomItems().forEach { tab ->
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                BottomTabItem(
                    tab = tab,
                    isSelectedTab = currentRoute == tab.route,
                    onClick = {
                        navController.navigate(tab.route) {
                            // Pop up to the start destination of the graph to
                            // avoid building up a large stack of destinations
                            // on the back stack as users select items
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // Avoid multiple copies of the same destination when
                            // reselecting the same item
                            launchSingleTop = true
                            // Restore state when reselecting a previously selected item
                            restoreState = true
                        }
                    }
                )
            }
        }
    }

    @Composable
    fun RowScope.BottomTabItem(
        tab: TabItem,
        isSelectedTab: Boolean,
        onClick: () -> Unit,
    ) {
        BottomNavigationItem(
            selected = isSelectedTab,
            onClick = onClick,
            icon = {
                Icon(
                    imageVector = tab.icon,
                    contentDescription = ""
                )
            },
            label = {
                Text(
                    text = stringResource(id = tab.label),
                )
            },
        )
    }

    private fun getBottomItems(): List<TabItem> {
        return listOf(
            TabItem(
                label = com.deadrudolph.feature_home.R.string.home,
                icon = Icons.Default.Home,
                route = GlobalNavTarget.HomeModule.target.route
            ),
            TabItem(
                label = com.deadrudolph.feature_profile.R.string.profile,
                icon = Icons.Default.Person,
                route = GlobalNavTarget.ProfileModule.target.route
            )
        )
    }
}
