package cdu.outbox.delivery.rest.account

import cdu.outbox.core.account.AccountModule
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class AccountEndpoint(private val accountModule: AccountModule) {
    @PostMapping("/accounts")
    fun createAccount(@RequestBody request: AccountRequest) {
        accountModule.createNewAccount(request.name, request.email)
    }
}