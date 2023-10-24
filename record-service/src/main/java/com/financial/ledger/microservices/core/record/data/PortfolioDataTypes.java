package com.financial.ledger.microservices.core.record.data;

import com.financial.ledger.microservices.core.record.domain.Field;
import com.financial.ledger.microservices.core.record.domain.PortfolioType;
import com.financial.ledger.microservices.core.record.helper.PortfolioHelper;

public interface PortfolioDataTypes {
    Field.Set bankAccountFields = Field.setOf(PortfolioType.BANK_ACCOUNT,
                Field.create("account_number", "Account Number", PortfolioHelper::validateFieldNumeric),
                Field.create("sort_code", "Sort Code", PortfolioHelper::validateFieldNullable),
                Field.create("society_name", "Society Name", PortfolioHelper::validateFieldNullable),
                Field.create("account_type", "Account Type", PortfolioHelper::validateAccountTypeField),
                Field.create("password", "Account Password", PortfolioHelper::validateFieldNullable),
                Field.create("account_balance", "Account Balance", PortfolioHelper::validateFieldNumeric)
    );

    Field.Set pensionFields = Field.setOf(PortfolioType.PENSION,
                Field.create("name", "Provider Name", PortfolioHelper::validateFieldNullable),
                Field.create("website", "Provider Website", PortfolioHelper::validateFieldNullable),
                Field.create("curr_balance", "Current Balance", PortfolioHelper::validateFieldNumeric),
                Field.create("monthly_payment", "Monthly Debit", PortfolioHelper::validateFieldNumeric),
                Field.create("pension_type", "Pension Type", PortfolioHelper::validateAccountTypeField),
                Field.create("user_id", "Login User ID", PortfolioHelper::validateFieldNullable),
                Field.create("password", "Login Password", PortfolioHelper::validateFieldNullable)
    );

    Field.Set tradingAccountFields = Field.setOf(PortfolioType.TRADING_ACCOUNT,
                Field.create("name", "Provider Name", PortfolioHelper::validateFieldNullable),
                Field.create("website", "Provider Website", PortfolioHelper::validateFieldNullable),
                Field.create("account_number", "Account Number", PortfolioHelper::validateFieldNullable),
                Field.create("current_value", "Current Value", PortfolioHelper::validateFieldNumeric),
                Field.create("pension_type", "Pension Type", PortfolioHelper::validateAccountTypeField),
                Field.create("user_id", "Login User ID", PortfolioHelper::validateFieldNullable),
                Field.create("password", "Login Password", PortfolioHelper::validateFieldNullable)
    );

    Field.Set creditCardFields = Field.setOf(PortfolioType.CREDIT_CARD,
                Field.create("number", "Card Number", PortfolioHelper::validateFieldNullable),
                Field.create("website", "Provider Website", PortfolioHelper::validateFieldNullable),
                Field.create("account_number", "Account Number", PortfolioHelper::validateFieldNullable),
                Field.create("outstanding_balance", "Outstanding Balance", PortfolioHelper::validateFieldNumeric),
                Field.create("user_id", "Login User ID", PortfolioHelper::validateFieldNullable),
                Field.create("password", "Login Password", PortfolioHelper::validateFieldNullable)
    );

    Field.Set insuranceCoverFields = Field.setOf(PortfolioType.INSURANCE_COVER,
                Field.create("website", "Provider Website", PortfolioHelper::validateFieldNullable),
                Field.create("account_number", "Account Number", PortfolioHelper::validateFieldNullable),
                Field.create("cover_type", "Type of cover", PortfolioHelper::validateAccountTypeField),
                Field.create("cover_validity", "Valid Until", PortfolioHelper::validateFieldNullable),
                Field.create("user_id", "Login User ID", PortfolioHelper::validateFieldNullable),
                Field.create("password", "Login Password", PortfolioHelper::validateFieldNullable),
                Field.create("notes", "Important Notes", PortfolioHelper::validateFieldNullable),
                Field.create("claim_helpline", "Claim Phone Number", PortfolioHelper::validateFieldNullable)
    );

    Field.Set subscriptionFields = Field.setOf(PortfolioType.SUBSCRIPTIONS,
                Field.create("website", "Provider Website", PortfolioHelper::validateFieldNullable),
                Field.create("account_number", "Account Number", PortfolioHelper::validateFieldNullable),
                Field.create("subscription_type", "Type of Subscription", PortfolioHelper::validateAccountTypeField),
                Field.create("subscription_validity", "Valid Until", PortfolioHelper::validateFieldNullable),
                Field.create("user_id", "Login User ID", PortfolioHelper::validateFieldNullable),
                Field.create("password", "Login Password", PortfolioHelper::validateFieldNullable),
                Field.create("notes", "Important Notes", PortfolioHelper::validateFieldNullable)
    );

    Field.Set combinedPortfolioType = Field.createSetsByPortfolioType(bankAccountFields,
            pensionFields,
            tradingAccountFields,
            creditCardFields,
            insuranceCoverFields,
            subscriptionFields);
}
