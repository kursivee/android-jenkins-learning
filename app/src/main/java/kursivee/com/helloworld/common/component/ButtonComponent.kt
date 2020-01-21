package kursivee.com.helloworld.common.component

import kursivee.com.helloworld.common.action.Action

data class ButtonComponent(
    val title: String? = null,
    val action: Action? = null
): Component