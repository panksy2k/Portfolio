package com.financial.ledger.microservices.core.record.domain;

public enum PortfolioType {
        ASSET("ast"),
        LIABILITY("lb"),
        INCOME("inc"),
        CREDENTIALS("cred");

        private final String code;

        PortfolioType(String code) {
            this.code = code;
        }

        public String code() {
            return this.code;
        }

        public static PortfolioType forCode(String code) {
            for (PortfolioType pt : PortfolioType.values()) {
                if (pt.code().equalsIgnoreCase(code)) {
                    return pt;
                }
            }

            return null;
        }
    }

