package solve.pass

import model.cell.Cell
import parse.loadEasy
import solve.engine.SolveStep
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.fail

internal class NakedSingleTest {
  @Test
  fun test() {
    val board = loadEasy().first().first
    val markedBoard = MarkPossible(board).solve().board
    val step = NakedSingle(markedBoard).solve().takeUnless { it.noChanges } ?: fail()

    assertTrue(step.changedIndices.isNotEmpty())

    step.board.visitCells { args ->
      val cell = args.cell
      when (cell) {
        Cell.Empty     -> Unit
        is Cell.Multi  -> assertTrue(cell.size > 1)
        is Cell.Single -> Unit
      }
    }
  }
}
