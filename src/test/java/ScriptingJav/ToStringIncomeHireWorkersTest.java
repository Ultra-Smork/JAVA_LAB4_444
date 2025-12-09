package ScriptingJav;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ScriptingJav.Alive.Captain;
import ScriptingJav.Alive.Official;
import ScriptingJav.Alive.abstraction.Job;
import ScriptingJav.Alive.abstraction.Vibe;
import ScriptingJav.Objects.Plantation;
import ScriptingJav.Objects.abstraction.Size;
import ScriptingJav.Objects.abstraction.State;

/**
 * Comprehensive tests for toString(), getIncome(), and hireWorkers() methods
 */
public class ToStringIncomeHireWorkersTest {

    private Captain captain;
    private Official official;
    private Plantation plantation1;
    private Plantation plantation2;
    private Plantation plantation3;

    @BeforeEach
    void setUp() {
        // Create Captain with known values
        captain = new Captain();
        captain.name = "TestCaptain";
        captain.age = 35;
        captain.job = Job.Captain;
        captain.vibe = Vibe.Official;

        // Create Official with known values
        official = new Official();
        official.name = "TestOfficial";
        official.age = 42;
        official.job = Job.Official;
        official.vibe = Vibe.Practical;

        // Create Plantation instances with known data for testing
        Plantation.PlantationData data1 = new Plantation.PlantationData(
            "Test Plantation", Size.Medium, State.GOOD, "Wheat", 
            100.0, 20, 5000.0
        );
        Plantation.PlantationData data2 = new Plantation.PlantationData(
            "Another Plantation", Size.Large, State.PERFECT, "Corn", 
            150.0, 30, 8000.0
        );
        Plantation.PlantationData data3 = new Plantation.PlantationData(
            "Small Farm", Size.Small, State.RUSTY, "Barley", 
            50.0, 5, 1000.0
        );

        plantation1 = new Plantation(data1);
        plantation2 = new Plantation(data2);
        plantation3 = new Plantation(data3);
    }

    // ========== TOSTRING() TESTS ==========

    @Test
    void testToString_CaptainContainsAllFields() {
        // Test 1: toString() should contain all relevant fields for Captain
        String result = captain.toString();
        
        assertNotNull(result, "toString() should not return null");
        assertTrue(result.contains("Captain"), "Should contain class name");
        assertTrue(result.contains("TestCaptain"), "Should contain name");
        assertTrue(result.contains("35"), "Should contain age");
        assertTrue(result.contains("Captain"), "Should contain job");
        assertTrue(result.contains("Official"), "Should contain vibe");
    }

    @Test
    void testToString_OfficialFormatIsCorrect() {
        // Test 2: toString() should follow expected format for Official
        String result = official.toString();
        
        assertNotNull(result, "toString() should not return null");
        assertTrue(result.startsWith("Official{"), "Should start with class name");
        assertTrue(result.contains("name='TestOfficial'"), "Should contain name field");
        assertTrue(result.contains("age=42"), "Should contain age field");
        assertTrue(result.contains("job=Official"), "Should contain job field");
        assertTrue(result.contains("vibe=Practical"), "Should contain vibe field");
    }

    @Test
    void testToString_PlantationContainsAllData() {
        // Test 3: toString() should contain all relevant plantation data
        String result = plantation1.toString();
        
        assertNotNull(result, "toString() should not return null");
        assertTrue(result.contains("Плантация"), "Should contain plantation label");
        assertTrue(result.contains("Test Plantation"), "Should contain name");
        assertTrue(result.contains("Wheat"), "Should contain crop type");
        assertTrue(result.contains("20"), "Should contain workers count");
        assertTrue(result.contains("100"), "Should contain yield per acre (as 100 or 100.0)");
        assertTrue(result.contains("5000"), "Should contain wealth (as 5000 or 5000.0)");
        assertTrue(result.contains("Good"), "Should contain state");
    }

    @Test
    void testToString_DifferentObjectsProduceDifferentStrings() {
        // Test 4: Different objects should produce different toString() results
        String captainStr = captain.toString();
        String officialStr = official.toString();
        String plantationStr = plantation1.toString();
        
        assertNotEquals(captainStr, officialStr, "Different classes should have different toString()");
        assertNotEquals(captainStr, plantationStr, "Different classes should have different toString()");
        assertNotEquals(officialStr, plantationStr, "Different classes should have different toString()");
        
        // Same class with different data should also be different
        String plantation1Str = plantation1.toString();
        String plantation2Str = plantation2.toString();
        assertNotEquals(plantation1Str, plantation2Str, 
            "Plantations with different data should have different toString()");
    }

    // ========== GETINCOME() TESTS ==========

    @Test
    void testGetIncome_IncreasesWealth() {
        // Test 5: getIncome() should increase plantation wealth
        double initialWealth = plantation1.getWealth();
        
        plantation1.getIncome();
        
        double newWealth = plantation1.getWealth();
        assertTrue(newWealth > initialWealth, 
            "Wealth should increase after getIncome()");
    }

