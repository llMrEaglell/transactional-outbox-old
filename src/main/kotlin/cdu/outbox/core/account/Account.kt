package cdu.outbox.core.account

import java.util.*

data class Account(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
) {
    fun generateEvent(): List<AccountCreatedEvent> {
        return listOf(AccountCreatedEvent(id, email))
    }
}
