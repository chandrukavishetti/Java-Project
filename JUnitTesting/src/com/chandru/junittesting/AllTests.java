package com.chandru.junittesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({SquareUnit.class,SumUnit.class})
public class AllTests {

}
