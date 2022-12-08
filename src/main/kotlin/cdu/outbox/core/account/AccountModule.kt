package cdu.outbox.core.account

import org.springframework.stereotype.Component

@Component
class AccountModule(private val accountRepo: AccountRepo) {
    fun createNewAccount(name: String, email: String) {
        val account = Account(name = name, email = email)
        val relatedEvents = account.generateEvent()

        accountRepo.save(account, relatedEvents)
    }
}