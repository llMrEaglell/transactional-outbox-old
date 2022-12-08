package cdu.outbox.adapter

import cdu.outbox.core.account.Account
import cdu.outbox.core.account.AccountEvent
import cdu.outbox.core.account.AccountRepo
import cdu.outbox.infrastructure.db.OutboxMessage
import cdu.outbox.infrastructure.db.SpringAccountRepo
import cdu.outbox.infrastructure.db.SpringOutboxMessageRepo
import cdu.outbox.infrastructure.json.JsonMapper
import org.springframework.stereotype.Component
import javax.transaction.Transactional

@Component
class AccountRepoAdapter(
    private val accountRepo: SpringAccountRepo,
    private val outboxMessageRepo: SpringOutboxMessageRepo,
    private val jsonMapper: JsonMapper,
) : AccountRepo {

    @Transactional
    override fun save(account: Account, relatedEvents: List<AccountEvent>) {
        accountRepo.save(account.toEntity())
        outboxMessageRepo.saveAll(
            relatedEvents.map {
                OutboxMessage(
                    eventType = it.javaClass.canonicalName,
                    jsonContent = jsonMapper.toJson(it)
                )
            }.toList()
        )
    }

    private fun Account.toEntity(): cdu.outbox.infrastructure.db.Account{
        return cdu.outbox.infrastructure.db.Account(id, name, email)
    }
}