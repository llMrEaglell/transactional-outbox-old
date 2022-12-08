package cdu.outbox.infrastructure.db

import org.springframework.data.repository.CrudRepository

interface SpringAccountRepo : CrudRepository<Account, String>