package testing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    @Test
    public void testMoveRightBy() throws Exception {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRightBy(10);
        assertEquals(15, p2.getX());
        assertEquals(5, p2.getY());
    }

    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);

    @Test
    public void testComparingTwoPoints() throws Exception {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);

        int result = Point.compareByXAndThenY.compare(p1, p2);
        assertTrue(result < 0);
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x) {
        return points.stream()
                .map(p -> new Point(p.getX() + x, p.getY()))
                .collect(Collectors.toUnmodifiableList());
    }

    @Test
    public void testMoveAllPointsRightBy() throws Exception {
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);

        assertEquals(expectedPoints, newPoints);
    }
}
