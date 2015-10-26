# JaxbAndXsd

Copyright 2015 Derek Keogh
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

This application uses Jaxb, it's purpose is to read in an xml file containing data that is used to record a series of integers.
In this instance of the application I'm using it to store the solution to a sudoku puzzle. A simple main method loads the
xml data file and then output the contents to the console in a very basic 9 cell by 9 cell grid layout.

There is a matching xsd file that defines the xml layout.
```
1 2 3  4 5 6  7 8 9  
4 5 6  7 8 9  1 2 3  
7 8 9  1 2 3  4 5 6  

2 3 4  5 6 7  8 9 1  
5 6 7  8 9 1  2 3 4  
8 9 1  2 3 4  5 6 7  

6 7 8  9 1 2  3 4 5  
3 4 5  6 7 8  9 1 2  
9 1 2  3 4 5  6 7 8
```
Example of the xml:
```xml
<?xml version="1.0" encoding="UTF-8"?>
<p:grid xmlns:p="http://www.decoder.ie/namespaces" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.decoder.ie/namespaces Grid.xsd ">
  <p:XbyY p:length="0" p:width="0"/>
  <p:cell p:X="0" p:Y="1" p:index="0">
    <p:Value>1</p:Value>
  </p:cell>
  <p:cell p:X="0" p:Y="2" p:index="1">
    <p:Value>2</p:Value>
  </p:cell>
  <p:cell p:X="0" p:Y="3" p:index="2">
    <p:Value>3</p:Value>
  </p:cell>
  <p:cell p:X="0" p:Y="4" p:index="3">
    <p:Value>4</p:Value>
  </p:cell>
  .
  .
  .
    <p:cell p:X="0" p:Y="0" p:index="79">
    <p:Value>7</p:Value>
  </p:cell>
  <p:cell p:X="0" p:Y="0" p:index="80">
    <p:Value>8</p:Value>
  </p:cell>
</p:grid>
```
