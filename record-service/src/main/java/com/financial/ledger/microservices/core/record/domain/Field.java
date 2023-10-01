package com.financial.ledger.microservices.core.record.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

public final class Field {

    private final String name;
    private final String displayName;

    protected Field(String name, String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    public static Field create(String name, String displayName) {
        return new Field(name, displayName);
    }

    public static Set setOf(PortfolioType fieldType, Field... fields) {
        return new Set().with(fieldType, fields);
    }

    public String name() {
        return this.name;
    }

    public String displayName() {
        return this.displayName;
    }

    public static Set createSetsByPortfolioType(Set... fieldsByPortfolioType) {
        if(fieldsByPortfolioType.length == 1) {
            return fieldsByPortfolioType[0];
        }

        Set _aggregatedSets = fieldsByPortfolioType[0];
        for(int i = 1; i < fieldsByPortfolioType.length; i++) {
            Set _tempSet = fieldsByPortfolioType[i];
            Iterator<Map.Entry<PortfolioType, List<Field>>> iterator = _tempSet.iterator();
            if(iterator.hasNext()) {
                Map.Entry<PortfolioType, List<Field>> entry = iterator.next();
                _aggregatedSets.with(entry.getKey(), entry.getValue().toArray(new Field[0]));
            }
        }

        return _aggregatedSets;
    }



    public static final class Set implements Iterable<Map.Entry<PortfolioType, List<Field>>> {
        private final Map<PortfolioType, List<Field>> fieldsByType;

        private Set() {
            fieldsByType = Collections.emptyMap();
        }

        private Set(PortfolioType setType, Collection<Field> allFields) {
            LinkedHashMap<PortfolioType, List<Field>> all = new LinkedHashMap<>();

            allFields.forEach(field -> {
                if(field != null) {
                    if(all.get(setType) == null) {
                        all.put(setType, new ArrayList<>());
                    } else {
                        all.get(setType).add(field);
                    }
                }
            });

            fieldsByType = Collections.unmodifiableMap(all);
        }

        public Set with(PortfolioType setType, Field... fields) {
            if(fields.length == 0) {
                return this;
            }

            LinkedHashSet<Field> allFieldsByType;
            List<Field> existingFieldsByType = fieldsByType.get(setType);
            if(existingFieldsByType == null) {
                allFieldsByType = new LinkedHashSet<>();
            } else {
                allFieldsByType = new LinkedHashSet<>(existingFieldsByType);
            }

            for(Field f : fields) {
                if(f != null) {
                    allFieldsByType.add(f);
                }
            }

            return new Set(setType, allFieldsByType);
        }

        @Override
        public Iterator<Map.Entry<PortfolioType, List<Field>>> iterator() {
            return fieldsByType.entrySet().iterator();
        }

        public List<Field> fetchFieldsByPortfolioType(PortfolioType portfolioType) {
            return Optional.ofNullable(fieldsByType.get(portfolioType)).orElseGet(() -> Collections.emptyList());
        }
    }
}
