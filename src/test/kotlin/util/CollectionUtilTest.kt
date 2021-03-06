package util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

val matrix = (
    "864" + "371" + "259" +
        "325" + "849" + "761" +
        "971" + "265" + "843" +

        "436" + "192" + "587" +
        "198" + "657" + "432" +
        "257" + "483" + "916" +

        "689" + "734" + "125" +
        "713" + "528" + "694" +
        "542" + "916" + "378").map { it.digitToInt() }

internal class CollectionUtilTest {
  @Test
  fun groupBy9() {
    val cells = (1..9 * 9).toList()

    assertEquals(cells, cells.groupBy9().flatten())
  }

  @Test
  fun transpose() {
    assertEquals(matrix.groupBy9(), matrix.groupBy9().transpose().transpose())
  }

  @Test
  fun rotateClockwise() {
    assertEquals(matrix.groupBy9(), matrix.groupBy9().rotateCW().rotateCW().rotateCW().rotateCW())
  }

  @Test
  fun quadrant() {

    val quadrant0 = "864" + "325" + "971"
    assertEquals(quadrant0.map { it.digitToInt() }, matrix.quadrant(0))

    val quadrant1 = "371" + "849" + "265"
    assertEquals(quadrant1.map { it.digitToInt() }, matrix.quadrant(1))

    val quadrant2 = "259" + "761" + "843"
    assertEquals(quadrant2.map { it.digitToInt() }, matrix.quadrant(2))

    val quadrant3 = "436" + "198" + "257"
    assertEquals(quadrant3.map { it.digitToInt() }, matrix.quadrant(3))

    val quadrant4 = "192" + "657" + "483"
    assertEquals(quadrant4.map { it.digitToInt() }, matrix.quadrant(4))

    val quadrant5 = "587" + "432" + "916"
    assertEquals(quadrant5.map { it.digitToInt() }, matrix.quadrant(5))

    val quadrant6 = "689" + "713" + "542"
    assertEquals(quadrant6.map { it.digitToInt() }, matrix.quadrant(6))

    val quadrant7 = "734" + "528" + "916"
    assertEquals(quadrant7.map { it.digitToInt() }, matrix.quadrant(7))

    val quadrant8 = "125" + "694" + "378"
    assertEquals(quadrant8.map { it.digitToInt() }, matrix.quadrant(8))
  }

  @Test
  fun quadrantsToRows() {
    val cells = (0 until 9 * 9).toList()
    assertEquals(cells, cells.groupBy9().rowsToQuadrants().quadrantsToRows().flatten())
  }
}
