[![Build Status](https://travis-ci.org/farbodsafaei/version-number-comparator.svg?branch=master)](https://travis-ci.org/farbodsafaei/version-number-comparator)
# version-number-comparator

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
