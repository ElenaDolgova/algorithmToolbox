package Coursera_2.Week_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static Coursera_2.Week_1.ComputeTreeHeight_2.doMain;

public class ComputeTreeHeight_2_Test {

    @Test
    public void test() {
        Assertions.assertEquals(6, doMain(List.of(8, 8, 5, 6, 7, 3, 1, 6, -1, 5)));
    }

    @Test
    public void test1() {
        Assertions.assertEquals(3, doMain(List.of(4, -1, 4, 1, 1)));
    }

    @Test
    public void test2() {
        Assertions.assertEquals(4, doMain(List.of(-1, 0, 4, 0, 3)));
    }

    @Test
    public void test3() {
        Assertions.assertEquals(1, doMain(List.of(-1)));
    }

    @Test
    public void test4() {
        Assertions.assertEquals(0, doMain(List.of()));
    }

    @Test
    public void test5() {
        Assertions.assertEquals(
                11,
                doMain(List.of(
                        32, 7, 51, 65, 35, 72, 63, 84, 60, 87, 33, 24, 43,
                        86, 9, 68, 26, 64, 6, 43, 32, 35, 18, 82, 33, 75, 94,
                        19, 59, 12, 54, 29, 75, -1, 12, 12, 58, 7, 17, 60, 75,
                        95, 64, 95, 51, 76, 50, 87, 53, 65, 10, 33, 46, 93, 64,
                        82, 5, 80, 10, 12, 12, 50, 87, 59, 68, 50, 42, 95, 10,
                        9, 43, 64, 33, 36, 20, 95, 75, 42, 75, 15, 59, 50, 4,
                        41, 43, 18, 43, 83, 72, 81, 1, 43, 1, 60, 43, 68, 93,
                        63, 95, 63
                ))
        );
    }
}
