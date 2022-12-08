package cdu.outbox.core.account

import com.fasterxml.jackson.annotation.JsonProperty

data class AccountCreatedEvent(
        @JsonProperty("id") val id: String,
        @JsonProperty("email") val email: String,
) : AccountEvent