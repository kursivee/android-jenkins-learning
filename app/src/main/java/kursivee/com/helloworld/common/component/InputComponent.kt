package kursivee.com.helloworld.common.component

data class InputComponent(
    val title: String
): Component


/**
 * Need to figure out how to make this more generic
 */
data class UsernameComponent(
    val title: String
): Component

data class PasswordComponent(
    val title: String
): Component