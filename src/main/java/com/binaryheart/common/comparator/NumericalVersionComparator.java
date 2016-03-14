/*
 * Copyright 2016 Farbod Safaei
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.binaryheart.common.comparator;

import java.util.Comparator;

/**
 * <p>
 * {@code NumericalVersionComparator} is a simple {@code String} comparator for
 * comparing two given {@code String} values representing software versions
 * constructed by numbers (0 to 9) and dot ('.') as separators.
 * </p>
 * 
 * Example: <blockquote>
 * 
 * <pre>
 * 0.0.7
 * 1.3.3.7
 * 6.9
 * 6.0.0.6.5
 * </pre>
 * 
 * </blockquote>
 * 
 * The {@code compare} method assumes that supplied version values are
 * constructed using numbers only. There is no limit for the length of
 * parameters (version length). If the length of two versions is not equal,
 * {@code ".0"} is appended to shorter string: When comparing {@code "4.0.1"} to
 * {@code "4.0.1.8"}, the first one assumes to be {@code "4.0.1.0"} and second
 * one remains the same {@code "4.0.1.8"}.
 * 
 * @author Farbod Safaei - farbod@binaryheart.com
 *
 */
public class NumericalVersionComparator implements Comparator<String> {

    /**
     * Compares two given {@code String} parameters. Formatted in a typical
     * software version format using only numbers and dots. It assumes only
     * numeric versions are supplied. {@code NumberFormatException} will be
     * thrown if any non-numeric characters are found in the parameters (except
     * for '.' separator). Both string parameters will be trimmed before
     * comparison.
     * 
     * @param v1
     *            the first string to be compared
     * 
     * @param v2
     *            the second string to be compared
     * 
     * @return If any of the given parameters is {@code null} or is an empty
     *         string like {@code ""}, {@code -1} or {@code 1} will be returned
     *         based on the order: {@code -1} will be returned if the first
     *         parameter is {@code null} or empty, {@code 1} will be returned if
     *         the second parameter is {@code null} or empty. When both are
     *         either {@code null} or empty or any combination of those, a
     *         {@code 0} will be returned.
     * @throws NumberFormatException
     *             If any of parameters contain non-numeric characters
     */
    @Override
    public int compare(String v1, String v2) throws NumberFormatException {
        if ((v1 == null || v1.trim().isEmpty()) && (v2 != null && !v2.trim().isEmpty())) {
            return -1;
        }
        if ((v2 == null || v2.trim().isEmpty()) && (v1 != null && !v1.trim().isEmpty())) {
            return 1;
        }
        if ((v1 == null || v1.trim().isEmpty()) && (v2 == null || v2.trim().isEmpty())) {
            return 0;
        }

        int v1Temp = 0;
        int v2Temp = 0;
        String[] v1Arr = v1.trim().split("\\.");
        String[] v2Arr = v2.trim().split("\\.");
        int max = Integer.max(v1Arr.length, v2Arr.length);

        for (int i = 0; i < max; i++) {
            v1Temp = Integer.parseInt(i != v1Arr.length ? v1Arr[i] : "0");
            v2Temp = Integer.parseInt(i != v2Arr.length ? v2Arr[i] : "0");
            if (v1Temp != v2Temp) {
                break;
            }
        }

        return Integer.signum(v1Temp - v2Temp);
    }

}
