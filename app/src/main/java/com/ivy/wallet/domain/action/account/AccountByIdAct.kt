package com.ivy.wallet.domain.action.account

import com.ivy.fp.action.FPAction
import com.ivy.fp.action.then
import com.ivy.wallet.domain.data.core.Account
import com.ivy.wallet.io.persistence.dao.AccountDao
import java.util.*
import javax.inject.Inject

class AccountByIdAct @Inject constructor(
    private val accountDao: AccountDao
) : FPAction<UUID, Account?>() {
    override suspend fun UUID.compose(): suspend () -> Account? = suspend {
        this //accountId
    } then accountDao::findById then {
        it?.toDomain()
    }
}