    @Test
    void testGetIncome_CalculationIsCorrect() {
        // Test 6: getIncome() should calculate income based on workers and state
        // Formula: workerEfficiency = workersCount * 15, stateBonus = state.getId() * 50
        // For plantation1: 20 workers, State.GOOD (id=5)
        // Expected: (20 * 15) + (5 * 50) = 300 + 250 = 550
        
        double initialWealth = plantation1.getWealth();
        plantation1.getIncome();
        double newWealth = plantation1.getWealth();
        
        double actualIncome = newWealth - initialWealth;
        double expectedIncome = (20 * 15) + (5 * 50); // 300 + 250 = 550
        
        assertEquals(expectedIncome, actualIncome, 0.01, 
            "Income should be calculated as (workers * 15) + (stateId * 50)");
    }

    @Test
    void testGetIncome_DifferentStatesProduceDifferentIncome() {
        // Test 7: Better states should produce more income
        // plantation2 has State.PERFECT (id=6), plantation3 has State.RUSTY (id=1)
        // plantation2: 30 workers * 15 + 6 * 50 = 450 + 300 = 750
        // plantation3: 5 workers * 15 + 1 * 50 = 75 + 50 = 125
        
        double initialWealth2 = plantation2.getWealth();
        double initialWealth3 = plantation3.getWealth();
        
        plantation2.getIncome();
        plantation3.getIncome();
        
        double income2 = plantation2.getWealth() - initialWealth2;
        double income3 = plantation3.getWealth() - initialWealth3;
        
        assertTrue(income2 > income3, 
            "Plantation with better state (PERFECT) should generate more income than RUSTY");
    }

    @Test
    void testGetIncome_MultipleCallsAccumulate() {
        // Test 8: Multiple calls to getIncome() should accumulate wealth
        double initialWealth = plantation1.getWealth();
        
        plantation1.getIncome();
        double wealthAfterFirst = plantation1.getWealth();
        double firstIncome = wealthAfterFirst - initialWealth;
        
        plantation1.getIncome();
        double wealthAfterSecond = plantation1.getWealth();
        double secondIncome = wealthAfterSecond - wealthAfterFirst;
        
        // Both incomes should be the same (same workers and state)
        assertEquals(firstIncome, secondIncome, 0.01, 
            "Each getIncome() call should add the same amount");
        
        // Total should be sum of both
        double totalIncome = wealthAfterSecond - initialWealth;
        assertEquals(firstIncome + secondIncome, totalIncome, 0.01, 
            "Multiple incomes should accumulate correctly");
    }

    // ========== HIREWORKERS() TESTS ==========

    @Test
    void testHireWorkers_IncreasesWorkerCount() {
        // Test 9: hireWorkers() should increase the worker count
        int initialWorkers = plantation1.getWorkersCount();
        int workersToHire = 5;
        
        plantation1.hireWorkers(workersToHire);
        
        int newWorkers = plantation1.getWorkersCount();
        assertEquals(initialWorkers + workersToHire, newWorkers, 
            "Worker count should increase by the hired amount");
    }

    @Test
    void testHireWorkers_MultipleHiresAccumulate() {
        // Test 10: Multiple calls to hireWorkers() should accumulate workers
        int initialWorkers = plantation1.getWorkersCount();
        
        plantation1.hireWorkers(3);
        int afterFirstHire = plantation1.getWorkersCount();
        assertEquals(initialWorkers + 3, afterFirstHire, 
            "First hire should add 3 workers");
        
        plantation1.hireWorkers(7);
        int afterSecondHire = plantation1.getWorkersCount();
        assertEquals(initialWorkers + 3 + 7, afterSecondHire, 
            "Second hire should add 7 more workers");
        
        plantation1.hireWorkers(2);
        int afterThirdHire = plantation1.getWorkersCount();
        assertEquals(initialWorkers + 3 + 7 + 2, afterThirdHire, 
            "Third hire should add 2 more workers, total should be sum of all hires");
    }

    // ========== UNCHECKED EXCEPTION HANDLING TESTS ==========

    @Test
    void testHireWorkers_ThrowsIllegalArgumentExceptionForZero() {
        // Test 11: hireWorkers() should throw IllegalArgumentException for zero workers
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> plantation1.hireWorkers(0),
            "hireWorkers(0) should throw IllegalArgumentException"
        );
        assertTrue(exception.getMessage().contains("положительным числом"),
            "Exception message should mention positive number requirement");
    }

    @Test
    void testHireWorkers_ThrowsIllegalArgumentExceptionForNegative() {
        // Test 12: hireWorkers() should throw IllegalArgumentException for negative workers
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> plantation1.hireWorkers(-5),
            "hireWorkers(-5) should throw IllegalArgumentException"
        );
        assertTrue(exception.getMessage().contains("положительным числом"),
            "Exception message should mention positive number requirement");
    }

    @Test
    void testHireWorkers_ExceptionHandlingWithTryCatch() {
        // Test 13: Demonstrate handling of unchecked exception with try-catch
        int initialWorkers = plantation1.getWorkersCount();
        boolean exceptionCaught = false;
        
        try {
            plantation1.hireWorkers(-10); // Это вызовет IllegalArgumentException
        } catch (IllegalArgumentException e) {
            exceptionCaught = true;
            assertNotNull(e.getMessage(), "Exception should have a message");
            System.out.println("Поймано unchecked исключение: " + e.getMessage());
        }
        
        assertTrue(exceptionCaught, "IllegalArgumentException should have been caught");
        // Количество рабочих не должно измениться после исключения
        assertEquals(initialWorkers, plantation1.getWorkersCount(),
            "Worker count should remain unchanged after exception");
    }
}

