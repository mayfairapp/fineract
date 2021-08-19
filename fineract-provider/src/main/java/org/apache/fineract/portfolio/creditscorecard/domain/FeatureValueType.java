/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.fineract.portfolio.creditscorecard.domain;

import java.util.ArrayList;
import java.util.List;

public enum FeatureValueType {

    BINARY(0, "featureValueType.binary"), NOMINAL(1, "featureValueType.nominal"), INTERVAL(2, "featureValueType.interval"), RATIO(3,
            "featureValueType.ratio"), INVALID(4, "featureValueType.invalid");

    private final Integer value;
    private final String code;

    FeatureValueType(final Integer value, final String code) {
        this.value = value;
        this.code = code;
    }

    public Integer getValue() {
        return this.value;
    }

    public String getCode() {
        return this.code;
    }

    public static FeatureValueType fromInt(final Integer selectedType) {
        FeatureValueType featureValueType = INVALID;
        if (selectedType != null) {
            switch (selectedType) {
                case 0:
                    featureValueType = BINARY;
                break;
                case 1:
                    featureValueType = NOMINAL;
                break;
                case 2:
                    featureValueType = INTERVAL;
                break;
                case 3:
                    featureValueType = RATIO;
                break;
            }
        }
        return featureValueType;
    }

    public boolean isBinary() {
        return this.value.equals(BINARY.getValue());
    }

    public boolean isNominal() {
        return this.value.equals(NOMINAL.getValue());
    }

    public boolean isInterval() {
        return this.value.equals(INTERVAL.getValue());
    }

    public boolean isRatio() {
        return this.value.equals(RATIO.getValue());
    }

    public boolean isInvalid() {
        return this.value.equals(INVALID.getValue());
    }

    public static Object[] integerValues() {
        final List<Integer> values = new ArrayList<>();
        for (final FeatureValueType enumType : values()) {
            if (!enumType.isInvalid()) {
                values.add(enumType.getValue());
            }
        }
        return values.toArray();
    }

    public static Object[] validValues() {
        return new Integer[] { BINARY.getValue(), NOMINAL.getValue(), INTERVAL.getValue(), RATIO.getValue() };
    }

}