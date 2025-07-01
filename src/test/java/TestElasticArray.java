/*
 * Requirement: ElasticArrayTest
 *
 * Overview:
 * This test suite verifies the correctness, robustness, and resizing behavior of the ElasticArray class.
 * The tests cover normal usage, dynamic resizing, and invalid input handling. The goal is to ensure
 * that ElasticArray behaves like a safe, extendable integer array with predictable expansion logic.
 */

/*
 * Test: testWriteWithinInitialCapacity
 *
 * Writes to an index within the initial capacity (50).
 * Verifies that the value is correctly stored and retrieved.
 * Confirms normal operation without triggering a resize.
 */

/*
 * Test: testWriteTriggersResize
 *
 * Writes to an index well beyond the current capacity.
 * Confirms that resizing occurs in chunkSize steps (500).
 * Verifies the value is stored at the correct position after resizing.
 * Ensures internal capacity is updated appropriately.
 */

/*
 * Test: testNegativeWriteThrows
 *
 * Attempts to write to a negative index.
 * Verifies that an IllegalArgumentException is thrown.
 * Confirms invalid access is rejected early.
 */

/*
 * Test: testNegativeReadThrows
 *
 * Attempts to read from a negative index.
 * Verifies that an IndexOutOfBoundsException is thrown.
 * Ensures boundary checks are enforced on read operations.
 */

/*
 * Test: testReadWithoutWriteThrows
 *
 * Attempts to read from an index equal to the current capacity before resizing.
 * Verifies that an IndexOutOfBoundsException is thrown since no resize has occurred yet.
 * Tests that reads do not silently succeed outside bounds.
 */
