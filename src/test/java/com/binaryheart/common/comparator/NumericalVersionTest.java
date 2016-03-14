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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Sample test class
 * 
 * @author Farbod Safaei
 *
 */
public class NumericalVersionTest {

    String v1 = "3.5.6";
    String v2 = "3.5.7";
    String v3 = "5.0.1.1";
    String v4 = "5.0.2";
    String v5 = "18.3.0.5.2.5.2.1.45.6.9.244.5.13";
    String v6 = "0.0.0.4";
    String v7 = "1.0";
    String v8 = "5.0.2";
    String v9 = null;

    @Test
    public void compareTwoNonEqual() {
        NumericalVersionComparator versionComparator = new NumericalVersionComparator();
        Assert.assertEquals(-1, versionComparator.compare(v1, v2));
    }

    @Test
    public void compareTwoEqual() {
        NumericalVersionComparator versionComparator = new NumericalVersionComparator();
        Assert.assertEquals(0, versionComparator.compare(v4, v8));
    }

    @Test
    public void compareOneNull() {
        NumericalVersionComparator versionComparator = new NumericalVersionComparator();
        Assert.assertEquals(1, versionComparator.compare(v1, v9));
    }

    @Test
    public void sortedList() {
        List<String> list = new ArrayList<String>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        list.add(v5);
        list.add(v6);
        list.add(v7);
        list.add(v8);

        Collections.sort(list);
        String[] defaultSorted = list.toArray(new String[list.size()]);

        list.sort(new NumericalVersionComparator());
        String[] versionSorted = list.toArray(new String[list.size()]);

        /*
         * Sorted order using default Collections sort: [0.0.0.4, 1.0, 18.3.0.5.2.5.2.1.45.6.9.244.5.13, 3.5.6, 3.5.7, 5.0.1.1, 5.0.2, 5.0.2]
         * 
         * Sorted order using comparator: [0.0.0.4, 1.0, 3.5.6, 3.5.7, 5.0.1.1, 5.0.2, 5.0.2, 18.3.0.5.2.5.2.1.45.6.9.244.5.13]
         */

        Assert.assertNotEquals(Arrays.toString(defaultSorted), Arrays.toString(versionSorted));

    }
}
