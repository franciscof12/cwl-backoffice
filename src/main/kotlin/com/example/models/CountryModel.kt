package com.example.models

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Country(val cId: String, val fkCIdTblLanguages: String?, val fkSCurrencyTblCurrencies: String, val sBillingCurrency: String?, val sName: String, val bIsActive: Boolean, val bIsSandboxActive: Boolean?, val sSimilarNames: String?)

object Countries : Table("tbl_countries") {
     val id = varchar("c_id", 255).uniqueIndex()
     val fkCIdTblLanguages = char("fk_c_id_tbl_languages", 5).nullable()
     val fkSCurrencyTblCurrencies = char("fk_s_currency_tbl_currencies", 3).default("EUR")
     val sBillingCurrency = char("s_billing_currency", 3).nullable()
     val sName = varchar("s_name", 255)
     val bIsActive = bool("b_is_active").default(false)
     val bIsSandboxActive = bool("b_is_sandbox_active").nullable()
     val sSimilarNames = text("s_similar_names").nullable()

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}
