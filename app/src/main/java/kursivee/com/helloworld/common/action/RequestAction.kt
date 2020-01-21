package kursivee.com.helloworld.common.action

data class RequestAction(
    val name: String? = null,
    val host: String? = null,
    val endpoint: String? = null
): Action