package cdu.outbox.infrastructure.event

data class OutboxMessage(val type: String, val content: Any)
