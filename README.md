# version-number-comparator [![Build Status](https://travis-ci.org/farbodsafaei/version-number-comparator.svg?branch=master)](https://travis-ci.org/farbodsafaei/version-number-comparator)  [![codecov](https://codecov.io/gh/farbodsafaei/version-number-comparator/branch/master/graph/badge.svg)](https://codecov.io/gh/farbodsafaei/version-number-comparator)  [![Codacy Badge](https://api.codacy.com/project/badge/Grade/d7be704fa75c4da0880171797070772b)](https://www.codacy.com/app/farbod-safaei/version-number-comparator?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=farbodsafaei/version-number-comparator&amp;utm_campaign=Badge_Grade)

A simple string comparator for comparing two given values representing software versions constructed by only numbers (0 to 9) and dots as separators. It compares two strings that are formatted in a typical software version format using only numbers and dots. 
The comparator assumes only numeric versions are supplied, except for dot separators.
There is no limit in length of a string.

#### Some valid versioning examples
- 0.0.7
- 1.3.3.7
- 6.9
- 6.0.0.6.5

#### How to use
When sorting, just pass a comparator instance:
```java
List<String> list = new ArrayList<String>();
list.add("1.2.3.4");
list.add("1.0.2");
...
list.sort(new NumericalVersionComparator());
```
or just simply use the ```compare()``` method in ```NumericalVersionComparator``` as needed.
