package cdu.outbox.delivery.rest.account

data class AccountRequest(
    val name: String,
    val email: String,
)