package com.financial.ledger.microservices.core.record.data;

import com.financial.ledger.microservices.core.record.domain.Field;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;

public interface PortfolioDataTypes {
    Field.Set bankAccountFields = Field.setOf(PortfolioType.BANK_ACCOUNT,
                Field.create("account_number", "Account Number"),
                Field.create("sort_code", "Sort Code"),
                Field.create("society_name", "Society Name"),
                Field.create("account_type", "Account Type"),
                Field.create("password", "Account Password"),
                Field.create("account_balance", "Account Balance")
    );

    Field.Set pensionFields = Field.setOf(PortfolioType.PENSION,
                Field.create("name", "Provider Name"),
                Field.create("website", "Provider Website"),
                Field.create("curr_balance", "Current Balance"),
                Field.create("monthly_payment", "Monthly Debit"),
                Field.create("pension_type", "Pension Type"),
                Field.create("user_id", "Login User ID"),
                Field.create("password", "Login Password")
    );

    Field.Set tradingAccountFields = Field.setOf(PortfolioType.TRADING_ACCOUNT,
                Field.create("name", "Provider Name"),
                Field.create("website", "Provider Website"),
                Field.create("account_number", "Account Number"),
                Field.create("current_value", "Current Value"),
                Field.create("pension_type", "Pension Type"),
                Field.create("user_id", "Login User ID"),
                Field.create("password", "Login Password")
    );

    Field.Set creditCardFields = Field.setOf(PortfolioType.CREDIT_CARD,
                Field.create("number", "Card Number"),
                Field.create("website", "Provider Website"),
                Field.create("account_number", "Account Number"),
                Field.create("outstanding_balance", "Outstanding Balance"),
                Field.create("user_id", "Login User ID"),
                Field.create("password", "Login Password")
    );

    Field.Set insuranceCoverFields = Field.setOf(PortfolioType.INSURANCE_COVER,
                Field.create("website", "Provider Website"),
                Field.create("account_number", "Account Number"),
                Field.create("cover_type", "Type of cover"),
                Field.create("cover_validity", "Valid Until"),
                Field.create("user_id", "Login User ID"),
                Field.create("password", "Login Password"),
                Field.create("notes", "Important Notes"),
                Field.create("claim_helpline", "Claim Phone Number")
    );

    Field.Set subscriptionFields = Field.setOf(PortfolioType.SUBSCRIPTIONS,
                Field.create("website", "Provider Website"),
                Field.create("account_number", "Account Number"),
                Field.create("subscription_type", "Type of Subscription"),
                Field.create("subscription_validity", "Valid Until"),
                Field.create("user_id", "Login User ID"),
                Field.create("password", "Login Password"),
                Field.create("notes", "Important Notes")
    );

    Field.Set combinedPortfolioType = Field.createSetsByPortfolioType(bankAccountFields,
            pensionFields,
            tradingAccountFields,
            creditCardFields,
            insuranceCoverFields,
            subscriptionFields);
}
