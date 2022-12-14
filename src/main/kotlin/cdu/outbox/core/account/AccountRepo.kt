package cdu.outbox.core.account

interface AccountRepo {
    fun save(account: Account, relatedEvents: List<AccountEvent>)
}